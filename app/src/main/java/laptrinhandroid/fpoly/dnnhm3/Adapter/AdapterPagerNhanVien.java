package laptrinhandroid.fpoly.dnnhm3.Adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import laptrinhandroid.fpoly.dnnhm3.DAO.DAOChamCong;
import laptrinhandroid.fpoly.dnnhm3.Fragment.NhanVien.FragmentLich;
import laptrinhandroid.fpoly.dnnhm3.Fragment.NhanVien.FragmentLuong;

public class AdapterPagerNhanVien extends FragmentStateAdapter {
    public AdapterPagerNhanVien(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0){

            FragmentLich fragmentLich=new FragmentLich();
            Bundle bundle=new Bundle();
            bundle.putSerializable("f",new DAOChamCong());
            fragmentLich.setArguments(bundle);
            return new FragmentLich();
        }
        return  new FragmentLuong();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
