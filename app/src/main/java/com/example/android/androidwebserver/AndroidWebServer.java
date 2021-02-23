package com.example.android.androidwebserver;

import android.util.Log;

import java.util.Map;

import fi.iki.elonen.NanoHTTPD;

public class AndroidWebServer extends NanoHTTPD {
    private static final String TAG = "AndroidWebServer";

    public AndroidWebServer(int port) {
        super(port);
    }

    public AndroidWebServer(String hostname, int port) {
        super(hostname, port);
    }

    @Override
    public Response serve(IHTTPSession session) {
        String msg = "<html><body><h1>Hello server</h1>\n";
        Map<String, String> parms = session.getParms();
        parms.forEach((key, name) -> Log.d(TAG, "key:" + key + "name:" + name));
        if (parms.get("username") == null) {
            msg += "<form action='?' method='get'>\n  <p>Your name: <input type='text' name='username'></p>\n" + "</form>\n";
        } else {
            msg += "<p>Hello, " + parms.get("username") + "!</p>";
        }
        return newFixedLengthResponse(msg + "</body></html>\n");
    }
}
