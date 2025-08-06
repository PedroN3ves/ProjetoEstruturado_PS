package manager;

import model.Room;
import model.Customer;
import model.Booking;
import util.PaymentProcessor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BookingManager
{
    private List<Booking> bookings = new ArrayList<>();
    private Scanner scanner;
    private CustomerManager customerManager;
    private RoomManager roomManager;

    public BookingManager(Scanner scanner, CustomerManager customerManager, RoomManager roomManager)
    {
        this.scanner = scanner;
        this.customerManager = customerManager;
        this.roomManager = roomManager;
    }

    public void bookRoom()
    {
        System.out.println("Customer email:");
        String email = scanner.nextLine();
        Customer customer = customerManager.getCustomerByEmail(email);
        if (customer == null)
        {
            System.out.println("Customer not found.");
            return;
        }

        System.out.println("Hotel name:");
        String hotelName = scanner.nextLine();
        System.out.println("Room number:");
        String roomNumber = scanner.nextLine();

        Room room = roomManager.getAvailableRoom(hotelName, roomNumber);
        if (room == null)
        {
            System.out.println("Room not available.");
            return;
        }

        double amount = room.getPrice();
        boolean paid = PaymentProcessor.processPayment(customer.getName(), amount);
        if (!paid) {
            System.out.println("Payment failed. Booking not completed.");
            return;
        }


        room.setAvailable(false);
        bookings.add(new Booking(email, hotelName, roomNumber));
        customerManager.addLoyaltyPoints(email, 10);
        System.out.println("Room " + roomNumber + " in " + hotelName + " booked successfully. Loyalty points: " + customerManager.getLoyaltyPoints(email));
    }

    public void cancelBooking()
    {
        System.out.println("Hotel name:");
        String hotelName = scanner.nextLine();
        System.out.println("Room number to cancel:");
        String roomNumber = scanner.nextLine();

        Iterator<Booking> iterator = bookings.iterator();
        while (iterator.hasNext())
        {
            Booking b = iterator.next();
            if (b.getHotelName().equalsIgnoreCase(hotelName) && b.getRoomNumber().equals(roomNumber))
            {
                Room room = roomManager.getRoom(hotelName, roomNumber);
                if (room != null)
                {
                    room.setAvailable(true);
                }
                iterator.remove();
                System.out.println("Booking cancelled.");
                return;
            }
        }
        System.out.println("Booking not found.");
    }
}
