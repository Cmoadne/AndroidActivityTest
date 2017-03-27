package com.example.cmoadne.activitytest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends BaseAvtivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Button button_back = (Button) findViewById(R.id.button_2_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1、toast
                //来龙去脉 内容 时长
                Toast.makeText(SecondActivity.this, "Back to activity 1", Toast.LENGTH_SHORT).show();

                //2、销毁活动
/*                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    //TODO Auto-generated catch block
                    e.printStackTrace();
                }*/
                //销毁活动
                //finish();

                //3、显示Intent
                Intent intent = new Intent(SecondActivity.this,FirstActivity.class);
                //finish();
                startActivity(intent);
            }
        });
    }

    //启用活动的最佳写法，这样可以一目了然指定活动需要什么参数
    public static void startAction(Context context,String string1,String string2){
        Intent intent = new Intent(context,SecondActivity.class);
        intent.putExtra("data_param1",string1);
        intent.putExtra("data_param2",string2);
        context.startActivity(intent);
    }
}
