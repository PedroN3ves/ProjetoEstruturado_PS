package app;

import manager.HotelManager;
import manager.RoomManager;
import manager.CustomerManager;
import manager.BookingManager;
import manager.ReviewManager;
import manager.AnalyticsManager;

import util.CustomerSupport;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        HotelManager hotelManager = new HotelManager(scanner);
        RoomManager roomManager = new RoomManager(scanner, hotelManager);
        CustomerManager customerManager = new CustomerManager(scanner);
        BookingManager bookingManager = new BookingManager(scanner, customerManager, roomManager);
        ReviewManager reviewManager = new ReviewManager(scanner);
        AnalyticsManager analyticsManager = new AnalyticsManager(roomManager, scanner);

        while (true)
        {
            System.out.println("\n-------- HOTEL BOOKING SYSTEM --------");
            System.out.println("1. Add Hotel\n2. List Hotels\n3. Add Room\n4. List Rooms\n5. Create Customer Profile\n6. Book Room\n7. Cancel Booking\n8. Add Review\n9. Show Reviews\n10. Analytics Report\n11. Show Loyalty Points\n12. Customer Support\n13. Exit");
            System.out.println("--------------------------------------");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice)
            {
                case "1":
                    hotelManager.addHotel();
                    break;
                case "2":
                    hotelManager.listHotels();
                    break;
                case "3":
                    roomManager.addRoom();
                    break;
                case "4":
                    roomManager.listRooms();
                    break;
                case "5":
                    customerManager.createCustomer();
                    break;
                case "6":
                    bookingManager.bookRoom();
                    break;
                case "7":
                    bookingManager.cancelBooking();
                    break;
                case "8":
                    reviewManager.addReview();
                    break;
                case "9":
                    reviewManager.showReviews();
                    break;
                case "10":
                {
                    analyticsManager.showHotelAnalytics();
                    break;
                }
                case "11":
                    customerManager.showLoyaltyPoints();
                    break;
                case "12":
                    CustomerSupport.openSupportMenu();
                    break;
                case "13":
                {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
