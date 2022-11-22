package laptrinhandroid.fpoly.dnnhm3.Fragment.SanPham;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import laptrinhandroid.fpoly.dnnhm3.R;


public class FragmentDanhMuc extends Fragment {
    FloatingActionButton floatingActionButton;

    public FragmentDanhMuc() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_danh_muc, container, false);
        floatingActionButton = view.findViewById(R.id.flbtn_danhmuc);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert_danhmuc();
            }
        });
        return view;
    }

    private void insert_danhmuc() {
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        LayoutInflater inflater= getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_danhmuc,null);
        builder.setView(view);
        Dialog dialog=builder.create();
        dialog.show();
    }


}