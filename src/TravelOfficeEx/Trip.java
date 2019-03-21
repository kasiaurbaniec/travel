package TravelOfficeEx;


import java.time.LocalDate;

public class Trip {
    private LocalDate start;
    private LocalDate end;
    private String desctription;
    private int price=0;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Trip(LocalDate start, LocalDate end, String desctription) {
        this.start = start;
        this.end = end;
        this.desctription = desctription;
    }


    public Trip() {
    }

    public String getDesctription() {
        return desctription;
    }



    public String toString(){
        return " destination: "+getDesctription()+" from "+start.toString()+" to  "+end.toString()+" price: "+getPrice();
    }

}
