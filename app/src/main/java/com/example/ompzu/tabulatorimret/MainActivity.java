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
import android.widget.TextView;

import com.example.ompzu.tabulatorimret.CalcEngine;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> input = new ArrayList<String>();
    private TextView textViewResult;
    public static String nr = "";
    private static String showResult="";
    private static String showEquation="";
    private static String btnId="";
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onCreate called");
        }
        textViewResult = (TextView) findViewById(R.id.textViewResult);
    }


    public void buttonClicked(View view){
        Button btn = (Button) view;

         btnId = btn.getResources().getResourceName(btn.getId());
         btnId = btnId.substring(btnId.length() - 1, btnId.length());
       /* if(mem.isEmpty()){
            btnId = btnId.substring(btnId.length() - 1, btnId.length());
            mem = btnId;
        } else {
            btnId = mem;
        }
*/


        if(btnId.equals("E")){ //input is equals
            if(!nr.isEmpty()){
                input.add(nr);  //operation inserted, finsih the nr, add to arraylist and clean the string
            } else {
                nr = "";//remove number from memory
            }
            if(input.size() < 3) input.indexOf(0); //TODO// in finishing, send result to displayscreen
        }

        if(!btnId.equals("P") && !btnId.equals("M") && !btnId.equals("X") &&
                !btnId.equals("D") && !btnId.equals("C") && !btnId.equals("E") &&
                !btnId.equals("W") && !btnId.equals("N") && !btnId.equals("S")){ //input is number
            if(btnId.equals("K") && !input.contains(".")){
                btnId = ".";
                nr = nr + btnId;
            } else {
                nr = nr + btnId; //click 7 nr is 7, click 4 and nr is 74, click 1 nr is 741
                showEquation = showEquation + btnId;
            }

        }

        if (btnId.equals("P") || btnId.equals("M") || btnId.equals("X") || btnId.equals("D") ||
                btnId.equals("W") || btnId.equals("N") || btnId.equals("S") ) { //input is operation
            if(!nr.isEmpty()){
                input.add(nr); //operation inserted, finsih the nr, add to arraylist and clean the string
            }
            if(input.size() == 1 && input.size() < 3){
                nr = ""; //remove number from memory
                showEquation = showEquation + btn.getText().toString();
                input.add(btnId);
            }

        }



        if(btnId.contains("C")) { //input is Clear function
            input.clear();
            nr = "";//remove number from memory
            showResult ="";
            showEquation="";
            if(BuildConfig.DEBUG) Log.d( TAG,"Array reset: " + input.toString());
        }
        int firstOsCheck = 0;
        int secondOsCheck= 0;
       // input.add(nr);
        if(input.size() > 0){
            firstOsCheck = CalcEngine.compare(input.get(0)); //returns 0 if string in arraylist slot equals to operation, else its number
        }

        if(input.size() == 3){
            secondOsCheck = CalcEngine.compare(input.get(2)); //returns 0 if string in arraylist slot equals to operation, else its number
        }

            if(input.size() == 3 && firstOsCheck != 0 && secondOsCheck != 0
                    &&(input.contains("P") || input.contains("M") || input.contains("X") ||
                    input.contains("D") || input.contains("W"))){
                input = CalcEngine.operation(input); //the operation will be done and equation will be calculated
        } else if(input.size() == 2 && (btnId.contains("S") ||btnId.contains("N"))){
                input = CalcEngine.operation(input); //the operation will be done and equation will be calculated
            }
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "Button clicked: " + btnId + " in array: " + input.toString());
        }

        if(input.size() == 1){
            showResult = input.get(0);
        }

        textViewResult = (TextView) findViewById(R.id.textViewResult);
        if(btnId.equals("E")) {
            textViewResult.setText( showEquation = showEquation + " = " + showResult);
        } else  {

            textViewResult.setText(showEquation + " ");
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
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        textViewResult.setText(showEquation);
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
