package TravelOfficeEx;



public class DomesticTrip extends Trip {
    @Override
    public int getPrice() {
        return super.getPrice()/2;
    }

    public DomesticTrip(Date start, Date end, String desctription) {
        super(start, end, desctription);
    }
}
