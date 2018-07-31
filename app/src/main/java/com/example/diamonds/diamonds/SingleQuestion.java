package com.example.diamonds.diamonds;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class SingleQuestion extends AppCompatActivity {


    TextView q;
    EditText a;
    String id,question,answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_question);
        Intent i=getIntent();
        id=i.getStringExtra("id");
        question=i.getStringExtra("question");
        q=(TextView) findViewById(R.id.q);
        q.setText(question);
        a=(EditText)findViewById(R.id.a);
        Button post=(Button)findViewById(R.id.post);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PostRequest().execute();
            }
        });
    }
    public class PostRequest extends AsyncTask<Void,Void,String>{
        String result_response;
        @Override
        protected String doInBackground(Void... voids) {
            String DATA="http://neel1998.pythonanywhere.com/ans";
            answer=a.getText().toString();

            JSONObject jsonObject=new JSONObject();
            try {
                jsonObject.put("qid",id);
                jsonObject.put("ans",answer);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                URL url=new URL(DATA);
                final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
                OkHttpClient client=new OkHttpClient();
                RequestBody body= RequestBody.create(JSON,jsonObject.toString());
                Request request=new Request.Builder()
                        .url(DATA)
                        .post(body)
                        .build();
                Response response=client.newCall(request).execute();
                result_response=response.body().string();
            }
            catch (MalformedURLException e) {}
            catch (IOException e) {}

            return result_response;
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(SingleQuestion.this,s,Toast.LENGTH_SHORT).show();
            Intent j=new Intent(SingleQuestion.this,SeeAll.class);
            startActivity(j);
        }
    }
}
