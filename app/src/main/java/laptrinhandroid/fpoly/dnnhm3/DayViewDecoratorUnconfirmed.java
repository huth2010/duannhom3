package laptrinhandroid.fpoly.dnnhm3;

import android.annotation.SuppressLint;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import laptrinhandroid.fpoly.dnnhm3.Entity.ChamCong;

public class DayViewDecoratorUnconfirmed implements com.prolificinteractive.materialcalendarview.DayViewDecorator {
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-d");

    private List<ChamCong> chamCongs;

private Date ngayBD;

    public DayViewDecoratorUnconfirmed(List<ChamCong> chamCongs, Date ngayBD) {
        this.chamCongs = chamCongs;
        this.ngayBD = ngayBD;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        for (ChamCong chamCong : chamCongs) {
            return  chamCong.getXacNhanChamCong() == 0 &&
                    ngayBD.before(FormatDay.convertToDate(day.getYear(),day.getMonth(),day.getDay()))&&
                    FormatDay.convertToDate(day.getYear(),day.getMonth(),day.getDay()).after(new Date(System.currentTimeMillis()));
        }
        return false;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new DotSpan(5, android.R.color.holo_orange_dark));

    }


}
