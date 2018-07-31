package com.example.diamonds.diamonds;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button go=(Button)findViewById(R.id.go);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,SeeAll.class);
                startActivity(i);
            }
        });
    }



//                URL url=new URL(DATA);
//
//
//                final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
//                OkHttpClient client=new OkHttpClient();
//                RequestBody body= RequestBody.create(JSON,jsonObject.toString());
//                Request request=new Request.Builder()
//                        .url(DATA)
//                        .post(body)
//                        .build();
//                   Response response=client.newCall(request).execute();
//                    result_response=response.body().string();
//
}
