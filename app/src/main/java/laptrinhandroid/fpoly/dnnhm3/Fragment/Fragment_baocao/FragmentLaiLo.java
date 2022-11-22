package laptrinhandroid.fpoly.dnnhm3.Fragment.Fragment_baocao;

import android.os.Bundle;
import android.os.Handler;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.List;

import laptrinhandroid.fpoly.dnnhm3.Entity.SanPham;
import laptrinhandroid.fpoly.dnnhm3.R;

public class FragmentLaiLo extends Fragment {
    int i = 0;
    double tongThu, tongChi;

    TextView tvLoiNhuan, tvDoanhThu, tvGiavonHangBan;
    ImageView imageView;
    RelativeLayout relativeLayout;
    CardView cardView, cvLich;
    ViewGroup viewGroup;

//    DAOBaoCao daoBaoCao;

    List<SanPham> listSanPham;

    public FragmentLaiLo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lai_lo, container, false);

        tvLoiNhuan = view.findViewById(R.id.baocao_lailo_loinhuan);
        tvDoanhThu = view.findViewById(R.id.baocao_lailo_tv_tiendoanhthu);
        tvGiavonHangBan = view.findViewById(R.id.baocao_lailo_tv_tienhangban);
        cardView = view.findViewById(R.id.baocao_lailo_cardview_doanhthu);
        cvLich = view.findViewById(R.id.frg_lailo_cardview_time);
        viewGroup = view.findViewById(R.id.baocao_lailo_scrollView);
        imageView = view.findViewById(R.id.baocao_lailo_img_doanhthu);
        relativeLayout = view.findViewById(R.id.baocao_lailo_rcv_doanhthu);

//        daoBaoCao = new DAOBaoCao();

//        getDataSanPham();

//        tvDoanhThu.setText(tvDoanhThu + "");
//        tvGiavonHangBan.setText(tvGiavonHangBan + "");

        cardView.setOnClickListener(v -> {

            TransitionManager.beginDelayedTransition(viewGroup);;
            if (relativeLayout.getVisibility() == View.GONE) {
                relativeLayout.setVisibility(View.VISIBLE);

            } else {
                relativeLayout.setVisibility(View.GONE);
                imageView.setImageResource(R.drawable.icon_right);
            }
        });

        cvLich.setOnClickListener(v -> {
            openBottomshetDialogFragment();
        });

//        cardView.setCardBackgroundColor();


        Handler handler1 = new Handler();
        handler1.post(new Runnable() {
            @Override
            public void run() {
                if (i <= 13000){
                    i = i + 13;
                    tvLoiNhuan.setText(i + " đ");
                }else tvLoiNhuan.setText(13000 + " đ");
                handler1.postDelayed(this, 1);
            }
        });

        return view;
    }

//    private void getDataSanPham(){
//        try {
//            listSanPham = daoBaoCao.getListSanPham();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        for (SanPham sp: listSanPham){
//            tongThu = sp.getSoLuongDaBan() * sp.getGiaBan();
//            tongChi = sp.getSoLuongDaBan() * sp.getGiaNhap();
//        }
//    }

    private void openBottomshetDialogFragment(){
    }

}