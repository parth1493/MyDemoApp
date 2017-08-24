package com.krishna.mydemoapp.example.webapi;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.krishna.mydemoapp.R;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WebApiExample extends AppCompatActivity {

    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_api_example);

        new AsyncTask<Void, Void, String>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected String doInBackground(Void... params) {
//                OkHttpClient client = new OkHttpClient();
//                Request request = new Request.Builder()
//                        .url("https://api.github.com/users/ashokslsk")
//                        .build();

//                try (Response response = client.newCall(request).execute()) {
//                    Log.d("Json", "doInBackground() called with: " + "params = [" + response.body().string() + "]");
//                   // return response.body().string();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

                GetDataExample example = new GetDataExample();
                try {
                    String response = example.run("https://api.androidhive.info/contacts/");
                    Log.d("Json", "doInBackground() called with: " + "params = [" + response + "]");
//
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

}
