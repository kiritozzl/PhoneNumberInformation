package com.example.kirito.phonedestination;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et;
    private Button btn;
    private String num;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = et.getText().toString();
                if (!num.equals("")){
                    Intent intent = new Intent(MainActivity.this,ShowDetails.class);
                    intent.putExtra("num",num);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"手机号码不能为空！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
