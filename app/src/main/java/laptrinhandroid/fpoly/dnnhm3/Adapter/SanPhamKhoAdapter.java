package laptrinhandroid.fpoly.dnnhm3.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import laptrinhandroid.fpoly.dnnhm3.R;

public class SanPhamKhoAdapter extends RecyclerView.Adapter<SanPhamKhoAdapter.SanPhamKhoViewHolder> {
    @NonNull
    @Override
    public SanPhamKhoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamKhoViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }
    public static class SanPhamKhoViewHolder extends RecyclerView.ViewHolder{
        TextView tv_tenSP, tv_maSP, tv_soluongton;
        public SanPhamKhoViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_tenSP = itemView.findViewById(R.id.tv_id_HDN);
            tv_maSP = itemView.findViewById(R.id.tv_tienHDN);
            tv_soluongton = itemView.findViewById(R.id.tv_ngayHDN);
        }
    }
}
