package com.example.cmoadne.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends BaseAvtivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        Button button_back = (Button) findViewById(R.id.button_3_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, "Back to activity 1", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ThirdActivity.this, FirstActivity.class);
                //finish();
                startActivity(intent);
            }
        });
    }
}
