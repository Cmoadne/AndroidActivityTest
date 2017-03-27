package com.example.cmoadne.activitytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Cmoadne on 2017/3/27.
 */

public class BaseAvtivity extends AppCompatActivity {
    private static final String TAG = "BaseAvtivity";
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        //打印类名
        Log.d(TAG, getClass().getSimpleName());
        
    }
}
