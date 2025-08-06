package util;

import java.util.Scanner;

public class CustomerSupport
{
    private static Scanner scanner = new Scanner(System.in);

    public static void openSupportMenu()
    {
        System.out.println("\n-------- Customer Support --------");
        System.out.println("Welcome to Hotel Booking Support!");
        System.out.println("How can we help you?");
        System.out.println("1. I have a problem with my booking\n2. I want to cancel my booking\n3. I didn’t receive a confirmation\n4. Talk to a support agent\n5. Exit support");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice)
        {
            case 1:
                System.out.println("Please verify your booking details in 'Show Bookings'. If the issue persists, contact support.");
                break;
            case 2:
                System.out.println("You can cancel your booking from the main menu option 'Cancel Booking'.");
                break;
            case 3:
                System.out.println("Check your email's spam folder. If you still didn’t receive it, contact support.");
                break;
            case 4:
                System.out.println("Connecting to a support agent...");
                System.out.println("All agents are currently busy. Please try again later.");
                break;
            case 5:
                System.out.println("Exiting support...");
                return;
            default:
                System.out.println("Invalid option.");
        }
    }
}
