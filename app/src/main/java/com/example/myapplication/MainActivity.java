package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//                                CODE VERSION 1
//import android.Manifest;
//import android.content.pm.PackageManager;
//import android.telephony.PhoneStateListener;
//import android.telephony.TelephonyManager;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import androidx.annotation.NonNull;
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//
//public class MainActivity extends AppCompatActivity {
//    private static final int PERMISSION_REQUEST_CODE = 1;
//    private static final String TAG = "MainActivity";
//
//    private CallStateListener callStateListener;
//    private TelephonyManager telephonyManager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
//        callStateListener = new CallStateListener(this);
//
//        Button requestPermissionButton = findViewById(R.id.requestPermissionButton);
//        requestPermissionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                requestPhoneStatePermission();
//            }
//        });
//    }
//
//    private void requestPhoneStatePermission() {
//        if (checkPermission()) {
//            telephonyManager.listen(callStateListener, PhoneStateListener.LISTEN_CALL_STATE);
//            System.out.println("check permission : LISTENING CALL STATE");
//        }
//    }
//
//    private boolean checkPermission() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
//                != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.READ_PHONE_STATE},
//                    PERMISSION_REQUEST_CODE);
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//                                           @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        if (requestCode == PERMISSION_REQUEST_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // Permission granted, start listening to call state
//                telephonyManager.listen(callStateListener, PhoneStateListener.LISTEN_CALL_STATE);
//                System.out.println("Permission granted : start listening to call state");
//            } else {
//                // Permission denied, handle accordingly (e.g., show a message or disable functionality)
//                Log.e(TAG, "Permission denied: READ_PHONE_STATE");
//                System.out.println("Permission denied, handle accordingly");
//            }
//        }
//    }
//}
//

//                                      CODE VERSION 2

//import android.Manifest;
//import android.content.pm.PackageManager;
//import android.media.MediaRecorder;
//import android.telephony.PhoneStateListener;
//import android.telephony.TelephonyManager;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import androidx.annotation.NonNull;
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//import java.io.IOException;
//
//public class MainActivity extends AppCompatActivity {
//    private static final int PERMISSION_REQUEST_CODE = 1;
//    private static final String TAG = "MainActivity";
//
//    private CallStateListener callStateListener;
//    private TelephonyManager telephonyManager;
//    private MediaRecorder mediaRecorder;
//    private boolean isRecording = false;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
//        callStateListener = new CallStateListener(this);
//
//        Button requestPermissionButton = findViewById(R.id.requestPermissionButton);
//        requestPermissionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                requestPhoneStatePermission();
//            }
//        });
//
//        Button startStopRecordingButton = findViewById(R.id.startStopRecordingButton);
//        startStopRecordingButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isRecording) {
//                    stopRecording();
//                } else {
//                    startRecording();
//                }
//            }
//        });
//    }
//
//    private void requestPhoneStatePermission() {
//        if (checkPermission()) {
//            telephonyManager.listen(callStateListener, PhoneStateListener.LISTEN_CALL_STATE);
//        }
//    }
//
//    private boolean checkPermission() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
//                != PackageManager.PERMISSION_GRANTED ||
//                ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
//                        != PackageManager.PERMISSION_GRANTED ||
//                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                        != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                    new String[]{
//                            Manifest.permission.READ_PHONE_STATE,
//                            Manifest.permission.RECORD_AUDIO,
//                            Manifest.permission.WRITE_EXTERNAL_STORAGE
//                    },
//                    PERMISSION_REQUEST_CODE);
//            return false;
//        }
//        return true;
//    }
//
//    private void startRecording() {
//        if (!isRecording) {
//            try {
//                mediaRecorder = new MediaRecorder();
//                mediaRecorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
//                mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
//                mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
//                mediaRecorder.setOutputFile(getExternalCacheDir().getAbsolutePath() + "/call_recording.3gp");
//                mediaRecorder.prepare();
//                mediaRecorder.start();
//                isRecording = true;
//                Log.d(TAG, "Recording started");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void stopRecording() {
//        if (isRecording) {
//            mediaRecorder.stop();
//            mediaRecorder.release();
//            mediaRecorder = null;
//            isRecording = false;
//            Log.d(TAG, "Recording stopped");
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//                                           @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        if (requestCode == PERMISSION_REQUEST_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // Permission granted, start listening to call state
//                telephonyManager.listen(callStateListener, PhoneStateListener.LISTEN_CALL_STATE);
//            } else {
//                // Permission denied, handle accordingly (e.g., show a message or disable functionality)
//                Log.e(TAG, "Permission denied: READ_PHONE_STATE or RECORD_AUDIO or WRITE_EXTERNAL_STORAGE");
//            }
//        }
//    }
//}


//                                     CODE VERSION 3

