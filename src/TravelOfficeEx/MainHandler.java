package TravelOfficeEx;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Logger;

public class MainHandler implements UserCustomer {
    TravelOffice to = new TravelOffice();
    Scanner scanner = new Scanner(System.in);
    private static Logger logger = Logger.getLogger("TravelOffice");


    public void printMenu() {
        System.out.println();
        System.out.println("1-Dodaj klienta");
        System.out.println("2-Dodaj wycieczkę");
        System.out.println("3-Przypisz wycieczkę do klienta");
        System.out.println("4-Usuń klienta");
        System.out.println("5-Usuń wycieczkę");
        System.out.println("6-Pokaż klientów");
        System.out.println("7-Pokaż wycieczki");
        System.out.println("8-Wyjdz");
    }

    public void run() {
        int option;
        do {
            printMenu();
            option = scanner.nextInt();
            if (option == 1) {
                addCustomer();
            } else if (option == 2) {
                addTrip();
            } else if (option == 3) {
                assign();
            } else if (option == 4) {
                removeCustomer();
            } else if (option == 5) {
                removeTrip();
            } else if (option == 6) {
                showCustomers();
            } else if (option == 7) {
                showTrip();
            } else if (option == 8) {
                System.out.println("exit");
            } else System.out.println("wrong number");

        } while (option != 8);
    }

    @Override
    public Customer addCustomer() {
        logger.info("start to add new customer");
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
        logger.info("new address was successfully created");
        Customer customer = new Customer(name);
        customer.setAddress(address);
        logger.info("customer has addres");
        to.addCustomer(customer);
        logger.info("customer was created and added to list");

        return customer;
    }

    @Override
    public Trip addTrip() {
        logger.info("start do create new trip");
        Trip trip = null;
        System.out.println("give id for new trip");
        String name = scanner.next();
        System.out.println("give destination of a trip");
        String desc = scanner.next();
        LocalDate startDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        do {
            System.out.println("give begin date: yyyy-mm-dd");
            String dateStr = scanner.next();
            startDate = LocalDate.parse(dateStr, formatter);
        }
        while (startDate == null);
        LocalDate endDate;
        do {
            System.out.println("give date when it end, yyyy-mm-dd");
            String dateStrEnd = scanner.next();
            endDate = LocalDate.parse(dateStrEnd, formatter);
        } while (endDate == null);
        System.out.println("give price");
        int price = scanner.nextInt();
        System.out.println("type domestic/abroad");
        String domest = scanner.next();
        if (domest.startsWith("d")) {
            System.out.println("own arrival discount");
            int disc = scanner.nextInt();
            trip = new DomesticTrip(startDate, endDate, desc);
            trip.setPrice(price);
            ((DomesticTrip) trip).setOwnArrivalDiscount(disc);
            logger.info("discount included");
        } else {
            trip = new AbroadTrip(startDate, endDate, desc);
            trip.setPrice(price);
            System.out.println("add insurance? y/n ");
            String ins = scanner.next();
            if (ins.startsWith("y")) {
                ((AbroadTrip) trip).setInsurance(true);
                logger.info("insurance included");
            }
        }
        to.addTrip(name, trip);
       logger.info("new trip created and added to list");
        return trip;
    }

    @Override
    public void assign() {
        Customer customer = null;
        String clientName;
        String tripName;
        Trip trip;
        do {
            System.out.println("give client you want to assign a trip");
            clientName = scanner.next();
            try {
                customer = to.findCustomerByName(clientName);
                logger.info("customer found");
            } catch (NoSuchCustomerException e) {
                System.out.println(e.getMessage());
            }
        } while (customer == null);
        do {
            System.out.println("give name of trip you want to be assigned");
            tripName = scanner.next();
            trip = to.getMapOfTrips().get(tripName);
            if (trip == null) {
                System.out.println("no such trip found");
                logger.warning("trip no exist");
            } logger.info("trip found");
        } while (trip == null);
        customer.assignTrip(trip);
        logger.info("trip assigned to customer");
    }

    //    @Override
//    public void assign() {
//        Customer customer;
//        String clientName;
//        String tripName;
//        Trip trip;
//        do {
//            System.out.println("give client you want to assign a trip");
//            clientName = scanner.next();
//            customer = to.findCustomerByName(clientName);
//            if (customer == null) {
//                System.out.println("no such customer");
//            } else System.out.println("customer found");
//        } while (customer == null);
//        do {
//            System.out.println("give name of trip you want to be assigned");
//            tripName = scanner.next();
//            trip = to.getMapOfTrips().get(tripName);
//            if (trip == null) {
//                System.out.println("no such trip found");
//            } else System.out.println("trip founded");
//        } while (trip == null);
//        customer.assignTrip(trip);
//        System.out.printf("\ntrip %s assigned to %s", tripName, clientName);
//    }
    @Override
    public boolean removeCustomer() {
        System.out.println("give name of customer to remove");
        String clientName = scanner.next();
        try {
            Customer cust = to.findCustomerByName(clientName);
            to.getSetOfCustomers().removeIf(x -> x.getName().startsWith(clientName));
            System.out.printf("\ncustomer %s removed", cust.getName());
        } catch (NoSuchCustomerException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
//    @Override
//    public boolean removeCustomer() {
//        System.out.println("give name of customer to remove");
//        String clientName = scanner.next();
//        Customer customer;
//        try {
//            customer = to.findCustomerByName(clientName);
//            to.removeCustomer(customer);
//        } catch (NoSuchCustomerException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return true;
//    }
//    @Override
//    public boolean removeCustomer() {
//        if (to.getCustomerCount() != 0) {
//            System.out.println("give name of customer to remove");
//            String clientName = scanner.next();
//            Customer customer = to.findCustomerByName(clientName);
//            if (customer == null) {
//                System.out.println("no such customer");
//                showCustomers();
//            } else System.out.println("customer found");
//            to.removeCustomer(customer);
//            System.out.printf("\n%s was removed", clientName);
//            return true;
//        } else System.out.println("empty list");
//        return false;
//    }

    @Override
    public boolean removeTrip() {
        System.out.println("give name of trip to remove");
        String tripName = scanner.next();
        try {
            to.removeTrip(tripName);
            System.out.println("trip removed ");
        } catch (NoSuchTripException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }


    //działając metoda bez wyjątków
//    @Override
//    public boolean removeTrip() {
//        if (!to.getMapOfTrips().isEmpty()) {
//            String tripName;
//            do {
//                System.out.println("give name of trip to remove");
//                tripName = scanner.next();
//                if (to.getMapOfTrips().containsKey(tripName)) {
//                    System.out.printf("\ntrip %s found ", tripName);
//                    to.removeTrip(tripName);
//                    System.out.printf("\ntrip %s removed ", tripName);
//                    return true;
//                } else {
//                    System.out.println("no such trip found");
//                    showTrip();
//                    return false;
//                }
//            } while (false);
//        } else
//            System.out.println("empty list");
//        return false;
//    }
    @Override
    public void showTrip() {
        to.showTrips();
    }

    @Override
    public void showCustomers() {
        to.showCustomers();
    }
}

