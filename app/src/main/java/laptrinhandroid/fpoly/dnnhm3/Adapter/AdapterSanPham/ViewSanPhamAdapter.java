package laptrinhandroid.fpoly.dnnhm3.Adapter.AdapterSanPham;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import laptrinhandroid.fpoly.dnnhm3.Fragment.SanPham.FragmentDanhMuc;
import laptrinhandroid.fpoly.dnnhm3.Fragment.SanPham.FragmentSanPham;

public class ViewSanPhamAdapter extends FragmentStatePagerAdapter {
    public ViewSanPhamAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentSanPham();

            case 1:
                return new FragmentDanhMuc();

            default:
                return new FragmentSanPham();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title ="";
        switch (position){
            case 0:
                title="Sản phẩm";
                break;
            case 1:
                title="Danh mục";
                break;
        }
        return title;
    }
}
