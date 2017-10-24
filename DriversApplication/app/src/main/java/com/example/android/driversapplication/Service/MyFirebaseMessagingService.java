package com.example.android.driversapplication.Service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.example.android.driversapplication.Activitys.MapsActivity;
import com.example.android.driversapplication.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d("VTC!!!", "Message data payload: " + remoteMessage.getData());
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d("VTC!!", "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        sendNotification(remoteMessage.getData().get("token"), (remoteMessage.getData().get("title")));

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    private void sendNotification(String token, String title) {
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        android.support.v4.app.NotificationCompat.Builder mBuilder =
                 new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Notification")
                        .setContentText("This is a test notification");
//
//        Intent notifyIntentAccept =
//                new Intent(this, HomeActivity.class);
////        notifyIntentAccept.putExtra("Token", token);
////        notifyIntentAccept.setAction(Constants.ACTION_ACCEPT);
//        PendingIntent accept = PendingIntent.getService(getApplicationContext(), 0, notifyIntentAccept, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent notifyIntentReject =
                new Intent(this, MapsActivity.class);
//        notifyIntentReject.putExtra("Token", token);
//        notifyIntentReject.putExtra("Title", title);
//        notifyIntentReject.setAction(Constants.ACTION_REJECT);
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 0, notifyIntentReject, PendingIntent.FLAG_UPDATE_CURRENT);

//        mBuilder.addAction(R.drawable.ic_close, "Accept", accept);
//        mBuilder.addAction(R.drawable.ic_phone, "Reject", pendingIntent);

        mBuilder.setContentIntent(pendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());

//        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder)new NotificationCompat.Builder(this)
//                .setSmallIcon(R.drawable.ic_phone)
//                .setContentTitle("Event tracker")
//                .setContentText("Events received");
//
//        NotificationCompat.InboxStyle inboxStyle =
//                new NotificationCompat.InboxStyle();
//        String[] events = new String[6];
//// Sets a title for the Inbox in expanded layout
//        inboxStyle.setBigContentTitle("Event tracker details:");
//
//// Moves events into the expanded layout
//        for (int i=0; i < events.length; i++) {
//
//            inboxStyle.addLine(events[i]);
//        }
//// Moves the expanded layout object into the notification object.
//        mBuilder.setStyle(inboxStyle);
//
//// Issue the notification here.

    }

}
