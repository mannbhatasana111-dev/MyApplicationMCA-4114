package com.example.myapplicationmca;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class UNIT4_pro45 extends AppCompatActivity {

    private ListView listView;
    private ArrayList<ContactModel> contactList; // Use a Custom Object for better data handling
    private CustomContactAdapter adapter;

    private static final int CONTACT_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit4_pro45);

        listView = findViewById(R.id.listViewContacts);
        contactList = new ArrayList<>();

        // Initialize our custom adapter
        adapter = new CustomContactAdapter();
        listView.setAdapter(adapter);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS}, CONTACT_PERMISSION_CODE);
        } else {
            fetchContacts();
        }

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String numberToDial = contactList.get(position).getPhone();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + numberToDial));
            startActivity(intent);
        });
    }

    private void fetchContacts() {
        contactList.clear();
        ContentResolver resolver = getContentResolver();

        Cursor cursor = resolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");

        if (cursor != null) {
            int nameIdx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            int numIdx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

            while (cursor.moveToNext()) {
                String name = cursor.getString(nameIdx);
                String phone = cursor.getString(numIdx);
                contactList.add(new ContactModel(name, phone));
            }
            cursor.close();
        }
        adapter.notifyDataSetChanged();
    }

    // --- INNER CLASS FOR DATA MODEL ---
    class ContactModel {
        private String name, phone;
        public ContactModel(String name, String phone) { this.name = name; this.phone = phone; }
        public String getName() { return name; }
        public String getPhone() { return phone; }
    }

    // --- CUSTOM ADAPTER TO MATCH YOUR CARDVIEW DESIGN ---
    class CustomContactAdapter extends ArrayAdapter<ContactModel> {
        public CustomContactAdapter() {
            super(UNIT4_pro45.this, R.layout.contact_item, contactList);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.contact_item, parent, false);
            }

            ContactModel current = contactList.get(position);

            TextView txtAvatar = convertView.findViewById(R.id.textAvatar);
            TextView txtName = convertView.findViewById(R.id.textName);
            TextView txtPhone = convertView.findViewById(R.id.textPhone);

            txtName.setText(current.getName());
            txtPhone.setText(current.getPhone());

            // Set the first letter of the name as the Avatar text
            if (current.getName() != null && !current.getName().isEmpty()) {
                txtAvatar.setText(current.getName().substring(0, 1).toUpperCase());
            }

            return convertView;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CONTACT_PERMISSION_CODE && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            fetchContacts();
        }
    }
}