package com.krishna.mydemoapp.example.espresso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.krishna.mydemoapp.MainActivity;
import com.krishna.mydemoapp.R;

import java.util.ArrayList;
import java.util.List;

public class EspressoExample extends AppCompatActivity {

    Button newADD;

    private RecyclerView recyclerView;
    private EspressoAdaptor mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_example);
        String firstName =  getIntent().getStringExtra("firstName");
        String secondName =  getIntent().getStringExtra("secondName");
        Xmlbinder();
        if(firstName != null){
            EspressoModel espressoModel = new EspressoModel(firstName, secondName);
            MainActivity.list.add(MainActivity.list.size(),espressoModel);
            mAdapter.notifyDataSetChanged();

        }


        newADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EspressoExample.this,EspressoExampleSecondActivity.class);

                startActivity(intent);
            }
        });
    }


    private void Xmlbinder() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new EspressoAdaptor(MainActivity.list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        newADD = (Button)findViewById(R.id.new_add);

    }
}
