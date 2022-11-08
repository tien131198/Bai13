import ui.UIManager;

import java.util.Scanner;

/* Welcome to project
    @author: tienb
    Date: 11/6/2022
    Time: 5:54 PM
    1
    ProjectName: Bai13
*/public class Main {
    public static void main(String[] args) {
        UIManager uiManager = new UIManager();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Application");
            System.out.println("Enter 1: To insert");
            System.out.println("Enter 2: To search by Id");
            System.out.println("Enter 3: To show all");
            System.out.println("Enter 4: To exit");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":{
                    System.out.println("Enter 0: To insert Experience");
                    System.out.println("Enter 1: To insert Fresher");
                    System.out.println("Enter 2: To insert Intern");
                    int type = scanner.nextInt();
                    scanner.nextLine();
                    uiManager.insert(type, scanner);
                    break;
                }
                case "2":{
                    uiManager.searchEmployee(scanner);
                    break;
                }
                case "3":{
                    uiManager.showAllEmployee();
                    break;
                }
                case "4":{
                    System.out.println("Exit");
                    System.exit(0);
                }
                default:
                    break;

            }
        }
    }
}
