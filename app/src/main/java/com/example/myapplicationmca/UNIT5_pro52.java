package com.example.myapplicationmca;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class UNIT5_pro52 extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer, lightSensor;
    private TextView tvAccel, tvLight;
    private CardView lightCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit5_pro52);

        // 1. Initialize UI components from our refined XML
        tvAccel = findViewById(R.id.tvAccelerometer);
        tvLight = findViewById(R.id.tvLight);
        lightCard = findViewById(R.id.lightCard);

        // 2. Initialize Sensor Manager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // 3. Setup Hardware Sensors with null-checks
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        }

        // 4. Handle cases where sensors might be missing (like on some Emulators)
        if (accelerometer == null) tvAccel.setText("Accelerometer not available");
        if (lightSensor == null) tvLight.setText("Light sensor not available");
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            // Format for the monospace font in our design
            tvAccel.setText(String.format("X: %6.2f\nY: %6.2f\nZ: %6.2f", x, y, z));
        }
        else if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            float lux = event.values[0];
            tvLight.setText(String.format("%.0f lx", lux));

            float alphaValue = Math.max(0.4f, Math.min(1.0f, lux / 500f));
            lightCard.setAlpha(alphaValue);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Typically used for compass calibration, not required for this demo
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register listeners to start receiving data
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
        }
        if (lightSensor != null) {
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // ALWAYS unregister to stop battery drain when app is not visible
        sensorManager.unregisterListener(this);
    }
}