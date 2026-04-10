package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;

public class FlagFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_flag, container, false);
        ImageView img = v.findViewById(R.id.ivFlag);

        // Get the ID from the Bundle
        if (getArguments() != null) {
            int imageID = getArguments().getInt("f_id");
            img.setImageResource(imageID);
        }
        return v;
    }
}