package com.example.dudap1_local.tim_lab2;

public class AvgObj {


    private Double avg;

    public String getAvg() {
        return String.valueOf(avg);
    }

    public AvgObj(Double avg) {
        this.avg = avg;
    }


    @Override
    public String toString() {
        return "AvgObj{" +
                "Avg=" + avg +
                '}';
    }

}
