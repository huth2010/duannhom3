package laptrinhandroid.fpoly.dnnhm3;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.sql.Connection;
import java.util.List;

import laptrinhandroid.fpoly.dnnhm3.Entity.ChamCong;
import laptrinhandroid.fpoly.dnnhm3.JDBC.DbSqlServer;


public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    MaterialCalendarView calendarView;
    List<ChamCong> chamCongs;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //alo 123
        calendarView = findViewById(R.id.calendarView);
        //        if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
//            Intent intent = new Intent();
//            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
//            //  intent.setType("image/*");
//            activityResultLauncher.launch(Intent.createChooser(intent, "Select Picture"));
//        }

        DbSqlServer db = new DbSqlServer();
        Toast.makeText(this, db.openConnect()+"", Toast.LENGTH_SHORT).show();
        requestPermissions(new String[]{Manifest.permission.CAMERA}, 0);
 //

    }


    ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK) {
                    imageView.setImageURI(result.getData().getData());
                }
            });


}
