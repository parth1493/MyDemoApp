package com.krishna.mydemoapp.example.espresso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.krishna.mydemoapp.R;

public class EspressoExampleSecondActivity extends AppCompatActivity {

    EditText firstName;
    EditText secondName;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_example_second);


        xmlBind();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EspressoExampleSecondActivity.this,EspressoExample.class);
                intent.putExtra("EspressTest",firstName.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void xmlBind() {
        firstName = (EditText)findViewById(R.id.first_name);

        secondName = (EditText)findViewById(R.id.second_name);

        add = (Button)findViewById(R.id.add);
    }
}
