package laptrinhandroid.fpoly.dnnhm3;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.fragment.app.Fragment;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import laptrinhandroid.fpoly.dnnhm3.Entity.ChamCong;

public class DayViewDecoratorNoConfirm implements com.prolificinteractive.materialcalendarview.DayViewDecorator {
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-d");
    private HashSet<CalendarDay> dates;

    private Boolean aBoolean;
    private Date ngayBD;
    public DayViewDecoratorNoConfirm(Collection<CalendarDay> chamCongs, Date ngayBD) {
         this.ngayBD = ngayBD;


        this.dates = new HashSet<>(chamCongs);
        Log.d("ssssa", "shouldDecorate: "+dates.toString());

    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
         return dates.contains(day);


    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new DotSpan(5, R.color.black));

    }

}
