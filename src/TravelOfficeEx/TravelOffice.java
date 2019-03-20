package TravelOfficeEx;

public class TravelOffice {
    int customerCount = 0;
    Customer[] listOfCustomer = new Customer[2];

    public void addCustomer(Customer customer) {
        if (customerCount == 0) {
            listOfCustomer[0] = customer;
            customerCount++;
        } else if
        (customerCount == 1) {
            listOfCustomer[1] = customer;
            customerCount++;
        } else {
            Customer[] copiedList = new Customer[getCustomerCount() + 2];
            System.arraycopy(listOfCustomer, 0, copiedList, 0, listOfCustomer.length);
            copiedList[listOfCustomer.length] = customer;
            listOfCustomer = copiedList;
            customerCount++;
        }

    }

    public int getCustomerCount() {
        return customerCount;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Zarejestrowani klienci:");
        sb.append("\n");
        for (Customer customer : listOfCustomer) {
            if (null == customer) continue;
            sb.append(customer.toString());
            sb.append("\n");
        }
        return sb.toString();

    }

}
