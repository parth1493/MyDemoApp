package com.krishna.mydemoapp.example.webapi;

import android.app.ProgressDialog;
import android.app.usage.NetworkStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.krishna.mydemoapp.R;
import com.krishna.mydemoapp.example.utill.ValidationClass;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static java.security.AccessController.getContext;

public class WebApiExample extends AppCompatActivity {

    private ListView listView;
    private String TAG = WebApiExample.class.getSimpleName();
    private ProgressDialog pDialog;
    String httpString = "https://api.androidhive.info/contacts/";
    private BroadcastReceiver receiver;
    ArrayList<String> myList;
    ArrayList<Contacts> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_api_example);
        xmlBlind();
        registerReceiver();

    }

    private void xmlBlind() {
        listView = (ListView)findViewById(R.id.list);
    }

    private void registerReceiver() {
        Log.d("Check internet","User partiicpant register");
        // register connection status listener
        //  MyApplication.getInstance().setConnectivityListener(this);
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                setStatus();

            }
        };
        this.registerReceiver(receiver, intentFilter);
    }


    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(WebApiExample.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected Void doInBackground(Void... arg0) {


            GetDataExample example = new GetDataExample();
            try {
                String response = example.run(httpString);

                Moshi moshi = new Moshi.Builder().build();

                JsonAdapter<Contacts> personAdapter = moshi.adapter(Contacts.class);
                Contacts contacts = null;
                myList = new ArrayList<>();
                try{
                    contacts = personAdapter.fromJson(response);
                }catch (IOException io){

                }
                Log.d("Json", "doInBackground() called with: " + "params = [" + personAdapter.toJson(contacts) + "]");
                for(Person p:contacts.getContacts()){
                    myList.add("id: " +p.getId() + "\nName: "+ p.getName());
                }
                list = new ArrayList<>(Arrays.asList(contacts));

            } catch (IOException e) {
                e.printStackTrace();
            }
//            try {
//                String response = example.run(httpString);
//                Log.d("Json-2", "doInBackground() called with: " + "params = [" + response + "]");
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if (pDialog.isShowing()==true){
                pDialog.dismiss();
                pDialog.dismiss();
                setViewList();
            }
            super.onPostExecute(result);
            // Dismiss the progress dialog

        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(receiver);
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    public void setStatus() {

        if(ValidationClass.checkOnline(getApplicationContext())==true){
            Toast.makeText(getApplicationContext(),"wifi/data Connected",Toast.LENGTH_SHORT).show();
            new GetContacts().execute();
        }else{
            Toast.makeText(getApplicationContext(),"wifi/data Not Connected",Toast.LENGTH_SHORT).show();
        }
    }
    public void setViewList(){
        listView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,myList));

    }
}
