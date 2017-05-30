package com.example.mike.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Extra extends AppCompatActivity {

    private static final String TAG = "myFilter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);

        //this gets all the info and stores it in the object data
        Bundle data = getIntent().getExtras();
        if (data == null){
            return;
        }
        //the string in quotes is a key created in the other class with the
        //data you want to pass along
        String message = data.getString("message");
        //creates a textview
        final TextView text = (TextView)findViewById(R.id.textView);
        //sets the text of the textview in this new activity
        text.setText(message);
    }

    //onclcik button is looking for
    public void onClick(View v) {
        //activity you want to launch
        Intent intent = new Intent(this, MainActivity.class);
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
        getMenuInflater().inflate(R.menu.menu_extra, menu);
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
