package com.krishna.mydemoapp.example.webapi;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by krishna on 2017-08-24.
 */

public class GetDataExample {
    OkHttpClient client = new OkHttpClient();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization","Token "+"c3bef47079359d85a228550fecc6a81f3a45c7ce")
                .build();


        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
