package com.example.mike.intentexample;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by mike on 8/16/2015.
 */
//when making an intent service it automatically makes a
//thread behind the scenes so two things can run at once

//starts the service in the MainActivity
//look in manifest for what to do with service

//Rules
    //need to have a constructor
    //need to have a method called onHandleIntent(where bulk of code goes)

public class IntentServiceExample extends IntentService {

    private static final String TAG = "com.mike.intentexample";

    //constructor
    public IntentServiceExample() {
        //pass the super class the name of this class
        //rules of android
        super("IntentServiceExample");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //this is what the service does
        Log.i(TAG, "The service has started");
        //could be looking for notification or anything really
    }
}
