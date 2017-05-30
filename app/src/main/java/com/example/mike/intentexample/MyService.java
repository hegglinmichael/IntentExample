package com.example.mike.intentexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

//this service does not make a thread automatically

public class MyService extends Service {

    private static final String TAG = "michael'sFilter";

    //this is a constructor for this class
    public MyService() {
    }

    //inside here is what you want your service to do when it starts
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //this prints out when the method is called
        Log.i(TAG, "onStartCommand method called");

        //creating a runnable for a thread
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //this is a for loop running this multiple times
                for(int i = 0; i < 5; i++) {
                    //sets a variable equal to 5 seconds into the future during the time it is executed
                    long future = System.currentTimeMillis()+5000;
                    //breaks when current time is greater than the future variable
                    while(System.currentTimeMillis() < future){
                        //this keeps threads from doing the same thing and getting jumbled
                        synchronized (this) {
                            try{
                                //telling the application to wait
                                wait(future-System.currentTimeMillis());
                                //telling user service is doing something(waiting)
                                Log.i(TAG, "Service is doing something");
                                //code to for example check database would go in here
                            }catch (Exception e){}
                        }
                    }
                }
            }
        };

        //creates the thread
        Thread myThread = new Thread(runnable);
        //starts the thread
        myThread.start();

        //if service gets destroyed then trys to restart the service
        return Service.START_STICKY;
    }

    //called when service is destroyed
    @Override
    public void onDestroy() {
        super.onDestroy();
        //this prints out when the onDestroy method is called
        Log.i(TAG, "onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
