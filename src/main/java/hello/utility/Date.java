package hello.utility;

import java.sql.Timestamp;

/**
 * Created by asabanovic on 7/14/15.
 */
public class Date {
    public static Timestamp now(){
        long time = System.currentTimeMillis();
        Timestamp date = new Timestamp(time);
        return date;
    }
}
