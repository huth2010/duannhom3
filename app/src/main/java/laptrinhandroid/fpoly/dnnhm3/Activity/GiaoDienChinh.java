package laptrinhandroid.fpoly.dnnhm3.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
 
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.Dialog;
 import android.content.Intent;
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

import laptrinhandroid.fpoly.dnnhm3.Adapter.AdapterPagerSlideImg;
import laptrinhandroid.fpoly.dnnhm3.Adapter.AdapterPagerSlideImg;
import laptrinhandroid.fpoly.dnnhm3.DAO.DAOChamCong;
import laptrinhandroid.fpoly.dnnhm3.JDBC.DbSqlServer;
import laptrinhandroid.fpoly.dnnhm3.R;
import me.relex.circleindicator.CircleIndicator3;

public class GiaoDienChinh extends AppCompatActivity {
    public static DAOChamCong daoChamCong;
    NavigationView navigationView;
    CardView cardViewSanPham;
    Toolbar toolbar;
    AdapterPagerSlideImg adapterPager;
    ViewPager2 viewPager2;
    CircleIndicator3 indicator3;
    ActionBar actionbar;
    Handler handler = new Handler(Looper.myLooper());
    int i = 0;
 
    public static DAOChamCong daoChamCong = new DAOChamCong();
    public static DAOBangLuong bangLuong = new DAOBangLuong();
    public static DAONhanVien nhanVien1 = new DAONhanVien();

    DrawerLayout drawerLayout;
    LinearLayout nhanVien,btnstart_kho;
    FloatingActionButton floatAction;
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
 
