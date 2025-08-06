package manager;

import model.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelManager
{
    private List<Hotel> hotels = new ArrayList<>();
    private Scanner scanner;

    public HotelManager(Scanner scanner)
    {
        this.scanner = scanner;
    }

    public void addHotel()
    {
        System.out.println("Hotel Name:");
        String name = scanner.nextLine();
        System.out.println("Address:");
        String address = scanner.nextLine();
        System.out.println("Description:");
        String description = scanner.nextLine();

        for (Hotel h : hotels)
        {
            if (h.getName().equalsIgnoreCase(name))
            {
                System.out.println("This hotel already exists.");
                return;
            }
        }

        hotels.add(new Hotel(name, address, description));
        System.out.println("Hotel added successfully.");
    }

    public void listHotels()
    {
        if (hotels.isEmpty())
        {
            System.out.println("No hotels registered.");
        }
        else
        {
            int i = 1;
            for (Hotel h : hotels)
            {
                System.out.println("\nHotel " + (i++) + ":");
                System.out.println(h);
            }
        }
    }

    public Hotel getHotelByName(String name)
    {
        for (Hotel h : hotels)
        {
            if (h.getName().equalsIgnoreCase(name))
            {
                return h;
            }
        }
        return null;
    }
}
