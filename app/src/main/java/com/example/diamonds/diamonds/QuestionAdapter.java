package com.example.diamonds.diamonds;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import javax.xml.transform.Templates;

/**
 * Created by Admin on 25-07-2018.
 */

public class QuestionAdapter extends ArrayAdapter<Question> {
    public QuestionAdapter(Context context, ArrayList<Question> questions){ super(context,0,questions);}
    View resultView;

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        resultView=convertView;
        if(resultView==null){
            resultView= LayoutInflater.from(getContext()).inflate(R.layout.question_layout,parent,false);
        }
        Question current=getItem(position);
        TextView q=(TextView)resultView.findViewById(R.id.question);
        TextView u=(TextView) resultView.findViewById(R.id.user);
        TextView a=(TextView)resultView.findViewById(R.id.answer);

        q.setText("Question:"+current.getQuestion());
        u.setText("User:"+current.getUser());
        a.setText("Answer:"+current.getAnswer());
        return resultView;
    }
}
