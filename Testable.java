public class Testable {
    
    public double carMSRP;
    public int carYear;
    public String carManufacturer;
    public String carModel;
    public String vehicleType;
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

    public double calculateCurrentPrice(int currentYear){

        int age = currentYear - (carYear - 1);
        double price;
        double modifier;
        if(this.vehicleType.contentEquals(carType.TRUCK) || this.vehicleType.contentEquals(carType.SUV)){
            modifier = 1.0;
        }
        else if(this.vehicleType.contentEquals(carType.MOTORCYCLE)){
            modifier = 0.9;
        } 
        else if(this.vehicleType.contentEquals(carType.CAR) || this.vehicleType.contentEquals(carType.VAN)){
            modifier = 0.8;
        }

        if (age < 0){
            throw Exception("Cannot have a future car.");
        } 
        if(age < 3){
            price = this.carMSRP * (1 - (age * 0.08));
        } else if (age < 7) {
            price = this.carMSRP * (1 - (3 * 0.08) - ((age - 3)* 0.12));
        } else if (age > 6){
            price = this.carMSRP * (1 - (3 * 0.08) - ((age - 3)* 0.12) - ((age-6) * 0.05));
        }
        return price * modifier;

    }

    public double findCurrentDepreciationPercent(int currentYear){
        return calculateCurrentPrice(currentYear)/this.carMSRP;
    }

    public void setHadAccident(boolean setHadAccident){
        this.hadAccident = setHadAccident;
    }

    public boolean getHadAccident(){

        return this.hadAccident;
    }

    private enum carType { 
        CAR, SUV, TRUCK, VAN, MOTORCYCLE; 
    }

    
}
