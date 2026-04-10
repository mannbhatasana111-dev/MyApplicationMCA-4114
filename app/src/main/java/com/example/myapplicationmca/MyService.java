package com.example.myapplicationmca;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    Thread backgroundThread;
    boolean isRunning = false;

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        isRunning = true;

        backgroundThread = new Thread(() -> {
            int count = 0;

            while (isRunning) {
                try {
                    Thread.sleep(1000);
                    count++;
                    System.out.println("Service Running: " + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        backgroundThread.start();

        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isRunning = false;
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}