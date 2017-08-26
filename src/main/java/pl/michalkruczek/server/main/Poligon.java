package pl.michalkruczek.server.main;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by mikr on 20/08/17.
 */
public class Poligon {

    public static void main(String[] args) {
        Date date = new Date();

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 15);

        date = c.getTime();


        System.out.println(date);
    }

}
