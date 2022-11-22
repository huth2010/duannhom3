package laptrinhandroid.fpoly.dnnhm3.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Date;
import java.util.List;

import laptrinhandroid.fpoly.dnnhm3.Entity.ChamCong;
import laptrinhandroid.fpoly.dnnhm3.R;

public class AdapterThongBao extends RecyclerView.Adapter<AdapterThongBao.ThongBaoViewHolder> {
    List<ChamCong> chamCongs;

    public void setData(List<ChamCong> chamCongs) {
        this.chamCongs = chamCongs;
    }

    @NonNull
    @Override
    public ThongBaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ThongBaoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_noti, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ThongBaoViewHolder holder, int position) {
        if(chamCongs.get(position).getNgay()!=null){
            if(chamCongs.get(position).getNgay().equals(new Date(System.currentTimeMillis()))){
                holder.ngay.setText("Ngày hôm nay");
            }
            holder.ngay.setText("Ngày " + chamCongs.get(position).getNgay());
            String tt = null;
            switch (chamCongs.get(position).getXacNhanChamCong()) {
                case 0:
                    tt = "Chưa xác nhận";
                    break;
                case 1:
                    tt = "Đã xác nhận";
                    break;
                case 2:
                    tt = "Không xác nhận";
                    break;
            }
            holder.trangthai.setText("Trạng thái :" + tt);
        }

    }

    @Override
    public int getItemCount() {
        return chamCongs.size();
    }

    public class ThongBaoViewHolder extends RecyclerView.ViewHolder {
        TextView ngay, trangthai;

        public ThongBaoViewHolder(@NonNull View itemView) {
            super(itemView);
            trangthai = itemView.findViewById(R.id.trangthai);
            ngay = itemView.findViewById(R.id.ngay);
        }
    }
}
