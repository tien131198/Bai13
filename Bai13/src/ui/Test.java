package ui;

import exception.BirthDayException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/* Welcome to project
    @author: tienb
    Date: 11/6/2022
    Time: 3:37 PM
    
    ProjectName: Bai13
*/public class Test {
    public static LocalDate insertDate(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        System.out.println("Enter date:");
        LocalDate date;
            date = LocalDate.parse(scanner.nextLine(), formatter);
        return null;
    }

    public static void main(String[] args) {
        insertDate(new Scanner(System.in));

    }
}
