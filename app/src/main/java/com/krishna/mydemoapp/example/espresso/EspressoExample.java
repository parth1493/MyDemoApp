package com.krishna.mydemoapp.example.espresso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.krishna.mydemoapp.R;

public class EspressoExample extends AppCompatActivity {
    TextView output;
    Button newADD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_example);
        String stringXMl =  getIntent().getStringExtra("EspressTest");
        Xmlbinder();
        output.setText(stringXMl);
        newADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EspressoExample.this,EspressoExampleSecondActivity.class);
                startActivity(intent);
            }
        });
    }


    private void Xmlbinder() {
        output = (TextView)findViewById(R.id.output);
        newADD = (Button)findViewById(R.id.new_add);
    }
}
