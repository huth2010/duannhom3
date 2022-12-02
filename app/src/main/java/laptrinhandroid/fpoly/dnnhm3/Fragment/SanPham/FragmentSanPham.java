 package laptrinhandroid.fpoly.dnnhm3.Fragment.SanPham;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import laptrinhandroid.fpoly.dnnhm3.R;


public class FragmentSanPham extends Fragment {
    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;




    public FragmentSanPham() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View view= inflater.inflate(R.layout.fragment_sanpham, container, false);
    floatingActionButton=view.findViewById(R.id.flbtn_sanpham);
    floatingActionButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            insert_sp();
        }
    });
       return view;

    }

    private void insert_sp() {
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        LayoutInflater inflater= getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_sanpham,null);
        builder.setView(view);
        Dialog dialog=builder.create();
        dialog.show();
    }


}