package com.example.android.androidwebserver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private AndroidWebServer androidWebServer;
    private BroadcastReceiver broadcastReceiverNetworkState;
    private static boolean isStarted = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //startAndroidWebServer();
//        Intent i = new Intent(this, WebServer.class);
//        startService(i);
    }

    private boolean startAndroidWebServer() {
        if (!isStarted) {
            try {
                androidWebServer = new AndroidWebServer("192.168.1.3", 8080);
                Log.d(TAG, "startAndroidWebServer host:" + androidWebServer.getHostname() + " port:" + androidWebServer.getListeningPort());
                androidWebServer.start();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}