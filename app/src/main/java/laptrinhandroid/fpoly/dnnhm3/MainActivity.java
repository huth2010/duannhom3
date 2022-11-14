package laptrinhandroid.fpoly.dnnhm3;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
import android.widget.ImageView;
import android.widget.Toast;


import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import laptrinhandroid.fpoly.dnnhm3.DAO.DAOChamCong;
import laptrinhandroid.fpoly.dnnhm3.Entity.ChamCong;


public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    MaterialCalendarView calendarView;
    List<ChamCong> chamCongs;
Toolbar toolbar;
ViewPager2 viewPager2;
    @SuppressLint("MissingInflatedId")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //        calendarView = findViewById(R.id.calendarView);
////alo 123
//// calendarView = findViewById(R.id.calendarView);
////if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
////Intent intent = new Intent();
////intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
////intent.setType("image/*");
////activityResultLauncher.launch(Intent.createChooser(intent, "Select Picture"));
////}
//        DAOChamCong daoChamCong = new DAOChamCong();
//        try {
//            ;    ArrayList<CalendarDay> date = new ArrayList<>();
//            for (ChamCong chamCong : daoChamCong.getListChamCong("5")) {
//                if(chamCong.getXacNhanChamCong()==1){
//                    Calendar calendar = Calendar.getInstance();
//                    calendar.setTime(chamCong.getNgay());
//                     date.add(CalendarDay.from(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DATE)));
//                }
//            }
//            calendarView.addDecorator(new DayViewDecoratorNoConfirm(date, Date.valueOf("2022-11-01")));
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }




    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == RESULT_OK) {
            imageView.setImageBitmap(ConvertImg.convertBaseStringToBitmap(ConvertImg.convertBitmapToBaseString((Bitmap) result.getData().getExtras().get("data"))));

        }
    });


}
