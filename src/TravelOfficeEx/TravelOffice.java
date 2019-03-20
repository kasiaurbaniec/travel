package TravelOfficeEx;

import java.util.*;

public class TravelOffice {
//    int customerCount = 0;
//    Customer[] listOfCustomer = new Customer[2];


    Set<Customer> setOfCustomers = new HashSet<>();
    Map<String, Trip> mapOfTrips = new HashMap<>();

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

//        StringBuilder sb = new StringBuilder();
//        sb.append("Zarejestrowani klienci:");
//        sb.append("\n");
//        for (Customer customer : listOfCustomer) {
//            if (null == customer) continue;
//            sb.append(customer.toString());
//            sb.append("\n");
//        }
//        return sb.toString();
        return "Customers: " + setOfCustomers.toString() + "\n" + "Trips: " + mapOfTrips.values().toString();
    }


    public void addTrip(String name, Trip trip) {
        mapOfTrips.put(name, trip);
    }

    public boolean removeTrip(String name) {
        if (mapOfTrips.containsKey(name)) {
            mapOfTrips.remove(name);
            return true;
        } else return false;
    }

    public Customer findCustomerByName(String name) {
        for (Customer c : setOfCustomers) {
            if (c.toString().contains(name)) {
                return c;
            }
        }
        return null;
    }

    public boolean removeCustomer(Customer customer) {
        if (setOfCustomers.contains(customer)) {
            setOfCustomers.remove(customer);
            return true;
        } else
            return false;
    }
}





