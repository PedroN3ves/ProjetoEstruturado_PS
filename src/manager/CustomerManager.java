package manager;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CustomerManager
{
    private List<Customer> customers = new ArrayList<>();
    private Map<String, Integer> loyaltyPoints = new HashMap<>();
    private Scanner scanner;

    public CustomerManager(Scanner scanner)
    {
        this.scanner = scanner;
    }

    public void createCustomer()
    {
        System.out.println("Customer name:");
        String name = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();

        for (Customer c : customers)
        {
            if (c.getEmail().equalsIgnoreCase(email))
            {
                System.out.println("Customer already exists.");
                return;
            }
        }

        customers.add(new Customer(name, email));
        loyaltyPoints.put(email, 0);
        System.out.println("Customer profile created.");
    }

    public Customer getCustomerByEmail(String email)
    {
        for (Customer c : customers)
        {
            if (c.getEmail().equalsIgnoreCase(email))
            {
                return c;
            }
        }
        return null;
    }

    public void addLoyaltyPoints(String email, int points)
    {
        loyaltyPoints.put(email, loyaltyPoints.getOrDefault(email, 0) + points);
    }

    public int getLoyaltyPoints(String email)
    {
        return loyaltyPoints.getOrDefault(email, 0);
    }

    public void showLoyaltyPoints()
    {
        System.out.println("Customer email:");
        String email = scanner.nextLine();
        if (loyaltyPoints.containsKey(email))
        {
            System.out.println(email + " has " + loyaltyPoints.get(email) + " loyalty points.");
        }
        else
        {
            System.out.println("Customer not found or doesn't has any loyalty points yet");
        }
    }
}
