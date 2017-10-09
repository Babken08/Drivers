package com.example.android.driversapplication.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Android on 26.09.2017.
 */

public class NotificationData {
    @SerializedName("to")
    @Expose
    private String to;

    @SerializedName("data")
    @Expose
    private DataObject data;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public DataObject getData() {
        return data;
    }

    public void setData(DataObject data) {
        this.data = data;
    }
}
