package manager;

import model.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReviewManager
{
    private List<Review> reviews = new ArrayList<>();
    private Scanner scanner;

    public ReviewManager(Scanner scanner)
    {
        this.scanner = scanner;
    }

    public void addReview()
    {
        System.out.println("Customer email:");
        String email = scanner.nextLine();
        System.out.println("Hotel name:");
        String hotelName = scanner.nextLine();
        System.out.println("Rating (1-5):");
        int rating = Integer.parseInt(scanner.nextLine());
        System.out.println("Comment:");
        String comment = scanner.nextLine();

        reviews.add(new Review(email, hotelName, rating, comment));
        System.out.println("Review added.");
    }

    public void showReviews()
    {
        System.out.println("Hotel name to view reviews:");
        String hotelName = scanner.nextLine();
        boolean found = false;
        for (Review r : reviews)
        {
            if (r.getHotelName().equalsIgnoreCase(hotelName))
            {
                System.out.println(r);
                found = true;
            }
        }
        if (!found)
        {
            System.out.println("No reviews for this hotel.");
        }
    }
}
