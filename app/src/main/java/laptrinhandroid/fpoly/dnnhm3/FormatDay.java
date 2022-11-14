package laptrinhandroid.fpoly.dnnhm3;

import android.util.Log;

import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormatDay {
     static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-d");

    public static Date getCurrentDateSql(){
        java.util.Date date=new java.util.Date(System.currentTimeMillis());
        return new Date(date.getTime());
    }
    public boolean check(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek == Calendar.SUNDAY;
    }
    public static Date convertToDate(int year,int month,int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year,month,day);
        Log.d("ssss", "convertToDate: "+new Date(cal.getTime().getTime()));
        return new Date(cal.getTime().getTime());
    }
}