//import android.Manifest;
//import android.content.pm.PackageManager;
//import android.media.MediaRecorder;
//import android.telephony.PhoneStateListener;
//import android.telephony.TelephonyManager;
//import android.util.Log;
//import android.widget.Toast;
//import androidx.annotation.NonNull;
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//import java.io.IOException;
//
//public class MainActivity extends AppCompatActivity {
//    private static final int PERMISSION_REQUEST_CODE = 1;
//    private static final String TAG = "MainActivity";
//
//    private CallStateListener callStateListener;
//    private TelephonyManager telephonyManager;
//    private MediaRecorder mediaRecorder;
//    private boolean isRecording = false;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
//        callStateListener = new CallStateListener(this);
//
//        requestPhoneStatePermission();
//    }
//
//    private void requestPhoneStatePermission() {
//        if (checkPermission()) {
//            telephonyManager.listen(callStateListener, PhoneStateListener.LISTEN_CALL_STATE);
//        }
//    }
//
//    private boolean checkPermission() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
//                != PackageManager.PERMISSION_GRANTED ||
//                ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
//                        != PackageManager.PERMISSION_GRANTED ||
//                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                        != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                    new String[]{
//                            Manifest.permission.READ_PHONE_STATE,
//                            Manifest.permission.RECORD_AUDIO,
//                            Manifest.permission.WRITE_EXTERNAL_STORAGE
//                    },
//                    PERMISSION_REQUEST_CODE);
//            return false;
//        }
//        return true;
//    }
//
//    private void startRecording() {
//        if (!isRecording) {
//            try {
//                mediaRecorder = new MediaRecorder();
//                mediaRecorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
//                mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
//                mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
//                mediaRecorder.setOutputFile(getExternalCacheDir().getAbsolutePath() + "/call_recording.3gp");
//                mediaRecorder.prepare();
//                mediaRecorder.start();
//                isRecording = true;
//                Log.d(TAG, "Recording started");
//                showToast("Recording started");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void stopRecording() {
//        if (isRecording) {
//            mediaRecorder.stop();
//            mediaRecorder.release();
//            mediaRecorder = null;
//            isRecording = false;
//            Log.d(TAG, "Recording stopped");
//            showToast("Recording stopped");
//        }
//    }
//
//    private void showToast(String message) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//                                           @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        if (requestCode == PERMISSION_REQUEST_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // Permission granted, start listening to call state
//                telephonyManager.listen(callStateListener, PhoneStateListener.LISTEN_CALL_STATE);
//            } else {
//                // Permission denied, handle accordingly (e.g., show a message or disable functionality)
//                Log.e(TAG, "Permission denied: READ_PHONE_STATE or RECORD_AUDIO or WRITE_EXTERNAL_STORAGE");
//            }
//        }
//    }
//}


//                                        CODE VERSION 4

import android.Manifest;
import android.content.pm.PackageManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final String TAG = "MainActivity";

    public CallStateListener callStateListener;
    private TelephonyManager telephonyManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        callStateListener = new CallStateListener(this);

        requestPhoneStatePermission();
    }

    private void requestPhoneStatePermission() {
        if (checkPermission()) {
            telephonyManager.listen(callStateListener, PhoneStateListener.LISTEN_CALL_STATE);
        }
    }

    private boolean checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
                        != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.READ_PHONE_STATE,
                            Manifest.permission.RECORD_AUDIO,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    },
                    PERMISSION_REQUEST_CODE);
            return false;
        }
        return true;
    }

//    private void startRecording() {
//        if (!isRecording) {
//            try {
//                mediaRecorder = new MediaRecorder();
//                mediaRecorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
//                mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
//                mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
//                mediaRecorder.setOutputFile(getExternalCacheDir().getAbsolutePath() + "/call_recording.3gp");
//                mediaRecorder.prepare();
//                mediaRecorder.start();
//                isRecording = true;
//                Log.d(TAG, "Recording started");
//                showToast("Recording started");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

//    private startRecording() {
//        if (!isRecording) {
//            File externalCacheDir = getExternalCacheDir();
//            if (externalCacheDir != null) {
//                try {
//                    mediaRecorder = new MediaRecorder();
//                    mediaRecorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
//                    mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
//                    mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
//                    mediaRecorder.setOutputFile(externalCacheDir.getAbsolutePath() + "/call_recording.3gp");
//                    mediaRecorder.prepare();
//                    mediaRecorder.start();
//                    isRecording = true;
//                    Log.d(TAG, "Recording started");
//                    showToast("Recording started");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                Log.e(TAG, "External cache directory is null");
//                showToast("Error: External cache directory is null");
//            }
//        }
//    }
//
//
//    public void stopRecording() {
//        if (isRecording) {
//            mediaRecorder.stop();
//            mediaRecorder.release();
//            mediaRecorder = null;
//            isRecording = false;
//            Log.d(TAG, "Recording stopped");
//            showToast("Recording stopped");
//        }
//    }
//
//    public void showToast(String message) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, start listening to call state
                telephonyManager.listen(callStateListener, PhoneStateListener.LISTEN_CALL_STATE);
            } else {
                // Permission denied, handle accordingly (e.g., show a message or disable functionality)
                Log.e(TAG, "Permission denied: READ_PHONE_STATE or RECORD_AUDIO or WRITE_EXTERNAL_STORAGE");
            }
        }
    }
}
