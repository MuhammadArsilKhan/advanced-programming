package vehicle;

public abstract class Vehicle {
    String registrationNumber;

    String model;

    int unitPrice;

    public Vehicle(String registrationNumber,String model,int unitPrice)
    {
        this.registrationNumber=registrationNumber;
        this.model=model;
        this.unitPrice=unitPrice;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


}
