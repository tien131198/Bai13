package ui;

import entity.*;
import exception.BirthDayException;
import exception.EmailException;
import exception.FullNameException;
import exception.PhoneException;
import service.EmployeeManager;
import service.ValidatorService;

import java.sql.SQLOutput;
import java.text.BreakIterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/* Welcome to project
    @author: tienb
    Date: 11/6/2022
    Time: 2:14 PM

    ProjectName: Bai13
*/public class UIManager {
    private EmployeeManager employeeManager = new EmployeeManager();

    // insert thong tin
    public void insert(int type, Scanner scanner) {
        Employee employee = null;
        String id = null;
        if (type == 0) {

            employee = insertExperience(scanner);
        }
        if (type == 1) {
            employee = insertFresher(scanner);
        }
        if (type == 2) {
            employee = insertIntern(scanner);
        }
        try {
            checkData(employee);
        } catch (BirthDayException e) {
            System.out.println("Enter Birthday fail");
            insert(type, scanner);
        } catch (PhoneException e) {
            System.out.println("Enter phone fail");
            insert(type, scanner);
        } catch (EmailException e) {
            System.out.println("Enter Email fail");
            insert(type, scanner);
        } catch (FullNameException e) {
            System.out.println("Enter Name fail");
            insert(type, scanner);
        }
        this.employeeManager.insert(employee);
    }

    // insert date
    public LocalDate insertDate(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        System.out.println("Enter date:");
        LocalDate date = LocalDate.parse(scanner.nextLine(), formatter);
        return date;
    }

    // insert certificate
    private List<Certificate> insertCertificate(Scanner scanner) {
        System.out.println("Enter Certificate:");
        System.out.println(" Number of Certificate");
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Certificate> certificateList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Certificate certificate = new Certificate();
            System.out.println("Enter Certificated" + i);
            System.out.println("Enter CertificatedID");
            certificate.setId(scanner.nextLine());
            System.out.println("Enter CertificateName");
            certificate.setName(scanner.nextLine());
            System.out.println("Enter CertificateRank");
            certificate.setRank(scanner.nextLine());
            System.out.println("Enter CertificateDate");
            certificate.setDate(insertDate(scanner));
            certificateList.add(certificate);
        }
        return certificateList;
    }

    private Employee insertEmployee(Scanner scanner) {
        Employee employee = new Employee();
        System.out.println("Enter ID:");
        employee.setId(scanner.nextLine());
        employee.setId(scanner.nextLine());
        System.out.println("Enter Name:");
        employee.setFullName(scanner.nextLine());
        System.out.println("Enter Phone");
        employee.setPhone(scanner.nextLine());
        System.out.println("Enter Email");
        employee.setEmail(scanner.nextLine());
        System.out.println("Enter Birthday");
        employee.setBirthday(insertDate(scanner));
        System.out.println("Enter Certificate");
        employee.setCertificates(insertCertificate(scanner));
        return employee;
    }

    // insert expercience
    private Experience insertExperience(Scanner scanner) {

        Employee employee = insertEmployee(scanner);
        System.out.println("Enter yearOfExperience");
        int yearOfExperience = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter proSkill");
        String proSkill = scanner.nextLine();
        Experience experience = new Experience(employee.getId(), employee.getFullName(), employee.getBirthday(),
                employee.getPhone(), employee.getEmail(), employee.getCertificates(), yearOfExperience, proSkill);
        return experience;
    }

    // insert intern
    private Intern insertIntern(Scanner scanner) {
        Employee employee = insertEmployee(scanner);
        System.out.println("Enter Majors");
        String major = scanner.nextLine();
        System.out.println("Enter Semester");
        int semester = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter universityName");
        String university = scanner.nextLine();
        Intern intern = new Intern(employee.getId(), employee.getFullName(), employee.getBirthday(), employee.getPhone(), employee.getEmail(), employee.getCertificates(), major, semester, university);
        return intern;
    }

    // insert Fresher
    private Fresher insertFresher(Scanner scanner) {
        Employee employee = insertEmployee(scanner);
        System.out.println("Enter graduation date");
        LocalDate graduationDate = insertDate(scanner);
        System.out.println("Enter graduation rank");
        String rank = scanner.nextLine();
        System.out.println("Enter graduation University name");
        String university = scanner.nextLine();
        Fresher fresher = new Fresher(employee.getId(), employee.getFullName(), employee.getBirthday(), employee.getPhone(), employee.getEmail(), employee.getCertificates(), graduationDate, rank, university);
        return fresher;
    }

    // sreach by ID
    public void searchEmployee(Scanner scanner) {
        System.out.println("Input ID to search:");
        String id = scanner.nextLine();
        Employee employee = this.employeeManager.findById(id);
        System.out.println(employee);

    }

    // delete by id
    public void delete(Scanner scanner) {
        System.out.println("Input ID to delete:");
        String id = scanner.nextLine();
        System.out.println(this.employeeManager.deleteById(id));
    }

    // show all employee
    public void showAllEmployee() {
        this.employeeManager.findAll().forEach(s -> System.out.println(s));
    }

    // check data
    private void checkData(Employee employee) throws BirthDayException, PhoneException, EmailException, FullNameException {
        ValidatorService.birthdayCheck(employee.getBirthday());
        ValidatorService.phoneCheck(employee.getPhone());
        ValidatorService.emailCheck(employee.getEmail());
        ValidatorService.nameCheck(employee.getFullName());
    }
}
