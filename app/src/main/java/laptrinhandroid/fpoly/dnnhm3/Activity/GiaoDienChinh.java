package laptrinhandroid.fpoly.dnnhm3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import laptrinhandroid.fpoly.dnnhm3.R;

public class GiaoDienChinh extends AppCompatActivity {
NavigationView navigationView;
Toolbar toolbar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_dien_chinh);
        toolbar=findViewById(R.id.toolBar);
        navigationView=findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);
    }
}