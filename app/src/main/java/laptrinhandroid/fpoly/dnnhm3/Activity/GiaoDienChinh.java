package laptrinhandroid.fpoly.dnnhm3.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import laptrinhandroid.fpoly.dnnhm3.Adapter.AdapterPager;
import laptrinhandroid.fpoly.dnnhm3.JDBC.DbSqlServer;
import laptrinhandroid.fpoly.dnnhm3.R;
import me.relex.circleindicator.CircleIndicator3;

public class GiaoDienChinh extends AppCompatActivity {
    NavigationView navigationView;
    Toolbar toolbar;
    AdapterPager adapterPager;
    ViewPager2 viewPager2;
    CircleIndicator3 indicator3;
    ActionBar actionbar;
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
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_dien_chinh);
        indicator3 = findViewById(R.id.circleIndicator3);
        toolbar = findViewById(R.id.toolBar);
        viewPager2 = findViewById(R.id.viewPager2);
        navigationView = findViewById(R.id.navigationView);
        setToolBar();

        adapterPager = new AdapterPager(this);
        navigationView.setItemIconTintList(null);

        setAdaperViewPager();
        new DbSqlServer().openConnect();
        //Chạy chữ
        runLetters();
    }

    private void runLetters() {
        actionbar.setTitle("Quản lí cửa hàng");
        final String[] s = ("Quản lí cửa hàng").split("");
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i4[] = {0};
                int i3[] = {1};
                int[] i = {0};
                StringBuilder stringBuilder = new StringBuilder();
                int i1[] = {0};
                while (true) {
                    int finalI = i[0];
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (i1[0] == 0) {
                                stringBuilder.append(s[finalI]);
                                i[0]++;
                                if (i[0] == s.length) {
                                    i[0] = s.length - 1;
                                    i1[0] = 3;
                                    if (i3[0] == 2) {
                                        i4[0]++;
                                    }
                                }
                            } else {
                                stringBuilder.deleteCharAt(i[0]);
                                i[0]--;
                                if (i[0] < 0) {
                                    i[0] = 0;
                                    i1[0] = 0;
                                    i3[0] = 2;
                                }
                            }
                            Log.d("sssss", "run: " + stringBuilder.toString());
                            if (i3[0] != 1) {
                                actionbar.setTitle(stringBuilder.toString());
                            }
                        }
                    });
                    try {

                        Thread.sleep(100);
                        if (i4[0] == 2) {
                            Thread.sleep(5000);
                            i4[0] = 0;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void setAdaperViewPager() {
        viewPager2.setOffscreenPageLimit(1);//Dat so luong trang giu lai o hai ben
        //Hiển thị view ẩn
        viewPager2.setClipToPadding(false);//
        viewPager2.setClipChildren(false);//
//        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
//        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
//        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.setAdapter(adapterPager);
//Lắng nghe Thay đổi
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int i) {
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3500);
            }

        });
        indicator3.setViewPager(viewPager2);
    }

    @SuppressLint("RestrictedApi")
    public void setToolBar() {
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);//set icon tren toolbar
        actionbar.setHomeAsUpIndicator(R.drawable.ic_baseline_home_24);//set icon menu
    }
}