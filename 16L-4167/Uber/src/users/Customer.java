package users;

import java.util.Scanner;

public class Customer extends User {
    int discountPercent;

    public Customer(String name ,double location)
    {
        super(name,location);
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String giveFeedback() {
        String feedback;
        Scanner scanner=new Scanner(System.in);
        feedback=scanner.nextLine();
        return feedback;
    }

    public int giveRating() {
        Scanner scanner=new Scanner(System.in);
        return scanner.nextInt();
    }

}
