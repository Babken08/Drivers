package com.example.android.driversapplication.Activitys;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.driversapplication.Fragments.HomeFragment;
import com.example.android.driversapplication.R;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

//import com.example.android.driversapplication.Fragments.RegisterFragment;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FirebaseMessaging.getInstance().subscribeToTopic("vtc101");
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("VTC!!! ", "Refreshed token:sssssssssssssssssssssssssss" + "   " + refreshedToken);
//        FirebaseMessaging.getInstance().subscribeToTopic("vtc101");
//        String a = getIntent().getStringExtra("esim");
        SharedPreferences sharedPref = getSharedPreferences("babkenjan", Context.MODE_PRIVATE);
        String a = sharedPref.getString("babken", "ppp");

        Log.i("sssssssssssss", "wwwwwwwwwwwwwwwwwwwwww" + a);


       getSupportFragmentManager().beginTransaction().replace(R.id.hom_conteiner, HomeFragment.newInstance(a)).commit();
    }
}
