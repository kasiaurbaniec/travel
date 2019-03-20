package TravelOfficeEx;

public class Date {
    int day;
    int month;
    int year;

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Date" +
                " " + day +
                "-" + month +
                "-" + year ;
    }

    public static Date of(String str) {
        char regg = str.charAt(2);
        String reg = Character.toString(regg);
        String[] dateTab = str.split(reg);
        int d = Integer.parseInt(dateTab[0]);
        int m = Integer.parseInt(dateTab[1]);
        int y = Integer.parseInt(dateTab[2]);
        return new Date(y, m, d);
    }

    public Date(int y, int m, int d) {
        day = d;
        month = m;
        year = y;

    }
}
