package laptrinhandroid.fpoly.dnnhm3.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import laptrinhandroid.fpoly.dnnhm3.Adapter.AdapterPager;
import laptrinhandroid.fpoly.dnnhm3.R;
import me.relex.circleindicator.CircleIndicator3;

public class GiaoDienChinh extends AppCompatActivity {
    NavigationView navigationView;
    Toolbar toolbar;
    AdapterPager adapterPager;
    ViewPager2 viewPager2;
    CircleIndicator3 indicator3;
    Handler handler = new Handler(Looper.myLooper());
    int i = 0;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            i = viewPager2.getCurrentItem();
            if (i == 2) {
                viewPager2.setCurrentItem(0);
            } else {
                viewPager2.setCurrentItem(i + 1);
            }

        }
    };    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_dien_chinh);
        indicator3 = findViewById(R.id.circleIndicator3);
        toolbar = findViewById(R.id.toolBar);
        viewPager2 = findViewById(R.id.viewPager2);
        navigationView = findViewById(R.id.navigationView);
        adapterPager = new AdapterPager(this);
        navigationView.setItemIconTintList(null);
        setToolBar();
        viewPager2.setAdapter(adapterPager);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int i) {
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable,1500);
            }

        });
        indicator3.setViewPager(viewPager2);
    }

    private void setToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.a);
    }
}