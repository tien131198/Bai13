package entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/* Welcome to project
    @author: tienb
    Date: 11/6/2022
    Time: 1:16 PM
    
    ProjectName: Bai13
*/public class Intern extends Employee{
    private String major;
    private int semester;
    private String universityName;
    public Intern(){

    }

    public Intern(String major, int semester, String universityName) {
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
    }

    public Intern(String id, String fullName, LocalDate birthday, String phone, String email, List<Certificate> certificates, String major, int semester, String universityName) {
        super(id, fullName, birthday, phone, email, certificates);
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public void showInformation() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Intern{" +
                "major='" + major + '\'' +
                ", semester=" + semester +
                ", universityName='" + universityName + '\'' +
                ", id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", certificates=" + certificates +
                '}';
    }
}
