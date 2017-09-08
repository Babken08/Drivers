package com.example.android.driversapplication.Models;

import java.util.Date;

/**
 * Created by Android on 07.09.2017.
 */

public class History {

    private double distance;
    private int summary;
    private Date date;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getSummary() {
        return summary;
    }

    public void setSummary(int summary) {
        this.summary = summary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
