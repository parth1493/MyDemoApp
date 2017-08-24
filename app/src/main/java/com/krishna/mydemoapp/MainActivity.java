package com.krishna.mydemoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.krishna.mydemoapp.example.moshi.MoshiExample;
import com.krishna.mydemoapp.example.webapi.WebApiExample;

public class MainActivity extends AppCompatActivity {
    TextView moshiExmaple;
    TextView webApiExample;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xmlBinder();
        moshiExmaple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MoshiExample.class);
                startActivity(intent);
            }
        });
        webApiExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WebApiExample.class);
                startActivity(intent);
            }
        });
    }

    private void xmlBinder() {
        moshiExmaple = (TextView)findViewById(R.id.moshi_exmaple);
        webApiExample = (TextView)findViewById(R.id.web_api_exmaple);
    }
}
