package TravelOfficeEx;



public class Trip {
    private Date start;
    private Date end;
    private String desctription;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Trip(Date start, Date end, String desctription) {
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
        return " desctription: "+getDesctription()+" from "+start.toString()+" to  "+end.toString()+" price: "+price;
    }

}
