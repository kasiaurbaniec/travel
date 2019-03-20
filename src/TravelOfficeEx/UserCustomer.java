package TravelOfficeEx;

public interface UserCustomer {
    Customer addCustomer();
    Trip addTrip();
    void assign();
    boolean removeCustomer();
    boolean removeTrip();
    void showTrip();
    void showCustomers();
}
