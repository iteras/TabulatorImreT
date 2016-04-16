package com.example.ompzu.tabulatorimret;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Ompzu on 4/14/2016.
 */
public class BroadcastReceiver extends android.content.BroadcastReceiver
{
    private static String result ="";
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if(extras != null){

        }
        if(!result.isEmpty()){
            Intent iOut = new Intent("com.example.ompzu.RECEIVE_RESULT");
            iOut.putExtra("result", result);
            result = "";
            context.sendBroadcast(iOut);
        }
        /*
        Intent iOut = result()
        context.sendBroadcast(iOut);*/
    }

}
