package laptrinhandroid.fpoly.dnnhm3;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import laptrinhandroid.fpoly.dnnhm3.Adapter.AdapterPagerNhanVien;
import laptrinhandroid.fpoly.dnnhm3.DAO.DAOChamCong;
import laptrinhandroid.fpoly.dnnhm3.Entity.ChamCong;


public class MainActivity extends AppCompatActivity {


    List<CalendarDay> list0;
    List<CalendarDay> list1;
    List<CalendarDay> list2;
    TabLayout layout;
    ViewPager2 viewPager2;
    MaterialCalendarView calendarView;

    @SuppressLint("MissingInflatedId")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
        setToolBar();

        viewPager2.setAdapter(new AdapterPagerNhanVien(this));

        new TabLayoutMediator(layout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("Bảng công");
                } else {
                    tab.setText("Bảng lương");
                }
            }
        }).attach();
//if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
//Intent intent = new Intent();
//intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
//intent.setType("image/*");
//activityResultLauncher.launch(Intent.createChooser(intent, "Select Picture"));
//}
//        getCong();
        DAOChamCong daoChamCong = new DAOChamCong();
        try {
            list0 = daoChamCong.getListChamCong("1", 0);
            list1 = daoChamCong.getListChamCong("1", 1);
            list2 = daoChamCong.getListChamCong("1", 2);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                ;
                //   calendarView.setCurrentDate(FormatDay.calendarDay());

            }
            calendarView.addDecorator(new DayViewDecoratorUnconfirmed(list0));
            calendarView.addDecorator(new DayViewDecoratorConfirmed(list1));
            calendarView.addDecorator(new DayViewDecoratorNoConfirm(list2));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @SuppressLint("RestrictedApi")
    public void setToolBar() {
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);//set icon tren toolbar
        actionbar.setHomeAsUpIndicator(R.drawable.ic_baseline_home_24);//set icon menu
    }


    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == RESULT_OK) {
            // imageView.setImageBitmap(ConvertImg.convertBaseStringToBitmap(ConvertImg.convertBitmapToBaseString((Bitmap) result.getData().getExtras().get("data"))));

        }
    });

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_nhan_vien, menu);
        return true;
    }

}
