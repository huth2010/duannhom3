package laptrinhandroid.fpoly.dnnhm3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.sql.SQLException;
import java.util.List;

import laptrinhandroid.fpoly.dnnhm3.Adapter.AdapterThongBao;
import laptrinhandroid.fpoly.dnnhm3.Entity.ChamCong;
import laptrinhandroid.fpoly.dnnhm3.R;

public class ThongBao extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao);
        recyclerView = findViewById(R.id.rcy);
        AdapterThongBao adapterThongBao = new AdapterThongBao();
        Intent intent=getIntent();
      int mNV=  intent.getIntExtra("maNV",0);
        try {
            if(mNV!=0){
                adapterThongBao.setData((List<ChamCong>) GiaoDienChinh.daoChamCong.getChamCong(mNV));
            }
            recyclerView.setAdapter(adapterThongBao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}