package laptrinhandroid.fpoly.dnnhm3;

import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormatDay {
     static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-d");
    public static Date ConvertStringToDateSql(String day){
        java.util.Date date = null;
        try {
            date=  simpleDateFormat.parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
         return new Date(date.getTime());
    }
    public static Date getCurrentDateSql(){
        java.util.Date date=new java.util.Date(System.currentTimeMillis());
        return new Date(date.getTime());
    }
}
