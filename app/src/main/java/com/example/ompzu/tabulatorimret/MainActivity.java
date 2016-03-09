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
import com.example.ompzu.tabulatorimret.CalcEngine;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> input = new ArrayList<String>();

    public static String nr = "";
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
        btnId = btnId.substring(btnId.length() - 1, btnId.length());

        if(!btnId.equals("P") && !btnId.equals("M") && !btnId.equals("X") &&
                !btnId.equals("D") && !btnId.equals("C") && !btnId.equals("E") ){ //input is number
            nr = nr + btnId; //click 7 nr is 7, click 4 and nr is 74, click 1 nr is 741
        }

        if (btnId.equals("P") || btnId.equals("M") || btnId.equals("X") || btnId.equals("D")) { //input is operation
            input.add(nr);
            nr = ""; //remove number from memory
            input.add(btnId);
        }

        if(btnId.equals("E")){ //input is equals
            input.add(nr);
            nr = "";//remove number from memory
            if(input.size() < 3) input.indexOf(0); //TODO// in finishing, send result to displayscreen
        }

        if(btnId.contains("C")) { //input is Clear function
            input.clear();
            nr = "";//remove number from memory
            if(BuildConfig.DEBUG) Log.d( TAG,"Array reset: " + input.toString());
        }

       // input.add(nr);
        if(input.size() == 3 && input.get(0).contains(CalcEngine.numerics()) //TODO
                &&(input.contains("P") || input.contains("M") || input.contains("X") || input.contains("D"))){
           input = CalcEngine.operation(input); //the operation will be done and equation will be calculated
        }
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "Button clicked: " + btnId + " in array: " + input.toString());


        }


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
