package manager;

import model.Hotel;
import model.Room;

import util.Values;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomManager
{
    private List<Room> rooms = new ArrayList<>();
    private Scanner scanner;
    private HotelManager hotelManager;

    public RoomManager(Scanner scanner, HotelManager hotelManager)
    {
        this.scanner = scanner;
        this.hotelManager = hotelManager;
    }

    public void addRoom()
    {
        System.out.println("Hotel name to add room:");
        String hotelName = scanner.nextLine();
        Hotel hotel = hotelManager.getHotelByName(hotelName);
        if (hotel == null)
        {
            System.out.println("Hotel not found.");
            return;
        }

        System.out.println("Room Number:");
        String number = scanner.nextLine();
        System.out.println("Type (single/couple/premium):");
        String type = scanner.nextLine();

        if (!Values.PRICES.containsKey(type))
        {
            System.out.println("Invalid room type.");
            return;
        }

        for (Room r : rooms)
        {
            if (r.getHotelName().equalsIgnoreCase(hotelName) && r.getNumber().equals(number))
            {
                System.out.println("Room already exists in this hotel.");
                return;
            }
        }

        Room room = new Room(hotelName, number, type, Values.PRICES.get(type));
        rooms.add(room);
        System.out.println("Room added successfully.");
    }

    public void listRooms()
    {
        System.out.println("Hotel name to list rooms:");
        String hotelName = scanner.nextLine();
        boolean found = false;
        for (Room r : rooms)
        {
            if (r.getHotelName().equalsIgnoreCase(hotelName))
            {
                System.out.println(r);
                found = true;
            }
        }
        if (!found)
        {
            System.out.println("No rooms found for this hotel.");
        }
    }

    public Room getAvailableRoom(String hotelName, String number)
    {
        for (Room r : rooms)
        {
            if (r.getHotelName().equalsIgnoreCase(hotelName) && r.getNumber().equals(number) && r.isAvailable())
            {
                return r;
            }
        }
        return null;
    }

    public Room getRoom(String hotelName, String number)
    {
        for (Room r : rooms)
        {
            if (r.getHotelName().equalsIgnoreCase(hotelName) && r.getNumber().equals(number))
            {
                return r;
            }
        }
        return null;
    }

    public List<Room> getRoomsByHotel(String hotelName)
    {
        List<Room> result = new ArrayList<>();
        for (Room r : rooms)
        {
            if (r.getHotelName().equalsIgnoreCase(hotelName))
            {
                result.add(r);
            }
        }
        return result;
    }
}