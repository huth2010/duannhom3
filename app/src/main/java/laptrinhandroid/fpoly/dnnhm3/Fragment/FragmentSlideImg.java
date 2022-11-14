package laptrinhandroid.fpoly.dnnhm3.Fragment;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import laptrinhandroid.fpoly.dnnhm3.R;

public class FragmentSlideImg extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_img,null);
        ImageView imageView=view.findViewById(R.id.img);
       int i= getArguments().getInt("img");
        imageView.setImageDrawable(getActivity().getDrawable(i));
        return view;
    }
}
