package com.krishna.mydemoapp.example.espresso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.krishna.mydemoapp.R;

import java.util.ArrayList;
import java.util.List;

public class EspressoExample extends AppCompatActivity {

    Button newADD;
    private List<EspressoModel> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private EspressoAdaptor mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_example);
        String stringXMl =  getIntent().getStringExtra("EspressTest");
        Xmlbinder();
        if(stringXMl != null){
            EspressoModel espressoModel = new EspressoModel(stringXMl,stringXMl);
            list.add(espressoModel);
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
        mAdapter = new EspressoAdaptor(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        newADD = (Button)findViewById(R.id.new_add);

    }
}
