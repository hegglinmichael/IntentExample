package com.example.mike.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myFilter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creates an intent to start the service intent
        Intent service_intent = new Intent(this, IntentServiceExample.class);
        //starts the intent service
        startService(service_intent);

        //creates an intent to start the service
        Intent service = new Intent(this, MyService.class);
        //starts the service
        startService(service);

    }

    //onclcik button is looking for
    public void onClick(View v) {
        //activity you want to launch
        Intent intent = new Intent(this, Extra.class);

        //reference to the correct field
        final EditText input = (EditText) findViewById(R.id.editText);
        //getting the text that was put into it
        String message = input.getText().toString();
        //pass along this with the next activity
        intent.putExtra("message", message);

        //method to start the activity
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
