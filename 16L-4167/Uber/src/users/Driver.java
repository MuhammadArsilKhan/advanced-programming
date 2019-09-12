package users;

import java.util.ArrayList;
import java.util.List;
import users.User;
import vehicle.UberGo;
import vehicle.UberMini;
import vehicle.Vehicle;

public class Driver extends User {
    int ridesCompleted;
    float rating;
    List<String> feedbacks;
    boolean available;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    Vehicle vehicle;

    public Driver(String name,String registrationNumber,String model,int vehicleType,double location) {
        super(name,location);
        if(vehicleType==1)
        {
            this.vehicle=new UberMini(registrationNumber,model);
        }
        if(vehicleType==2)
        {
            this.vehicle=new UberGo(registrationNumber,model);
        }
        this.available=true;
        this.rating=5;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<String> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(String feedbacks) {
        if(this.feedbacks==null)
        {
            this.feedbacks=new ArrayList<String>();
        }
        this.feedbacks.add(feedbacks);
    }

    public int getRidesCompleted() {
        return ridesCompleted;
    }

    public void setRidesCompleted() {
        this.ridesCompleted++;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = ((this.rating*this.ridesCompleted)+(rating)/(this.ridesCompleted+1));
    }

}
