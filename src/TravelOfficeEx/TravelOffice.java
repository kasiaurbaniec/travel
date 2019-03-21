package TravelOfficeEx;

import java.util.*;
import java.util.stream.Collectors;

public class TravelOffice {
//    int customerCount = 0;
//    Customer[] listOfCustomer = new Customer[2];


    private Set<Customer> setOfCustomers = new HashSet<>();
    private Map<String, Trip> mapOfTrips = new HashMap<>();

    public Set<Customer> getSetOfCustomers() {
        return setOfCustomers;
    }

    public Map<String, Trip> getMapOfTrips() {
        return mapOfTrips;
    }

    public void addCustomer(Customer customer) {
        setOfCustomers.add(customer);
//        if (customerCount == 0) {
//            listOfCustomer[0] = customer;
//            customerCount++;
//        } else if
//        (customerCount == 1) {
//            listOfCustomer[1] = customer;
//            customerCount++;
//        } else {
//            Customer[] copiedList = new Customer[getCustomerCount() + 2];
//            System.arraycopy(listOfCustomer, 0, copiedList, 0, listOfCustomer.length);
//            copiedList[listOfCustomer.length] = customer;
//            listOfCustomer = copiedList;
//            customerCount++;
//        }

    }

    //    public int getCustomerCount() {
//        return customerCount;
//    }
    public int getCustomerCount() {
        return setOfCustomers.size();
    }

    public String toString() {
        return "Customers: " + setOfCustomers.toString() + "\n" + "Trips: " + mapOfTrips.values().toString();
//        StringBuilder sb = new StringBuilder();
//        sb.append("Zarejestrowani klienci:");
//        sb.append("\n");
//        for (Customer customer : listOfCustomer) {
//            if (null == customer) continue;
//            sb.append(customer.toString());
//            sb.append("\n");
//        }
//        return sb.toString();

    }

    public void showTrips() {
        System.out.print("All trips: ");
        mapOfTrips.entrySet().forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));
    }
    //działająca metoda bez lamb
//    public void showTrips() {
//        System.out.print("All trips: ");
//        for (Map.Entry<String, Trip> trip : mapOfTrips.entrySet()
//        ) {
//            System.out.print("\n" + trip.getKey() + " ");
//            System.out.print(trip.getValue().toString());
//        }
//    }

    public void showCustomers() {
        setOfCustomers.forEach(x -> System.out.println(x.toString()));
    }

    public void addTrip(String id, Trip trip) {
        mapOfTrips.put(id, trip);
    }

    public boolean removeTrip(String id) throws NoSuchTripException {
        if (mapOfTrips.containsKey(id)) {
            mapOfTrips.remove(id);
            throw new NoSuchTripException("no such trip");
        }return true;
    }
    //działająca metoda bez wyjątków
//    public boolean removeTrip(String id) {
//        if (mapOfTrips.containsKey(id)) {
//            mapOfTrips.remove(id);
//            return true;
//        }  return false;
//    }


    public Customer findCustomerByName(String name) throws NoSuchCustomerException {
        for (Customer c : setOfCustomers) {
            if (c.getName().contains(name)) {
                return c;
            }
        }
        throw new NoSuchCustomerException("no such customer");
    }

    // działająca metoda bez wyjątkó
//    public boolean removeCustomer(Customer customer) {
//        if (setOfCustomers.contains(customer)) {
//            setOfCustomers.remove(customer);
//            return true;
//        } else
//            return false;
//    }
    public boolean removeCustomer(Customer customer) throws NoSuchCustomerException {
        if (setOfCustomers.contains(customer)) {
            setOfCustomers.remove(customer);

        }
        throw new NoSuchCustomerException("cannot remove");
    }
}





