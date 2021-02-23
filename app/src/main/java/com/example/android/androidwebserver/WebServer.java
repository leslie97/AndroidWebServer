package com.example.android.androidwebserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class WebServer extends Service {
    private static final String TAG = "WebServer";

    private AndroidWebServer mAndroidWebServer;

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            mAndroidWebServer = new AndroidWebServer("192.168.1.3", 8080);
            Log.d(TAG, "WebServer host:" + mAndroidWebServer.getHostname() + " port:" + mAndroidWebServer.getListeningPort());
            mAndroidWebServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
