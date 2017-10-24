package com.example.android.driversapplication.Service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.android.driversapplication.Utils.Constants;
import com.example.android.driversapplication.Utils.NetworkHelper;

/**
 * Created by Android on 26.09.2017.
 */

public class NotificationActionService extends IntentService {

    public NotificationActionService() {
        super("NotificationActionService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            final String clientToken = intent.getStringExtra("Token");
            if (Constants.ACTION_ACCEPT.equals(action)) {
                NetworkHelper.sendNotificationRequest(clientToken, "OK");
                Intent i = new Intent(NotificationActionService.this, LocationService.class);
                getApplicationContext().startService(i);
            } else if (Constants.ACTION_REJECT.equals(action)) {
                NetworkHelper.sendNotificationRequest(clientToken, "CANCEL");
            }
        }
    }
}
