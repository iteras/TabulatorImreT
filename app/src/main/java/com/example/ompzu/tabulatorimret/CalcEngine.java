package com.example.ompzu.tabulatorimret;

/**
 * Created by Ompzu on 3/9/2016.
 */
public class CalcEngine {
    private static final String TAG = "CalcEngine";
    private static final String[] op = {"c", "x","d","E", "P", "buttonMinus" };

    public static double plus(double a, double b){
        return a + b;
    }

    public double minus (double a, double b){
        return a - b;
    }

    public double divide(double a, double b){
        return a/b;
    }

    public double times(double a, double b){
        return a*b;
    }
}
