package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT3_pro29 extends AppCompatActivity {

    TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3_pro29);

        myText = findViewById(R.id.text_long_press);

        registerForContextMenu(myText);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Select Action");
        // menu.add(groupId, itemId, order, title)
        menu.add(0, 101, 1, "Edit Item");
        menu.add(0, 102, 2, "Share Item");
        menu.add(0, 103, 3, "Delete Item");
    }

    // STEP 3: Handle the click events of the menu items
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 101:
                showToast("Edit Selected");
                return true;
            case 102:
                showToast("Share Selected");
                return true;
            case 103:
                showToast("Delete Selected");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}