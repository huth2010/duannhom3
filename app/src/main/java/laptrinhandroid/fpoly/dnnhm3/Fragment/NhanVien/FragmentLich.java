package laptrinhandroid.fpoly.dnnhm3.Fragment.NhanVien;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import laptrinhandroid.fpoly.dnnhm3.Activity.GiaoDienChinh;
import laptrinhandroid.fpoly.dnnhm3.DAO.DAOChamCong;
import laptrinhandroid.fpoly.dnnhm3.DayViewDecoratorConfirmed;
import laptrinhandroid.fpoly.dnnhm3.DayViewDecoratorNoConfirm;
import laptrinhandroid.fpoly.dnnhm3.DayViewDecoratorUnconfirmed;
import laptrinhandroid.fpoly.dnnhm3.FormatDay;
import laptrinhandroid.fpoly.dnnhm3.MainActivity;
import laptrinhandroid.fpoly.dnnhm3.R;

public class FragmentLich extends Fragment {
    MaterialCalendarView calendarView;
    TextView txtLam, txtNghi, txtChuaXN;
    View view;
    List<CalendarDay> list0, list1, list2;

    //0 là chưa có,1 là xấc nhận ,2 là không xác nhận
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cong, null);
        calendarView = view.findViewById(R.id.calendarView);
        txtLam = view.findViewById(R.id.txtLam);
        txtNghi = view.findViewById(R.id.txtNghi);
        txtChuaXN = view.findViewById(R.id.txtChuaXN);
        DAOChamCong daoChamCong = GiaoDienChinh.daoChamCong;
        try {
            list0 = daoChamCong.getListChamCong("1", 0);
            list1 = daoChamCong.getListChamCong("1", 1);
            list2 = daoChamCong.getListChamCong("1", 2);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                calendarView.setCurrentDate(FormatDay.calendarDay());
//
//            }
            list0.add(FormatDay.calendarDay());
            calendarView.addDecorator(new DayViewDecoratorNoConfirm(list0));
            calendarView.addDecorator(new DayViewDecoratorConfirmed(list1));
            calendarView.addDecorator(new DayViewDecoratorUnconfirmed(list2));
            calendarView.setOnMonthChangedListener((widget, date) -> {
                txtChuaXN.setText(getTrangThaiCongTrongThang(list0, date.getMonth()) + "");
                txtLam.setText(getTrangThaiCongTrongThang(list1, date.getMonth()) + "");
                txtNghi.setText(getTrangThaiCongTrongThang(list2, date.getMonth()) + "");
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return view;
    }

    private int getTrangThaiCongTrongThang(List<CalendarDay> calendarDays, int month) {
        int i = 0;
        for (CalendarDay calendarDay : calendarDays) {
            if (calendarDay.getMonth() == month) {
                i++;
            }
        }
        return i;
    }


}
