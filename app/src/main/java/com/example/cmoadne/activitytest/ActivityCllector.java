package com.example.cmoadne.activitytest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cmoadne on 2017/3/27.
 */

public class ActivityCllector {
    //public 只创建一次的变量
    public static List<Activity> activities = new ArrayList<>();

    //static 修饰方法，可以不需要实例就能外部调用
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    /**
     * @param activity
     */
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    //销毁所有活动
    public static void finishAll(){
        for (Activity activity: activities){
            if (!activity.isFinishing())
                activity.finish();
        }
    }

}
