import users.Customer;
import users.Driver;

public class Ride {
    Driver driver;
    Customer customer;
    int distance;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int generateInvoice() {
        int invoice=0;
        invoice=(driver.getVehicle().getUnitPrice()*distance);
        invoice=invoice-((customer.getDiscountPercent()*invoice)/100);
        return invoice;
    }
}
