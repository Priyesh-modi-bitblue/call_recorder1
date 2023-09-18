package com.example.myapplication;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;


public class CallStateListener extends PhoneStateListener {
    private static final String TAG = "CallStateListener";
    private final TelephonyManager telephonyManager;

    private Context context2;

    public CallStateListener(Context context) {
        telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        context2 = context;
    }

    @Override
    public void onCallStateChanged(int state, String phoneNumber) {
        super.onCallStateChanged(state, phoneNumber);
        switch (state) {
            case TelephonyManager.CALL_STATE_IDLE:
                // The call has ended or is idle.
                if (Receiver.isRecording) {
                    Receiver.stopRecording();
                    Log.d(TAG, "CALL STATE : RECORDING STOPPED");// Stop recording when the call ends
                }
                Log.d(TAG, "Call state: Idle");
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                // Incoming call is ringing.
                Log.d(TAG, "Call state: Ringing");
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                // A call is in progress.
                if (!Receiver.isRecording) {
                    Receiver.startRecording(context2);
                    Log.d(TAG, "CALL STATE : RECORDING STARTED");
                    // Start recording when the call is off-hook
                }
                Log.d(TAG, "Call state: Offhook");
                break;
        }
    }
}