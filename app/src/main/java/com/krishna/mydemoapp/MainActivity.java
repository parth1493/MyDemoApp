package com.krishna.mydemoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.krishna.mydemoapp.example.espresso.EspressoExample;
import com.krishna.mydemoapp.example.espresso.EspressoModel;
import com.krishna.mydemoapp.example.webapi.WebApiExample;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView webApiExample;
    TextView espressoExmaple;
    public static List<EspressoModel> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xmlBinder();
        webApiExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WebApiExample.class);
                startActivity(intent);
            }
        });
        espressoExmaple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EspressoExample.class);
                startActivity(intent);
            }
        });
    }

    private void xmlBinder() {
        webApiExample = (TextView)findViewById(R.id.web_api_example);
        espressoExmaple = (TextView)findViewById(R.id.espresso_example);
    }
}