        drawerLayout = findViewById(R.id.drawerLayout);
        floatAction = findViewById(R.id.floatAction);
        txtSoGioDaLam = findViewById(R.id.txtSoGioDaLam);
        txtThuHangHienTai = findViewById(R.id.txtThuHangHienTai);
        txtSoTienThuongHienTai = findViewById(R.id.txtSoTienThuongHienTai);
        btnBangXepHang = findViewById(R.id.btnBangXepHang);
        btnstart_kho=findViewById(R.id.btnstartKho);
        btnstart_kho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),QuanLyKho.class));
            }
        });
         setToolBar();
        cardViewSanPham= findViewById(R.id.cv_sanpham);
        cardViewSanPham.setOnClickListener(view -> {
            Intent intent= new Intent(GiaoDienChinh.this,SanPhamActivity.class);
            startActivity(intent);
        }  );

        adapterPager = new AdapterPagerSlideImg(this);
        navigationView.setItemIconTintList(null);
 

        try {
            nv = (NhanVien) intent.getSerializableExtra("NV");
            List<ChamCong> chamCongs = daoChamCong.getListChamCong(nv.getMaNv(), FormatDay.calendarDay().getYear() + "-" + FormatDay.calendarDay().getMonth());
            if (chamCongs != null) {
                long soH = 0;
                for (ChamCong chamCong : chamCongs) {
                    if (chamCong.getGioKetThuc() != null) {
                        soH += chamCong.getGioKetThuc().getTime() - chamCong.getGioBatDau().getTime();
                    }
                }
                float h = (float) soH / (1000 * 60 * 60);
                txtSoGioDaLam.setText(h + " giờ");
 
           // txtSoTienThuongHienTai.setText(bangLuong.getBangLuong(nv.getMaNv()).getThuong() + " VND");
 

        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        setAdaperViewPager();
        new DbSqlServer().openConnect();
        //Chạy chữ
        runLetters();
 
        nhanVien.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, MainActivity.class);
            intent1.putExtra("nv", nv);
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, nhanVien, "a");
            startActivity(intent1, options.toBundle());
        });
        floatAction.setOnClickListener(view -> {
            Dialog dialog = createDialog();
            btnXacNhan = dialog.findViewById(R.id.btnXacNhan);
            txtTg = dialog.findViewById(R.id.txtTg);
            txtMessage = dialog.findViewById(R.id.txtMessage);
            txtWarning = dialog.findViewById(R.id.txtWarning);
            long currentTime = FormatDay.getCurrentDateUtil().getTime();
            long gioBatDau = FormatDay.getBatDauLam();
            long gioKetThuc = FormatDay.getKetThucHLam();
            long conLai = gioBatDau - currentTime;
            Log.d("Ssssdf1", "onCreate: " + new Date(conLai) + "");

            CountDownTimer demNguocGioBatDauLam;
            CountDownTimer demNguocGioKetThucLam = demNguocGioKetThucLam(txtTg, txtMessage, gioKetThuc - currentTime);
            demNguocGioKetThucLam.start();
            try {
                ChamCong chamCong = daoChamCong.getChamCong(nv.getMaNv());
                //Đếm thời gian bắt đầu vào làm

                if (currentTime >= (gioBatDau - (30 * 60 * 1000)) && currentTime <= gioBatDau) {
                    txtMessage.setText("Bắt đầu vào làm sau");
                    demNguocGioBatDauLam = demNguocGioBatDauLam(txtTg, txtMessage, conLai).start();
                    demNguocGioBatDauLam.start();
                    Log.d("Ssssdf1", "onCreate: " + (chamCong != null) + chamCong);

                } else {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date(System.currentTimeMillis()));

                    if ((calendar.get(Calendar.HOUR_OF_DAY) > 7 && calendar.get(Calendar.MINUTE) >= 15)) {
                        //Khi chấm công vào làm thành công
                        if (currentTime <= (gioKetThuc * 15 * 60 * 1000)) {
                            txtMessage.setText("Hết giờ làm sau");
                            btnXacNhan.setText("Chấm công kết thúc");
                            demNguocGioKetThucLam.start();
                        }

                        if (chamCong != null) {
                            if (chamCong.getGioBatDau() != null) {
                                khiChamCongVaoLam(chamCong.getGioBatDau());
                            } else if (chamCong.getXacNhanChamCong() == 0) {
                                hideView();
                                txtMessage.setText("Đang chờ xác nhận");
                            } else if (chamCong.getXacNhanChamCong() == 1) {
                                txtMessage.setText("Đã xác nhận thành công");
                                hideView();
                            } else if (chamCong.getXacNhanChamCong() == 2) {
                                hideView();
                                txtMessage.setText("Không xác nhận công");
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            dialog.show();
            btnXacNhan.setOnClickListener(view1 -> {
                ChamCong chamCong = null;
                try {
                    chamCong = daoChamCong.getChamCong(1);
                    if (chamCong != null) {
                        chamCong.setGioKetThuc(new Time(System.currentTimeMillis()));
                        daoChamCong.updateChamCong(chamCong);
                        if (chamCong.getXacNhanChamCong() == 0) {
                            hideView();
                            txtMessage.setText("Đang chờ xác nhận");
                        } else if (chamCong.getXacNhanChamCong() == 1) {
                            txtMessage.setText("Đã xác nhận thành công");
                            hideView();
                        } else if (chamCong.getXacNhanChamCong() == 2) {
                            hideView();
                            txtMessage.setText("Không xác nhận công");
                        }
                    } else {
                        daoChamCong.addChamCong(new ChamCong(nv.getMaNv(), new Time(System.currentTimeMillis()), null, new java.sql.Date(System.currentTimeMillis()), 0));
                        khiChamCongVaoLam(new Time(System.currentTimeMillis()));
                        btnXacNhan.setText("Chấm công kết thúc");

                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    Log.d("sssss1", "onCreate: " + e.toString());

                }
            });
        });

    }

    private void hideView() {
        txtWarning.setVisibility(View.GONE);
        txtTg.setVisibility(View.GONE);
        btnXacNhan.setVisibility(View.GONE);
    }


    @SuppressLint({"SetTextI18n", "ResourceType", "UseCompatTextViewDrawableApis"})
    private void khiChamCongVaoLam(Time gioBatDau) {
        Calendar calendar = FormatDay.convertTimeToCalender(gioBatDau);
        txtWarning.setText("Bạn đã chấm công vào lúc" + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE));
        txtWarning.setTextColor(Color.parseColor("#269A0A"));
        txtWarning.setBackgroundColor(Color.parseColor("#81B7F3B9"));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            txtWarning.setCompoundDrawableTintList(getColorStateList(R.color.teal_200));
        }
    }


    private CountDownTimer demNguocGioKetThucLam(TextView txtTg, TextView txtMessage, long conLai) {


        return new CountDownTimer(conLai, 60000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long l) {
                long differenceInMilliSeconds
                        = Math.abs(l);
                long differenceInHours
                        = (differenceInMilliSeconds / (60 * 60 * 1000))
                        % 24;
                long differenceInMinutes
                        = (differenceInMilliSeconds / (60 * 1000)) % 60;

                txtTg.setText(differenceInHours + ":" + differenceInMinutes);
            }

            @Override
            public void onFinish() {

            }
        };
    }

    private CountDownTimer demNguocGioBatDauLam(TextView txtTg, TextView txtMessage, long conLai) {

        return new CountDownTimer(conLai, 60000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long l) {
                txtMessage.setText("Bắt đầu làm sau");
                txtTg.setText(TimeUnit.MILLISECONDS.toMinutes(conLai) + " phút");
            }

            @Override
            public void onFinish() {


            }
        };
    }


    private Dialog createDialog() {
        Dialog dialog = new Dialog(GiaoDienChinh.this);
        dialog.getWindow().setGravity(Gravity.TOP);
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        dialog.setContentView(R.layout.dialog_cham_cong);
        return dialog;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(Gravity.LEFT);

        }
        return true;
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
                        if (i4[0] ==2) {
                            Thread.sleep(5000);
                            i4[0]=0;
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