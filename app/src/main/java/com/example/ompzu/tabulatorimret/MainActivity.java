package com.example.ompzu.tabulatorimret;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> input = new ArrayList<String>();
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onCreate called");
        }

    }


    public void buttonClicked(View view){
        Button btn = (Button) view;
        String btnId = btn.getResources().getResourceName(btn.getId());
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "Button clicked: " + btnId.substring(btnId.length() - 1, btnId.length()));
        }
        input.add(btnId);
        if(input.size() == 3){
            if(input.contains("buttonPlus")){
                double a = Double.parseDouble(input.get(0));
                double b = Double.parseDouble(input.get(2));
                double result = CalcEngine.plus(a,b);
                input.clear();
                input.add(String.valueOf(result));
            }
        }
        if(input.contains("E")){

        }
        int a = Integer.parseInt(btnId.substring(btnId.length() - 1, btnId.length()));

    }


    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.


    }

    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onResume called");
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onPause called");
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onStop called");
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onDestroy called");
        }

    }
}
