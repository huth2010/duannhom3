package laptrinhandroid.fpoly.dnnhm3;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.text.SimpleDateFormat;
import java.util.List;

import laptrinhandroid.fpoly.dnnhm3.Entity.ChamCong;

public class DayViewDecorator implements com.prolificinteractive.materialcalendarview.DayViewDecorator {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-d");

    private List<ChamCong> chamCongs;
    private Boolean mABoolean;

    public DayViewDecorator(List<ChamCong> chamCongs) {
        this.chamCongs = chamCongs;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        for (ChamCong chamCong : chamCongs) {
            return (day.getYear() + "-" + day.getMonth() + "-" + day.getDay()).contains(simpleDateFormat.format(chamCong.getNgay())) ;
        }
        return false;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new DotSpan(5, R.color.purple_500));
    }
}
