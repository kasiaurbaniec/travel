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

    public String toString(){
        if(!trip.toString().isEmpty()&&(!address.toString().isEmpty()))
        {return "name: "+name+" \ntrip: "+trip.toString()+" \naddress: "+address.toString();}
        else {return "name: "+name;}
    }


}
