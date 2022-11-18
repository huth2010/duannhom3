package laptrinhandroid.fpoly.dnnhm3.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import laptrinhandroid.fpoly.dnnhm3.R;

public class AdapterThongBao extends RecyclerView.Adapter<AdapterThongBao.ThongBaoViewHolder>{
    @NonNull
    @Override
    public ThongBaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ThongBaoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_noti,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ThongBaoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ThongBaoViewHolder extends RecyclerView.ViewHolder{

        public ThongBaoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
