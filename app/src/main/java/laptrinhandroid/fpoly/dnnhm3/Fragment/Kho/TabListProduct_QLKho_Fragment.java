package laptrinhandroid.fpoly.dnnhm3.Fragment.Kho;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import laptrinhandroid.fpoly.dnnhm3.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabListProduct_QLKho_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabListProduct_QLKho_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TabListProduct_QLKho_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabListProduct_QLKho_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TabListProduct_QLKho_Fragment newInstance(String param1, String param2) {
        TabListProduct_QLKho_Fragment fragment = new TabListProduct_QLKho_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_list_product__q_l_kho_, container, false);
    }
}