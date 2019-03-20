package TravelOfficeEx;

public class Customer {
private String name;
private Address address;
private Trip trip;

    public Customer(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void assignTrip(Trip trip) {
        this.trip = trip;
    }

    public String toString() {
        if (trip==null){
            return "\nname: "+name+" \ntrip: none"+" \naddress: "+address.toString()+"\n";}
        else {
            return "\nname: "+name+" \ntrip: "+trip.toString()+" \naddress: "+address.toString()+"\n";}
    }


}
