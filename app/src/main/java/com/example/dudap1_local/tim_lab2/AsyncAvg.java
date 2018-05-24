package com.example.dudap1_local.tim_lab2;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Response;


public class AsyncAvg  extends AsyncTask<Void,Void,String> {
    String [] uriString;
    TextView textView;
    ArrayList<Integer> arrayList;
    AvgServiceInterface avgServiceInterface;
    Context context;
    ListView listView;


    public AsyncAvg(TextView textView, ArrayList<Integer> arrayList, ListView listView, AvgServiceInterface avgServiceInterface, Context context, String[] uriString){
this.textView=textView;
this.arrayList=arrayList;
this.avgServiceInterface=avgServiceInterface;
this.context=context;
this.listView=listView;
this.uriString=uriString;
    }


    @Override
    protected String doInBackground(Void... voids) {


        Call<AvgObj> AvgResult = avgServiceInterface.AvgResult(arrayList);
        AvgObj avg=null;

        try {
            Response<AvgObj> BodyResult = AvgResult.execute();
             avg = BodyResult.body();
            return avg.getAvg();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;


    }

    @Override
    public void  onPostExecute(String avg) {
        textView.setText(avg);
        super.onPostExecute(avg);
    }
}
