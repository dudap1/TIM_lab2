package com.example.dudap1_local.tim_lab2;

import java.util.ArrayList;

public class listObj {
    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

    public listObj(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    private ArrayList<Integer> arrayList;

    @Override
    public String toString() {
        return "listObj{" +
                "arrayList=" + arrayList +
                '}';
    }
}
