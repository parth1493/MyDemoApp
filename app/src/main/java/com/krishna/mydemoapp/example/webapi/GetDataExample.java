package com.krishna.mydemoapp.example.webapi;

import android.annotation.TargetApi;
import android.os.Build;
import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by krishna on 2017-08-24.
 */

public class GetDataExample {
    OkHttpClient client = new OkHttpClient();


    @TargetApi(Build.VERSION_CODES.KITKAT)
    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
