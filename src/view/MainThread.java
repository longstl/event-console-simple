package view;

import controller.EventController;

import java.util.Scanner;

public class MainThread {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        EventController eventController = new EventController();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.println("------------- Event Manager --------------");
            System.out.println("1. Add New Event.");
            System.out.println("2. View List Events");
            System.out.println("3. Find Event by Code Event.");
            System.out.println("4. Exit.");
            System.out.println("------------------------------------------");
            System.out.print("Please Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("------------ Add New Event --------------");
                    eventController.addEventController();
                    break;
                case 2:
                    System.out.println("------------ List Event -----------------");
                    eventController.printEventList();
                    break;
                case 3:
                    System.out.println("------------ Event Detail ---------------");
                    eventController.printEventByCode();
                    break;
                case 4:
                    System.out.println("Goodbye!!! See You Later.");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Your choice is wrong.");
                    System.out.print("Please re-enter your choice: ");
                    break;
            }
        }
    }
}
