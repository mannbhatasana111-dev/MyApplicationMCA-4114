package com.example.myapplicationmca;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class UNIT5_pro54 extends AppCompatActivity {

    // UI Elements (Updated to match Material Components)
    private TextInputEditText etDocId, etFn, etLn, etMob, etSpec, etSearchId;
    // Address and City are excluded here if you removed them from the best-design XML,
    // but I've kept the logic compatible with your DB table.
    private MaterialButton btnSubmit, btnSearch;
    private TextView tvResult;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit5_pro54);

        // 1. Initialize Components
        initUI();

        dbHelper = new DBHelper(this);

        // 2. Submit Logic with Validation
        btnSubmit.setOnClickListener(v -> handleRegistration());

        // 3. Search Logic with Animation
        btnSearch.setOnClickListener(v -> handleSearch());
    }

    private void initUI() {
        etDocId = findViewById(R.id.etDocId);
        etFn = findViewById(R.id.etFirstName);
        etLn = findViewById(R.id.etLastName);
        etMob = findViewById(R.id.etMob);
        etSpec = findViewById(R.id.etSpecialization);
        etSearchId = findViewById(R.id.etSearchId);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSearch = findViewById(R.id.btnSearch);
        tvResult = findViewById(R.id.tvSearchResult);
    }

    private void handleRegistration() {
        String id = etDocId.getText().toString().trim();
        String fn = etFn.getText().toString().trim();
        String ln = etLn.getText().toString().trim();
        String mb = etMob.getText().toString().trim();
        String sp = etSpec.getText().toString().trim();

        if (id.isEmpty() || fn.isEmpty() || mb.isEmpty()) {
            Toast.makeText(this, "Please fill required fields (ID, Name, Mobile)", Toast.LENGTH_SHORT).show();
            return;
        }

        // Using hardcoded strings for Address/City to match your DB schema
        // while keeping the UI clean as per the 'Best Design' request.
        boolean success = dbHelper.insertDoctor(id, fn, ln, mb, "Not Provided", "Not Provided", sp);

        if (success) {
            Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show();
            clearFields();
        } else {
            Toast.makeText(this, "ID already exists in system", Toast.LENGTH_LONG).show();
        }
    }

    private void handleSearch() {
        String sid = etSearchId.getText().toString().trim();
        if (sid.isEmpty()) {
            tvResult.setText("Please enter a Doctor ID");
            return;
        }

        Cursor cursor = dbHelper.searchDoctor(sid);

        if (cursor != null && cursor.moveToFirst()) {
            // Build visual output
            String output = "📋 DOCTOR FOUND\n" +
                    "────────────────────\n" +
                    "ID: " + cursor.getString(0) + "\n" +
                    "NAME: " + cursor.getString(1) + " " + cursor.getString(2) + "\n" +
                    "CONTACT: " + cursor.getString(3) + "\n" +
                    "SPECIALTY: " + cursor.getString(6);

            tvResult.setText(output);
            tvResult.animate().alpha(1.0f).setDuration(500); // Smooth fade in
        } else {
            tvResult.setText("❌ No records found for ID: " + sid);
        }
        if (cursor != null) cursor.close();
    }

    private void clearFields() {
        etDocId.setText("");
        etFn.setText("");
        etLn.setText("");
        etMob.setText("");
        etSpec.setText("");
        etDocId.requestFocus();
    }

    // --- SQLite Engine ---
    static class DBHelper extends SQLiteOpenHelper {
        private static final String DBNAME = "HospitalCenter.db";

        public DBHelper(Context context) {
            super(context, DBNAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE Doc_detail(doc_id TEXT PRIMARY KEY, firstname TEXT, lastname TEXT, mob TEXT, address TEXT, city TEXT, specialization TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int old, int newV) {
            db.execSQL("DROP TABLE IF EXISTS Doc_detail");
            onCreate(db);
        }

        public boolean insertDoctor(String id, String fn, String ln, String mb, String ad, String ct, String sp) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("doc_id", id);
            cv.put("firstname", fn);
            cv.put("lastname", ln);
            cv.put("mob", mb);
            cv.put("address", ad);
            cv.put("city", ct);
            cv.put("specialization", sp);
            long res = db.insert("Doc_detail", null, cv);
            return res != -1;
        }

        public Cursor searchDoctor(String id) {
            SQLiteDatabase db = this.getReadableDatabase();
            return db.rawQuery("SELECT * FROM Doc_detail WHERE doc_id = ?", new String[]{id});
        }
    }
}