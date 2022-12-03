package laptrinhandroid.fpoly.dnnhm3.Fragment.Fragment_baocao;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import laptrinhandroid.fpoly.dnnhm3.DAO.DAOBaoCao;
import laptrinhandroid.fpoly.dnnhm3.Entity.SanPham;
import laptrinhandroid.fpoly.dnnhm3.R;

public class FragmentKhoHang extends Fragment {
    CardView cvTime, cvSoluong, cvConBan, cvHetHang;
    TextView tvTime, tvGiatritonkho, tvSoluong, tvConBan, tvHetHang;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    DAOBaoCao daoBaoCao;
    BottomSheetDialog sheetDialogLich;
    List<SanPham> listSanPham;

    public FragmentKhoHang() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kho_hang, container, false);

        anhxa(view);

        try {
            listSanPham.clear();
            listSanPham.addAll(daoBaoCao.getListSanPham());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setUpData();


        return view;
    }

    private void anhxa(View view) {
        cvSoluong = view.findViewById(R.id.khohang_cv_soluong);
        cvConBan = view.findViewById(R.id.khohang_cv_conban);
        cvHetHang = view.findViewById(R.id.khohang_cv_hethang);
        tvGiatritonkho = view.findViewById(R.id.khohang_tv_giatritonkho);
        tvSoluong = view.findViewById(R.id.khohang_tv_soluong);
        tvConBan = view.findViewById(R.id.khohang_tv_conban);
        tvHetHang = view.findViewById(R.id.khohang_tv_hethang);

        daoBaoCao = new DAOBaoCao();
        listSanPham = new ArrayList<>();
    }

    private void setUpData() {
        getGiaTriTonKho();
        getSoluong();
        getConBan();
        getHetHang();
    }

    private double getGiaTriTonKho(){
        double tong = 0;
        for (SanPham sp: listSanPham){
            tong = sp.getGiaBan() * sp.getSoLuong();
        }
        tvGiatritonkho.setText(String.valueOf(forMatNumber(tong)) + " ₫");
        return tong;
    }

    private int getSoluong(){
        int tong = 0;
        for (SanPham sp: listSanPham){
            tong += sp.getSoLuong();
        }
        tvSoluong.setText(String.valueOf(tong));
        return tong;
    }

    private int getConBan(){
        int tong = 0;
        for (SanPham sp: listSanPham){
            if (sp.getSoLuong() > 0){
                ++tong;
            }
        }
        tvConBan.setText(String.valueOf(tong));
        return tong;
    }

    private int getHetHang(){
        int tong = 0;
        for (SanPham sp: listSanPham){
            if (sp.getSoLuong() == 0){
                ++tong;
            }
        }
        tvHetHang.setText(String.valueOf(tong));
        return tong;
    }

    private String forMatNumber(Double aDouble){
        DecimalFormat formatter  = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

        symbols.setGroupingSeparator(',');
        formatter.setDecimalFormatSymbols(symbols);

        return formatter.format(aDouble);
    }
}