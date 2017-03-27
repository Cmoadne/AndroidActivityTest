package com.example.cmoadne.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "FirstActivity";

    //加菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);//文件 对象
        return true;
    }

    //菜单点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //打印
        Log.d(TAG, "onCreate: Activity 1");
        Log.d(TAG, this.toString());
        setContentView(R.layout.first_layout);//给当前活动加载布局
        //点击显示一个toast
        Button button_exit = (Button) findViewById(R.id.button_1_exit);
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //1、显示一个toast
                //来龙去脉 内容 时长
                Toast.makeText(FirstActivity.this, "You clicked Button Exit", Toast.LENGTH_SHORT).show();
                //销毁活动
                finish();
            }
        });
        Button button_evident = (Button) findViewById(R.id.button_1_evident);
        button_evident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //1、显示一个toast
                //来龙去脉 内容 时长
                Toast.makeText(FirstActivity.this, "To Activity 2 Evidently", Toast.LENGTH_SHORT).show();

                //3、显示Intent
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //先销毁再开启活动，只保留一个活动，效果有翻页效果
                finish();
                startActivity(intent);

            }
        });
        Button button_hidden = (Button) findViewById(R.id.button_1_hidden);
        button_hidden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //1、显示一个toast
                //来龙去脉 内容 时长
                Toast.makeText(FirstActivity.this, "To Activity 2 hiddenly", Toast.LENGTH_SHORT).show();

                //4、隐式Intent   Intent参数自定义
                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("SSSSS");
                //3、销毁活动
                finish();
                startActivity(intent);
            }
        });
        Button button_web = (Button) findViewById(R.id.button_1_web);
        button_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //1、显示一个toast
                //来龙去脉 内容 时长
                Toast.makeText(FirstActivity.this, "Open www.baidu.com", Toast.LENGTH_SHORT).show();

                //5、启动其他程序，这里是浏览器
                //内置ACTION
                //选择打开浏览器或者activity3 如果打开activity3 应该销毁这个活动，当时还写不来
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //PARSE将字符串解析为uri对象 通过setData发送出去
                intent.setData(Uri.parse("http://www.baidu.com"));
                //finish();
                startActivity(intent);
            }
        });
        Button button_tel = (Button) findViewById(R.id.button_1_tel);
        button_tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "Open Tel", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
        Button button_send = (Button) findViewById(R.id.button_1_send);
        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "send data to activity 4", Toast.LENGTH_SHORT).show();
                String data = "Hello Activity 4";
                Intent intent = new Intent(FirstActivity.this, ForthActivity.class);
                intent.putExtra("Extra_data", data);
                finish();
                startActivity(intent);
            }
        });
        //配合activity4的有返回back使用
        Button button_get = (Button) findViewById(R.id.button_1_get);
        button_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "get data from activity 4", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FirstActivity.this, ForthActivity.class);
                //finish();
                //第二个参数为请求码，只要是唯一就可以  为了得到返回的数据，ForResult会回调onActivityResult，所以要重写
                startActivityForResult(intent, 1);
            }
        });

        //标准模式启动活动1
        Button button_standard = (Button) findViewById(R.id.button_1_standard);
        button_standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //演示，所以直接继续开活动1
                Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });
    }

    //重写onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //请求码
        switch (requestCode) {
            case 1:
                //返回信号
                if (resultCode == RESULT_OK) {
                    //根据键值取出数据
                    String returnedData = data.getStringExtra("data_return");
                    Log.d(TAG, "onActivityResult: " + returnedData);
                }
                break;
            default:
                break;
        }
    }

}
