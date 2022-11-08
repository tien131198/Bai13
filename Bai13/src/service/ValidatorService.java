package service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import exception.BirthDayException;
import exception.EmailException;
import exception.FullNameException;
import exception.PhoneException;

/* Welcome to project
    @author: tienb
    Date: 11/6/2022
    Time: 2:10 PM
    
    ProjectName: Bai13
*/public class ValidatorService {
    public static void birthdayCheck(LocalDate birthday) throws BirthDayException {
        try{
            LocalDate check = birthday;
        }catch(Exception e){
            throw new BirthDayException("format date not ok");
        }
    }
    public static void phoneCheck(String phone) throws PhoneException {
        if (phone.startsWith("0")){
            System.out.println("format phone ok");
        }else
            throw new PhoneException("format phone not ok");
    }
    public static void emailCheck(String email) throws EmailException {
        if (email.contains("@")){
            System.out.println("format email ok");
        }else
            throw new EmailException("format email not ok");
    }
    public static void nameCheck(String name) throws FullNameException {
        if(name.length() < 30){
            System.out.println("format name ok ");
        }else{
            throw  new FullNameException("format name not ok ");
        }
    }
}
