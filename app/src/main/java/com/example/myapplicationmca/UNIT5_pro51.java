package com.example.myapplicationmca;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class UNIT5_pro51 extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient;
    private TextView tvLatitude, tvLongitude;
    private Button btnFetch;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit5_pro51);

        // Link UI components
        tvLatitude = findViewById(R.id.tvLatitude);
        tvLongitude = findViewById(R.id.tvLongitude);
        btnFetch = findViewById(R.id.btnGetLocation);

        // Initialize Location Client
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        btnFetch.setOnClickListener(v -> {
            requestLocationUpdates();
        });
    }

    private void requestLocationUpdates() {
        // Check if permissions are granted
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Request permissions if not granted
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else {
            // Permissions are granted, fetch location
            fetchLastLocation();
        }
    }

    private void fetchLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            tvLatitude.setText("Latitude: " + location.getLatitude());
                            tvLongitude.setText("Longitude: " + location.getLongitude());
                            Toast.makeText(UNIT5_pro51.this, "Location Updated", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(UNIT5_pro51.this, "Location not found. Ensure GPS is ON.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                fetchLastLocation();
            } else {
                Toast.makeText(this, "Permission Denied! Cannot access GPS.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}