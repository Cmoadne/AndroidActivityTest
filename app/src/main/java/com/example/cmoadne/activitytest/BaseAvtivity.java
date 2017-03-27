package com.example.cmoadne.activitytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Cmoadne on 2017/3/27.
 */

//这个类不需要注册
public class BaseAvtivity extends AppCompatActivity {
    private static final String TAG = "BaseAvtivity";
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        //把该活动加到List
        ActivityCllector.addActivity(this);
        //打印类名
        Log.d(TAG, getClass().getSimpleName());
    }

    //重写onDestroy  从List删除该活动
    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCllector.removeActivity(this);
    }
}
