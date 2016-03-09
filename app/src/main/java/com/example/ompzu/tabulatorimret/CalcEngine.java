package com.example.ompzu.tabulatorimret;

import java.util.ArrayList;

/**
 * Created by Ompzu on 3/9/2016.
 */
public class CalcEngine {
    private static final String TAG = "CalcEngine";
    private static final String[] op = {"c", "x","d","E", "P", "buttonMinus" };
   // public ArrayList<String> input = new ArrayList<String>();


    public static String numerics(){
        String a = "";
        for(double num = 0; num < 10; num++){
            a = a + String.valueOf(num);
        }
        return a;
    }

    public static ArrayList<String> operation(ArrayList<String> in){
        double result = 0;
        double a = Double.parseDouble(in.get(0));
        double b = Double.parseDouble(in.get(2));



        if(in.contains("X")){ //multiply
            result = times(a, b);
        }
        if(in.contains("D")){ //divide
            result = divide(a,b);
        }
        if(in.contains("P")){ // plus
            result = plus(a,b);
        }
        if(in.contains("M")){ //minus
            result = minus(a, b);
        }
        in.clear();
        in.add(String.valueOf(result));
        return in;

    }

    public static double plus(double a, double b){
        return a + b;
    }

    public static double minus (double a, double b){
        return a - b;
    }

    public static double divide(double a, double b){
        return a/b;
    }

    public static double times(double a, double b){
        return a*b;
    }
}
