package laptrinhandroid.fpoly.dnnhm3;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.List;

import laptrinhandroid.fpoly.dnnhm3.DAO.DAONhanVien;
import laptrinhandroid.fpoly.dnnhm3.Entity.ChamCong;


public class MainActivity extends AppCompatActivity {
private ImageView imageView;
MaterialCalendarView calendarView;
List<ChamCong> chamCongs;

@RequiresApi(api = Build.VERSION_CODES.M)
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
imageView = findViewById(R.id.a);
//alo 123
   // calendarView = findViewById(R.id.calendarView);
//if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
//Intent intent = new Intent();
//intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
////  intent.setType("image/*");
//activityResultLauncher.launch(Intent.createChooser(intent, "Select Picture"));
//}


//
@SuppressLint("UseCompatLoadingForDrawables")
BitmapDrawable bitmap= (BitmapDrawable) getResources().getDrawable(R.drawable.img);
Bitmap drawable=bitmap.getBitmap();
    DAONhanVien tbBangLuong=new DAONhanVien();


}


ActivityResultLauncher<Intent> activityResultLauncher =
registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
if (result.getResultCode() == RESULT_OK) {
   imageView.setImageBitmap(ConvertImg.convertBaseStringToBitmap(ConvertImg.convertBitmapToBaseString((Bitmap) result.getData().getExtras().get("data"))));

}
});


}
