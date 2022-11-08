package exception;

import java.time.format.DateTimeParseException;

/* Welcome to project
    @author: tienb
    Date: 11/6/2022
    Time: 2:06 PM
    
    ProjectName: Bai13
*/public class BirthDayException extends Exception {
    public BirthDayException(String message){
        super(message);
//        System.out.println("bat ok ");
    }
}
