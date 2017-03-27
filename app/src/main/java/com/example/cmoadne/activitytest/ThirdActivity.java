package com.example.cmoadne.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "ThirdActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        //显示栈ID？
        Log.d(TAG, "Task id is " + getTaskId());
        Button button_back = (Button) findViewById(R.id.button_3_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, "Back to activity 1", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ThirdActivity.this, FirstActivity.class);
       //         finish();
                startActivity(intent);
            }
        });
    }
}
