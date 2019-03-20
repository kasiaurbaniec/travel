package TravelOfficeEx;



public class Test {
    public static void main(String[] args) {
        Customer cust1 = new Customer("Kasia");
        Customer cust2 = new Customer("Ela");
        Customer cust3 = new Customer("Stasiek");
        Address addres1 = new Address("Wolności", "178", "Rędziny", "42-242");
        cust1.setAddress(addres1);
        cust2.setAddress(addres1);
        cust3.setAddress(addres1);

        Date start = new Date(2015, 7, 23);
        Date end = new Date(2017, 7, 11);
        Trip trip = new Trip(start, end, "round The world");
        cust1.assignTrip(trip);
trip.setPrice(2300);

        TravelOffice travelOffice = new TravelOffice();

        System.out.println(travelOffice.toString());
        System.out.println(travelOffice.getCustomerCount());

        DomesticTrip dtrip=new DomesticTrip(new Date(2019,12,7),new Date (2019,12,12),"Łazy");
        AbroadTrip abroadTrip=new AbroadTrip(start,end,"Afryka dzika");
        dtrip.setPrice(2200);
        abroadTrip.setPrice(5000);
        cust1.assignTrip(dtrip);
        cust2.assignTrip(abroadTrip);
        cust3.assignTrip(trip);
        travelOffice.addCustomer(cust1);
        travelOffice.addCustomer(cust2);
        travelOffice.addCustomer(cust3);

        travelOffice.addCustomer(cust3);
        System.out.println(travelOffice.toString());
        System.out.println(travelOffice.getCustomerCount());

    }
}
