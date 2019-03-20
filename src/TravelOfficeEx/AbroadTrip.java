package TravelOfficeEx;


public class AbroadTrip extends Trip {
    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    boolean insurance;

    public AbroadTrip(Date start, Date end, String desctription) {
        super(start, end, desctription);
    }

    @Override
    public int getPrice() {
        if(insurance==false){
        return super.getPrice();}
        else return super.getPrice()+200;
    }

    @Override
    public String toString() {
        return super.toString()+" insurance includec: "+insurance;
    }
}
