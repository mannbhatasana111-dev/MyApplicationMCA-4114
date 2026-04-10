package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

public class CountryListFragment extends Fragment {
    String[] countries = {"India", "USA", "Canada"};
    // Ensure you have india, usa, and canada images in res/drawable folder
    int[] flags = {R.drawable.india, R.drawable.usa, R.drawable.canada};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Create a ListView dynamically
        ListView lv = new ListView(getActivity());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, countries);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Tell the Activity to update the flag
                ((UNIT2_pro9) getActivity()).changeFlag(flags[position]);
            }
        });
        return lv;
    }
}