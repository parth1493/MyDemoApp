package com.krishna.mydemoapp.example.espresso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.krishna.mydemoapp.R;

public class EspressoExampleSecondActivity extends AppCompatActivity {
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_example_second);
        String stringXMl =  getIntent().getStringExtra("EspressTest");
        Xmlbinder(stringXMl);
    }

    private void Xmlbinder(String stringXMl) {
        output = (TextView)findViewById(R.id.output);
        output.setText(stringXMl);
    }
}
