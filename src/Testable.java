package src;
import java.util.Scanner;

public class Testable {
    
    public double carMSRP;
    public int carYear;
    public String carManufacturer;
    public String carModel;
    public carType vehicleType;
    public boolean hadAccident;
     

    public Testable(double carMSRP, int carYear, String carManufacturer, String carModel, carType vehicleType){
        this.carMSRP = carMSRP;
        this.carYear = carYear;
        this.carManufacturer = carManufacturer;
        this.carModel = carModel;
        this.vehicleType = vehicleType;
        this.hadAccident = false;
    }

    public Testable(double carMSRP, int carYear, String carManufacturer, String carModel, carType vehicleType, boolean hadAccident){
        this.carMSRP = carMSRP;
        this.carYear = carYear;
        this.carManufacturer = carManufacturer;
        this.carModel = carModel;
        this.vehicleType = vehicleType;

        this.hadAccident = hadAccident;
    }

    public double calculateCurrentPrice(int currentYear) throws Testable.carException{

        int age = currentYear - (carYear - 1);
        double price = 0;
        double modifier = 0;
        if(this.vehicleType == carType.TRUCK || this.vehicleType == carType.SUV){
            modifier = 1.0;
        }
        else if(this.vehicleType == carType.MOTORCYCLE){
            modifier = 0.9;
        } 
        else if(this.vehicleType == carType.CAR || this.vehicleType == carType.VAN){
            modifier = 0.8;
        }

        if(getHadAccident() == true){
            modifier = modifier / 2;
        }

        if (age < 0){
            throw new carException("Cannot have a future car.");
        } 
        if(age < 3){
            price = carMSRP * (1 - (age * 0.08));
        } else if (age < 7) {
            price = carMSRP * (1 - (age * 0.1));
        } else if (age > 6){
            price = carMSRP * (1 - 0.5 - (age * 0.03));
        }
        if(price <= 0){
            price = 1000;
        }
        return price * modifier;

    }

    public double findCurrentDepreciationPercent(int currentYear){
        try {
            return calculateCurrentPrice(currentYear)/this.carMSRP;
        } catch(Exception e){
            return -0.01;
        }
    }

    public double findCurrentPriceFromUser(){

        System.out.println("Please Enter Current Year");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        sc.close();
        try {
            return calculateCurrentPrice(year);
        } catch(Exception e){
            return -0.01;
        }



        

        // Add user input. This we will mock.
    }

    public void setHadAccident(boolean setHadAccident){
        this.hadAccident = setHadAccident;
    }

    public boolean getHadAccident(){

        return this.hadAccident;
    }

    public enum carType { 
        CAR, SUV, TRUCK, VAN, MOTORCYCLE; 
    }

    class carException extends Exception {
        public carException(String message){
            super(message);
        }
    }
}
