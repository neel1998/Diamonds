package com.example.diamonds.diamonds;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SeeAll extends AppCompatActivity {

    ListView list;
    ArrayList<Question> questionList;
    QuestionAdapter questionAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all);
        list=(ListView)findViewById(R.id.list);
        questionList=new ArrayList<>();
        questionAdapter=new QuestionAdapter(this,questionList);
        list.setAdapter(questionAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Question question=(Question) adapterView.getItemAtPosition(i);
                Intent j=new Intent(SeeAll.this,SingleQuestion.class);
                j.putExtra("id",question.getID());
                j.putExtra("question",question.getQuestion());
                startActivity(j);
            }
        });
        new JsonTask().execute();

    }

    public class JsonTask extends AsyncTask<Void,Void,ArrayList<Question>>{
        String test;
        ArrayList<Question> temp=new ArrayList<>();
        @Override
        protected ArrayList<Question> doInBackground(Void... voids) {
            String DATA="http://neel1998.pythonanywhere.com/getAll";
            try {
                URL url=new URL(DATA);
                OkHttpClient client=new OkHttpClient();
                Request request=new Request.Builder()
                        .url(url)
                        .build();
                Response response=client.newCall(request).execute();
                JSONArray jsonArray=new JSONArray(response.body().string());
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject=jsonArray.getJSONObject(i);
                    temp.add(new Question(String.valueOf(jsonObject.getInt("id")),
                                            jsonObject.getString("question"),
                                            jsonObject.getString("answer"),
                                            jsonObject.getString("user")
                            ));
                }
            }
            catch (MalformedURLException e) {}
            catch (IOException e) {}
            catch (JSONException e) {}
            return temp;
        }

        @Override
        protected void onPostExecute(ArrayList<Question> result) {
            questionAdapter.addAll(result);
        }
    }
}
