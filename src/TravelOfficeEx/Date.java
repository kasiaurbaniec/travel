package TravelOfficeEx;

import java.io.IOException;

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
                "-" + year;
    }

    public static Date of(String str, String separator) {
        String[] dateTab = str.split(separator);
        if (dateTab.length == 3) {
            int d = Integer.parseInt(dateTab[0]);
            int m = Integer.parseInt(dateTab[1]);
            int y = Integer.parseInt(dateTab[2]);
            return new Date(y, m, d);
        } else {
            return null;
        }
    }

    public Date(int y, int m, int d) {
        day = d;
        month = m;
        year = y;

    }
}
