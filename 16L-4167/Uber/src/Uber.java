import users.Customer;
import users.Driver;
import users.User;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Uber {

    static List<Driver> drivers=new ArrayList<Driver>();
    static List<Customer> customers=new ArrayList<Customer>();


    public static void main(String[] args) throws InterruptedException {

        Driver d=new Driver("ahmed","lxl-6619","cultus",1,10.5);
        drivers.add(d);
        d=new Driver("ali","LER-5065","civic",2,40.34);
        drivers.add(d);
        d=new Driver("yasir","LEK-955","mehran",1,30.2);
        drivers.add(d);
        Customer c=new Customer("arsil",30.2);
        customers.add(c);
        c=new Customer("husnain",9.5);
        customers.add(c);
        c=new Customer("shan",15.2);
        customers.add(c);

        Customer customer=login(customers);
        if(customer!=null)
        {
            System.out.println("do you want to take a ride? y/n");
            Scanner scanner=new Scanner(System.in);
            if(scanner.next().contains("y"))
            {
                System.out.println("finding your ride...");
                Thread.sleep(3000);
                Ride ride=new Ride();
                ride.setCustomer(customer);
                ride.setDriver(findRide(drivers,customer));
                ride.setDistance(10);
                System.out.println("your ride info:");
                System.out.println("name : "+ride.getDriver().getName());
                System.out.println("vehicle registration number : "+ride.getDriver().getVehicle().getRegistrationNumber());
                System.out.println("vehicle model : "+ride.getDriver().getVehicle().getModel());
                System.out.println("driver's rating : "+ride.getDriver().getRating());
                System.out.println("    ");
                System.out.println("confirm your pick...y/n...");
                if(scanner.next().contains("y"))
                {
                    System.out.println("starting your ride....");
                    Thread.sleep(2000);
                    System.out.println("on the way....");
                    Thread.sleep(3000);
                    System.out.println("reached...");
                    System.out.println("generating invoice...");
                    Thread.sleep(2000);
                    System.out.println(ride.generateInvoice());
                    System.out.println("give rating to your driver 1 to 5");
                    ride.getDriver().setRating(ride.getCustomer().giveRating());
                    System.out.println("give your feedback");
                    ride.getDriver().setFeedbacks(ride.getCustomer().giveFeedback());
                    ride.getDriver().setRidesCompleted();
                    System.out.println("thank you for riding with us...good bye...");
                    return;
                }
                else
                {
                    System.out.println("come back when you have to go somewhere...exiting");
                    return;
                }

            }
            else
            {
                System.out.println("come back when you have to go somewhere...exiting");
                return;
            }
        }
        else{
            System.out.println("failed to give identity....exiting...");
        }

    }

    public static Customer login(List<Customer> customers) {
        System.out.println("give identity as name");
        String name;
        Scanner scanner=new Scanner(System.in);
        name=scanner.nextLine();
        for(int i=0;i<customers.size();i++)
        {
            if(name.contains(customers.get(i).getName()))
            {
                Customer customer=customers.get(i);
                return customer;
            }
        }
        return null;
    }

    public static Driver findRide(List<Driver> drivers,Customer customer) {
        int min=0;
        for(int i=1;i<drivers.size();i++)
        {
            if(abs(customer.getLocation()-drivers.get(i).getLocation())<abs(customer.getLocation()-drivers.get(min).getLocation())&&drivers.get(i).isAvailable())
            {
                min=i;
            }
        }
        return drivers.get(min);
    }
}
