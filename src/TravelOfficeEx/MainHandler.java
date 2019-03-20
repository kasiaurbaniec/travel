package TravelOfficeEx;


import java.util.Scanner;

public class MainHandler implements UserCustomer {
    TravelOffice to = new TravelOffice();
    Scanner scanner = new Scanner(System.in);

    public void printMenu() {
        System.out.println("1-Dodaj klienta");
        System.out.println("2-Dodaj wycieczkę");
        System.out.println("3-Przypisz wycieczkę do klienta");
        System.out.println("4-Usuń klienta");
        System.out.println("5-Usuń wycieczkę");
        System.out.println("6-Pokaż klientów");
        System.out.println("7-Pokaż wycieczki");
        System.out.println("8-Wyjdz");
    }

    public void selectOptions(int option) {
        switch (option) {
            case 1:
                addCustomer();
                break;
            case 2:
                addTrip();
                break;
            case 3:
                assign();
                break;
            case 4:
                removeCustomer();
                break;
            case 5:
                removeTrip();
                break;
            case 6:
                showTrip();
                break;
            case 7:
                showCustomers();
                break;
            case 8:
                System.out.println("The end");
                break;
            default:
                System.out.println("wrong command");
        }

    }

    @Override
    public Customer addCustomer() {
        System.out.println("Give customers name");
        String name = scanner.next();
        System.out.println("Give customers Address \n Street:");
        String street = scanner.next();
        System.out.println("Give customers street number");
        String streetNumber = scanner.next();
        System.out.println("Give customers city");
        String city = scanner.next();
        System.out.println("Give customers code");
        String code = scanner.next();
        Address address = new Address(street, streetNumber, city, code);
        Customer customer = new Customer(name);
        customer.setAddress(address);
        System.out.printf("\nNew customer %s was created", name);
        to.addCustomer(customer);
        return customer;
    }

    @Override
    public Trip addTrip() {
        System.out.println("give name for new trip");
        String name = scanner.next();
        System.out.println("give description of a trip");
        String desc = scanner.next();
        System.out.println("give date when it start, dd-mm-yyyy");
        String dateStr=scanner.next();
        Date startDate = Date.of(dateStr,"-");
        System.out.println("give date when it end, dd-mm-yyyy");
        String dateStrEnd=scanner.next();
        Date endDate = Date.of(dateStrEnd,"-");

        Trip trip = new Trip(startDate, endDate, desc);
        to.addTrip(name, trip);
        System.out.printf("\nnew trip named %s created",name);
        return trip;
    }

    @Override
    public void assign() {
        System.out.println("give client you want to assign a trip");
        String clientname = scanner.next();
        Customer customer = to.findCustomerByName(clientname);
        System.out.println("give name of trip you want to be assigned");
        String tripname = scanner.next();
        Trip trip = to.getMapOfTrips().get(tripname);
        customer.assignTrip(trip);
        System.out.printf("\ntrip 3%s assigned to %s", tripname, clientname);
    }

    @Override
    public boolean removeCustomer() {
        System.out.println("give name of customer to remove");
        String cusName = scanner.next();
        Customer customer = to.findCustomerByName(cusName);
        to.removeCustomer(customer);
        System.out.printf("\n%s was removed", cusName);
        return true;
    }

    @Override
    public boolean removeTrip() {
        System.out.println("give name of trip to remove");
        String tripName = scanner.next();
        to.removeTrip(tripName);
        System.out.printf("\n%s was removed", tripName);
        return true;
    }

    @Override
    public void showTrip() {
        to.getMapOfTrips();
    }

    @Override
    public void showCustomers() {
        to.getSetOfCustomers();
    }

}
