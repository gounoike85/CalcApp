package com.example.oga.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Intentの値を取得
        Intent intent = getIntent();
        float answer = intent.getFloatExtra("answer", 0);

        // TextViewに表示
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.valueOf(answer));
    }
}
