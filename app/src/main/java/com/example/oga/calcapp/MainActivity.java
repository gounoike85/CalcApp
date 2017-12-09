package com.example.oga.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.text.InputType;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 計算対象の数値を入れるEditText
    EditText editNum1;
    EditText editNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // editTextの入力制限
        editNum1 = (EditText) findViewById(R.id.editNum1);
        editNum1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        editNum2 = (EditText) findViewById(R.id.editNum2);
        editNum2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        // 各buttonの動き
        Button btnPlus = (Button) findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(this);

        Button btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(this);

        Button btnMulti = (Button) findViewById(R.id.btnMulti);
        btnMulti.setOnClickListener(this);

        Button btnDivid = (Button) findViewById(R.id.btnDivid);
        btnDivid.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        // 計算用の変数
        float answer;
        float num1;
        float num2;

        // EditTextの値を取得
        if(editNum1.length() == 0) {
            num1 = 0.0f;
        } else {
            num1 = Float.parseFloat(editNum1.getText().toString());
        }

        if(editNum2.length() == 0) {
            num2 = 0.0f;
        } else {
            num2 = Float.parseFloat(editNum2.getText().toString());
        }

        // ボタンによって計算を振り分け
        if (v.getId() == R.id.btnPlus) {
            answer = num1 + num2;
        } else if (v.getId() == R.id.btnMinus) {
            answer = num1 - num2;
        } else if (v.getId() == R.id.btnMulti) {
            answer = num1 * num2;
        } else {
            // 0が入っている場合は答えに0.0fを代入
            if(num1 == 0.0f || num2 == 0.0f) {
                answer = 0.0f;
            } else {
                answer = num1 / num2;
            }
        }

        // Intentで値を渡す
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("answer", answer);
        startActivity(intent);
    }
}
