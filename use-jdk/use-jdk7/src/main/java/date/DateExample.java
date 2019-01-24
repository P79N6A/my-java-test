package date;

import java.util.Date;

/**
 * 17/1/13.
 */
public class DateExample {
    public static void main(String[] args) {
        System.out.println(new Date(System.currentTimeMillis()));
        {
            Date date = new Date();
            System.out.println(date);
            date.setSeconds(0);
            date.setHours(0);
            date.setMinutes(0);
            date.setDate(date.getDate() - 3);
            System.out.println(date);
            System.out.println(date.getTime());
        }
        {
            long timestamp = System.currentTimeMillis();
            System.out.println(timestamp);
            Date date = new Date(timestamp);
            System.out.println(date);
            System.out.println(date.getTime());
        }
        {
            Date date = new Date(1484150400000L - 2 * 24 * 60 * 60 * 1000);
            System.out.println(
                    date.getTime());
            System.out.println(date);
        }

    }
}
