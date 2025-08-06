package util;

import java.util.Scanner;

public class PaymentProcessor
{
    private static Scanner scanner = new Scanner(System.in);

    public static boolean processPayment(String customerName, double amount)
    {
        System.out.println("\n===== Payment Processing =====");
        System.out.println("Customer: " + customerName);
        System.out.println("Amount to pay: R$ " + amount);
        System.out.println("Choose a payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PIX");
        System.out.println("3. Boleto");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice)
        {
            case 1:
                return processCreditCard();
            case 2:
                return processPIX();
            case 3:
                return processBoleto();
            default:
                System.out.println("Invalid payment method. Payment failed.");
                return false;
        }
    }

    private static boolean processCreditCard()
    {
        System.out.print("Enter card number: ");
        String cardNumber = scanner.nextLine();
        System.out.print("Enter expiration date (MM/YY): ");
        String expiry = scanner.nextLine();
        System.out.print("Enter CVV: ");
        String cvv = scanner.nextLine();
        System.out.println("Processing credit card payment...");
        System.out.println("Payment approved!");
        return true;
    }

    private static boolean processPIX()
    {
        System.out.println("PIX key: pagamentos@hotel.com");
        System.out.println("Waiting for payment confirmation...");
        System.out.println("Payment received via PIX!");
        return true;
    }

    private static boolean processBoleto()
    {
        System.out.println("Generating boleto...");
        System.out.println("Boleto generated. Please pay before the due date.");
        System.out.println("Payment confirmed for simulation purposes.");
        return true;
    }
}
