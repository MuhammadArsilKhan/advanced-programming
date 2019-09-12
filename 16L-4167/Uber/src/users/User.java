package users;

public abstract class User {

    String name;
    double location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLocation() {
        return location;
    }

    public void setLocation(double location) {
        this.location = location;
    }

    public User(String name,double location) {
        this.name=name;
        this.location=location;
    }

}
