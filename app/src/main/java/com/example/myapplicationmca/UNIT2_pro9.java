package com.example.myapplicationmca;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro9);

        // Load the List Fragment on startup
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.list_container, new CountryListFragment())
                .commit();
    }

    // This function is called by the ListFragment when a name is clicked
    public void changeFlag(int imageResId) {
        FlagFragment f2 = new FlagFragment();

        // Pass the image ID to Fragment 2
        Bundle b = new Bundle();
        b.putInt("f_id", imageResId);
        f2.setArguments(b);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flag_container, f2)
                .commit();
    }
}