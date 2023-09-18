package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.io.File;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Access the external cache directory using the 'context' parameter
        File externalCacheDir = context.getExternalCacheDir();

        if (externalCacheDir != null) {
            // Use 'externalCacheDir' as needed
            String cachePath = externalCacheDir.getAbsolutePath();
            // ...
        } else {
            // Handle the case where 'externalCacheDir' is null
        }
    }

}
