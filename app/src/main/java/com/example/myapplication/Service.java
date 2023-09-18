//package com.example.myapplication;
//
//import android.content.Context;
//import android.media.MediaRecorder;
//import android.util.Log;
//import android.widget.Toast;
//import java.io.IOException;
//
//import java.io.File;
//
//import android.content.Context;
//
//public class Service {
//    private static final String TAG = "MainActivity";
//    public static MediaRecorder mediaRecorder;
//    public static boolean isRecording = false; // Declare isRecording as a class-level variable
//
//
//    // Start recording method
//    public static void startRecording() {
//        if (!isRecording) {
//            Context context = context.getApplicationContext();
//            File[] externalCacheDirs = context.getExternalCacheDirs();
////            File externalCacheDir = new MyReceiver().onReceive();
////            File externalCacheDir = public abstract File[] getExternalCacheDirs();
//            if (externalCacheDirs != null) {
//                try {
//                    mediaRecorder = new MediaRecorder();
//                    mediaRecorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
//                    mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
//                    mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
//                    mediaRecorder.setOutputFile(externalCacheDirs.getAbsolutePath() + "/call_recording.3gp");
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
//    // Stop recording method
//    public static void stopRecording() {
//        if (isRecording) {
//            mediaRecorder.stop();
//            mediaRecorder.release();
//            mediaRecorder = null;
//            isRecording = false;
//            Log.d(TAG, "Recording stopped");
//            showToast("Recording stopped");
////          showToast("Hello, Android!");
//        }
//    }
//    private static void showToast(String message) {
//        Toast.makeText(new MainActivity(), message, Toast.LENGTH_SHORT).show();
//    }
//
////    private void showToast(String message) {
////        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
////    }
//}
