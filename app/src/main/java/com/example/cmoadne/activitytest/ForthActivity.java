package com.example.cmoadne.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ForthActivity extends AppCompatActivity {

    private static final String TAG = "ForthActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forth_layout);
        Button button_back = (Button) findViewById(R.id.button_4_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ForthActivity.this, "Back to activity 1", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ForthActivity.this, FirstActivity.class);
                finish();
                startActivity(intent);
            }
        });
        Button button_back_data = (Button) findViewById(R.id.button_4_back_data);
        button_back_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ForthActivity.this, "Back to activity 1 with data", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello Activity 1");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Intent intent = getIntent();
        //如果有值传入
        if(intent.hasExtra("Extra_data")) {
            String data = intent.getStringExtra("Extra_data");
            Log.d(TAG, data);
        }
    }

    //重写底下返回键点击
    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        //键值
        intent.putExtra("data_return", "Hello Activity 1");
        //返回信号状态
        setResult(RESULT_OK, intent);
        finish();
    }
}
