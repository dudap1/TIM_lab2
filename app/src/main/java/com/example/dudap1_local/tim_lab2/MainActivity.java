package com.example.dudap1_local.tim_lab2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        final Button button2 = findViewById(R.id.button2);
        final TextView textView = findViewById(R.id.textView);
        final EditText editText = findViewById(R.id.editText);
        final ListView listView = findViewById(R.id.listView);
        final ArrayList<Integer> listItem = new ArrayList();
        final Context context = this;


        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.38:8080/").addConverterFactory(GsonConverterFactory.create()).build();
        final RandomServiceInterface randomServiceInterface = retrofit.create(RandomServiceInterface.class);
        final AvgServiceInterface avgServiceInterface = retrofit.create(AvgServiceInterface.class);
        final String[] uriString = {null};

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AsyncListGenerate asyncListGenerate = new AsyncListGenerate(editText, listView, listItem, randomServiceInterface, context);
                asyncListGenerate.execute();

            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uriString[0] = Arrays.toString(new ArrayList[]{listItem});

                AsyncAvg asyncAvg = new AsyncAvg(textView, listItem, listView, avgServiceInterface, context, uriString);
                asyncAvg.execute();

            }
        });


    }
}
