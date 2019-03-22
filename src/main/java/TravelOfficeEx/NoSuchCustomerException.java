package main.java.TravelOfficeEx;

public class NoSuchCustomerException extends Exception {
    public NoSuchCustomerException(){}
    public NoSuchCustomerException(String message){
        super(message);
    }
}
