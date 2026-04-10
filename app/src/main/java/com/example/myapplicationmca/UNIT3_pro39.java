package com.example.myapplicationmca;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class UNIT3_pro39 extends AppCompatActivity {

    private TimePicker timePicker;
    private Button btnSetAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3_pro39);

        timePicker = findViewById(R.id.timePicker);
        btnSetAlarm = findViewById(R.id.btnSetAlarm);

        btnSetAlarm.setOnClickListener(v -> setAlarm());
    }

    private void setAlarm() {
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

        // If time is in the past, set for tomorrow
        if (calendar.getTimeInMillis() <= System.currentTimeMillis()) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);

        // Use FLAG_IMMUTABLE for Android 12+ compatibility
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        if (alarmManager != null) {
            // Check for Exact Alarm permission on Android 12+
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                if (!alarmManager.canScheduleExactAlarms()) {
                    Intent i = new Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM);
                    startActivity(i);
                    return;
                }
            }

            // setExactAndAllowWhileIdle makes sure it works in battery saver mode
            alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(),
                    pendingIntent
            );

            Toast.makeText(this, "Alarm set for " + hour + ":" + String.format("%02d", minute), Toast.LENGTH_LONG).show();
        }
    }
}