package laptrinhandroid.fpoly.dnnhm3.Fragment.Fragment_baocao;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.tabs.TabLayout;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import laptrinhandroid.fpoly.dnnhm3.Adapter.Adapter_baocao.BaocaoAdapterLich;
import laptrinhandroid.fpoly.dnnhm3.DAO.DAOBaoCao;
import laptrinhandroid.fpoly.dnnhm3.Entity.BaoCao;
import laptrinhandroid.fpoly.dnnhm3.R;

public class FragmentThuChi extends Fragment implements BaocaoAdapterLich.IsenDataTime{

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private CardView cvTime;
    private TextView tvTime;
    GraphView graphView;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdfDate = new SimpleDateFormat("dd");
    BottomSheetDialog sheetDialogLich;
    private LineGraphSeries<DataPoint> line1;
    List<BaoCao> listThuchi;

    Context mcontext;
    DAOBaoCao daoBaoCao;


    public FragmentThuChi() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thu_chi, container, false);

        tvTime = view.findViewById(R.id.frg_thuchi_tv_time);
        tabLayout = view.findViewById(R.id.baoCao_tablayout);
        cvTime = view.findViewById(R.id.frg_thuchi_cardview_time);
        graphView = view.findViewById(R.id.graph_view);

        daoBaoCao = new DAOBaoCao();
        mcontext = getActivity();
        listThuchi = new ArrayList<>();

//        getActivity().getSupportFragmentManager();

        getAllDataByDate(simpleDateFormat.format(Calendar.getInstance().getTime()));
        setUpChart(true);

        Log.e("dataArr", listThuchi.toString());

        cvTime.setOnClickListener(v -> {
            showButtonSheetDialog();
        });



        return view;
    }

    private void getAllDataByDate(String date){
        try {
            listThuchi.clear();
            listThuchi.addAll(daoBaoCao.getListSanPhamByDay(date));
            setUpTablayout();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setUpTablayout() {


        tabLayout.removeAllTabs();

        //get Tab and set title
        tabLayout.addTab(tabLayout.newTab().setCustomView(getViewTablayout(0, "Tổng thu", getTongThu())));
        tabLayout.addTab(tabLayout.newTab().setCustomView(getViewTablayout(1, "Tổng chi", getTongChi())));

        //lắng nghe tablayout và set color
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        setUpChart(true);
                        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF03DAC5"));
                        setColorViewItemTablayout(tab.getPosition(), getResources().getColor(R.color.teal_200));
                        break;
                    case 1:
                        setUpChart(false);
                        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"));
                        setColorViewItemTablayout(tab.getPosition(), getResources().getColor(R.color.red));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                setColorViewItemTablayout(tab.getPosition(), getResources().getColor(R.color.black));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private View getViewTablayout(int position, String ten, double tien) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.item_custom_tab, null);     //set view

        TextView tvName = (TextView) v.findViewById(R.id.item_tab_name);
        TextView tvTien = (TextView) v.findViewById(R.id.item_tab_tien);
        tvName.setText(ten);
        tvTien.setText(tien + " $");

        //set text và tab color default
        if (position == 0) tvTien.setTextColor(getResources().getColor(R.color.teal_200));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF03DAC5"));

        return v;
    }

    private void setColorViewItemTablayout(int position, int color) {
        TabLayout.Tab tabAt = tabLayout.getTabAt(position);
        View tabView = tabAt.getCustomView();
        TextView tvTien = tabView.findViewById(R.id.item_tab_tien);
        tvTien.setTextColor(color);
    }

    private void showButtonSheetDialog() {
        sheetDialogLich = new BottomSheetDialog(getContext());
        sheetDialogLich.setContentView(getLayoutInflater().inflate(R.layout.dialog_button_sheet_baocao_lich, null));
        sheetDialogLich.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        sheetDialogLich.show();

        RecyclerView recyclerView = sheetDialogLich.findViewById(R.id.dialog_buttomshett_baocao_lich_rcv);

        List<String> listlich = new ArrayList<>();
        listlich.add("Hôm nay");
        listlich.add("Tuần này");
        listlich.add("Tháng này");
        listlich.add("Tuần trước");
        listlich.add("Tháng trước");
        listlich.add("Thời gian khác");

        BaocaoAdapterLich baocaoAdapterLich = new BaocaoAdapterLich(getActivity(), listlich, this);
        recyclerView.setAdapter(baocaoAdapterLich);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);   //dòng kẻ giữa mỗi item
        recyclerView.addItemDecoration(itemDecoration);
    }

    public void setChoise(int choice) {
        Calendar calendar = Calendar.getInstance();
        switch (choice) {
            case 0:
                tvTime.setText("Hôm nay");
                getAllDataByDate(simpleDateFormat.format(Calendar.getInstance().getTime()));
                break;
            case 1:
                tvTime.setText("Tuần này");
                break;
            case 2:
                tvTime.setText("Tháng này");
                break;
            case 3:
                tvTime.setText("Tuần trước");
                break;
            case 4:
                tvTime.setText("Tháng trước");
                break;
            case 5:
//                MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
//
//                final MaterialDatePicker materialDatePicker = builder.build();

                DatePickerDialog datePickerDialog = new DatePickerDialog(mcontext, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year, month,dayOfMonth);
                        tvTime.setText(simpleDateFormat.format(calendar.getTime()));
                        getAllDataByDate(simpleDateFormat.format(calendar.getTime()));
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();

//                materialDatePicker.show(getActivity().getSupportFragmentManager(), "ALO");

                break;
        }
        sheetDialogLich.dismiss();
    }

    private void setUpChart(boolean isThu){

        line1 = new LineGraphSeries<>(getValuesChart());

        graphView.addSeries(line1);
        if (isThu)line1.setColor(getResources().getColor(R.color.teal_200));
        else line1.setColor(getResources().getColor(R.color.red));
        graphView.getViewport().setXAxisBoundsManual(true);     // cho biểu đồ rộng bằng item
    }

    private DataPoint[] getValuesChart (){
        DataPoint[] dataPoint = new DataPoint[]{
                new DataPoint(0, 21),
                new DataPoint(1, 12),
                new DataPoint(2, 34),
                new DataPoint(3, 56),
                new DataPoint(4, 23),
                new DataPoint(5, 63),
                new DataPoint(6, 23),
                new DataPoint(7, 74),
                new DataPoint(8, 12),
                new DataPoint(9, 75),
                new DataPoint(10, 45),
                new DataPoint(11, 23),
        };
        return dataPoint;
    }

    @Override
    public void sendData(int time) {
        setChoise(time);
    }

    private double getTongThu(){
        double tongthu = 0;
        for (BaoCao bc: listThuchi){
            tongthu += bc.getCthdThanhTien();
        }
        return tongthu;
    }

    private double getTongChi(){
        double tongchi = 0;
        for (BaoCao bc: listThuchi){
            tongchi += (bc.getCthdSoLuong() * bc.getSpGiaNhap());
        }
        return tongchi;
    }
}