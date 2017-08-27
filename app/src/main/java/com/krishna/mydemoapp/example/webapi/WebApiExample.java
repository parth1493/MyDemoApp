package com.krishna.mydemoapp.example.webapi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static java.security.AccessController.getContext;

public class WebApiExample extends AppCompatActivity {

    private ListView listView;
    private String TAG = WebApiExample.class.getSimpleName();
    private ProgressDialog pDialog;
    //String httpString = "https://api.androidhive.info/contacts/";
    String httpString = "https://api.friendngo.com/api/getActivities/";
    String httpString2 = "https://api.friendngo.com/api/getNumberOfAvailableUsers/";
    private BroadcastReceiver receiver;
    ArrayList<String> myList;
    String rr = "  [\n" +
            "    {\n" +
            "        \"id\": 240,\n" +
            "        \"activity_name\": \"hablamos español\",\n" +
            "        \"creator_age\": 24,\n" +
            "        \"creator_pk\": 301,\n" +
            "        \"creator\": \"Gerry\",\n" +
            "        \"status\": \"Resident\",\n" +
            "        \"home_nationality\": \"Venezuela\",\n" +
            "        \"home_city\": \"Montreal\",\n" +
            "        \"max_users\": 20,\n" +
            "        \"activity_time\": \"2017-08-27T22:00:00Z\",\n" +
            "        \"activity_end_time\": \"2017-08-27T22:30:00Z\",\n" +
            "        \"activity_type\": \"Other\",\n" +
            "        \"activity_lon\": -73.566301,\n" +
            "        \"activity_lat\": 45.5067062,\n" +
            "        \"category\": \"Social Activities\",\n" +
            "        \"address\": \"294 Rue Sainte-Catherine O, Montréal, QC H2X 2A1, Canada\",\n" +
            "        \"description\": \"No Description\",\n" +
            "        \"additional_notes\": \"None\",\n" +
            "        \"points\": 1869,\n" +
            "        \"picture\": \"https://friendngodjango-s3-bucket.s3.amazonaws.com/Images/Image-3698.jpg\",\n" +
            "        \"attending\": [\n" +
            "            {\n" +
            "                \"id\": 301,\n" +
            "                \"picture\": \"https://friendngodjango-s3-bucket.s3.amazonaws.com/Images/Image-3698.jpg\",\n" +
            "                \"first_name\": \"Gerry\",\n" +
            "                \"languages\": [\n" +
            "                    {\n" +
            "                        \"name\": \"Spanish\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"English\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"name\": \"French\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        ],\n" +
            "        \"is_paid\": false,\n" +
            "        \"event_picture\": null,\n" +
            "        \"requests_received\": [],\n" +
            "        \"is_canceled\": false,\n" +
            "        \"organization_logo\": null,\n" +
            "        \"organization_name\": null,\n" +
            "        \"organization_pk\": null,\n" +
            "        \"is_too_light\": null\n" +
            "    }\n" +
            "  ]";
    String rs =
            "  [\n" +
            "    {\n" +
            "      \"id\": 238,\n" +
            "      \"activity_name\": \"Fin de Journée à Anticafé\",\n" +
            "      \"creator_age\": 24,\n" +
            "      \"creator_pk\": 301,\n" +
            "      \"creator\": \"Gerry\",\n" +
            "      \"status\": \"Resident\",\n" +
            "      \"home_nationality\": \"Venezuela\",\n" +
            "      \"home_city\": \"Montreal\",\n" +
            "      \"max_users\": 100,\n" +
            "      \"activity_time\": \"2017-08-26T22:00:00Z\",\n" +
            "      \"activity_end_time\": \"2017-08-27T01:00:00Z\",\n" +
            "      \"activity_type\": \"Eat In\",\n" +
            "      \"activity_lon\": -73.5663989,\n" +
            "      \"activity_lat\": 45.5067194,\n" +
            "      \"category\": \"Social Activities\",\n" +
            "      \"address\": \"294 Saint-Catherine St W, Montreal, QC H2X 2A1, Canada\",\n" +
            "      \"description\": \"L'Anticafé c'est tout le contraire d'un café traditionnel... premièrement l'ambiance donne l'impression d'être dans un second chez soi puisque le décor chaleureux permet rapidement de s'approprier l'endroit comme si nous étions à la maison.  À l'Anticafé vous ne payez pas pour ce que vous consommer, car tout est gratuit et à volonté! En fait, nous vous demandons tout simplement de contribuer un petit montant pour le moment que vous passerez dans notre environnement. Le tarif en question est de 3$ pour la première heure et de 2$ pour les heures additionnelles, pour un maximum de 9$ par jour, quelle aubaine considérant que le café, le thé les biscuits, les fruits, le WIFI et plus encore est inclus dans ce prix!\",\n" +
            "      \"additional_notes\": \".\",\n" +
            "      \"points\": 1769,\n" +
            "      \"picture\": \"https://friendngodjango-s3-bucket.s3.amazonaws.com/Images/Image-3698.jpg\",\n" +
            "      \"attending\": [\n" +
            "        {\n" +
            "          \"id\": 344,\n" +
            "          \"picture\": \"https://friendngodjango-s3-bucket.s3.amazonaws.com/Images/344-392-profileImage.jpg\",\n" +
            "          \"first_name\": \"Emilie dC\",\n" +
            "          \"languages\": [\n" +
            "            {\n" +
            "              \"name\": \"french\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"name\": \"english\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"name\": \"spanish\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"id\": 301,\n" +
            "          \"picture\": \"https://friendngodjango-s3-bucket.s3.amazonaws.com/Images/Image-3698.jpg\",\n" +
            "          \"first_name\": \"Gerry\",\n" +
            "          \"languages\": [\n" +
            "            {\n" +
            "              \"name\": \"Spanish\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"name\": \"English\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"name\": \"French\"\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"is_paid\": true,\n" +
            "      \"event_picture\": \"https://friendngodjango-s3-bucket.s3.amazonaws.com/Images/Anti_cafe_event.jpg\",\n" +
            "      \"requests_received\": [],\n" +
            "      \"is_canceled\": false,\n" +
            "      \"organization_logo\": \"https://friendngodjango-s3-bucket.s3.amazonaws.com/Images/Anticafe.jpg\",\n" +
            "      \"organization_name\": \"Anticafé\",\n" +
            "      \"organization_pk\": 25,\n" +
            "      \"is_too_light\": false\n" +
            "    }\n" +
            "  ]";


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
         //register connection status listener

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
                Log.d("Json", response );

                Moshi moshi = new Moshi.Builder().build();
                Type type = Types.newParameterizedType(List.class, Activities.class);
                JsonAdapter<List<Activities>> activityListJsonAdapterAdapter = moshi.adapter(type);
                List<Activities> activities = null;
                myList = new ArrayList<>();
                try {
                    activities= activityListJsonAdapterAdapter.fromJson(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for(Activities p:activities){
                    myList.add("id: " +p.getId() + "\nName: "+ p.getActivity_name());
                }

               // Log.d("Json", "doInBackground() called with: " + "params = [" + activities.get(0).getAttending().get(1).getFirst_name() + "]");
                //Log.d("Json", "doInBackground() called with: " + "params = [" + activities.get(5)+ "]");


            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                String response = example.run(httpString2);
                Log.d("Json-2", "doInBackground() called with: " + "params = [" + response + "]");

            } catch (IOException e) {
                e.printStackTrace();
            }

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
