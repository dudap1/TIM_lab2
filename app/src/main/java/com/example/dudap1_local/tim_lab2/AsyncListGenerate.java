package com.example.dudap1_local.tim_lab2;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class AsyncListGenerate extends AsyncTask<Void, Void, List> {
    EditText editText;
    private ListView listView;
    RandomServiceInterface randomServiceInterface;
    ArrayList<Integer> listItem;
    ArrayAdapter<String> adapter;
    Context context;

    public AsyncListGenerate(EditText editText, ListView listView, ArrayList<Integer> listItem, RandomServiceInterface randomServiceInterface, Context context) {
        this.editText = editText;
        this.listView = listView;
        this.listItem = listItem;
        this.randomServiceInterface = randomServiceInterface;
        this.context = context;
    }

    @Override
    protected ArrayList doInBackground(Void... voids) {

        Call<listObj> ResultArrayList = randomServiceInterface.ListGenerate(editText.getText().toString());
        ArrayList<Integer> arrayList = null;


        try {
            Response<listObj> ResultBody = ResultArrayList.execute();
            arrayList = ResultBody.body().getArrayList();
            listItem.clear();
            listItem.addAll(arrayList);
            return listItem;

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void onPostExecute(List list) {

        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        super.onPostExecute(list);
    }
}
