package com.example.android.driversapplication.Activitys;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.android.driversapplication.Fragments.HomeFragment;
//import com.example.android.driversapplication.Fragments.RegisterFragment;
import com.example.android.driversapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        String a = getIntent().getStringExtra("esim");
        SharedPreferences sharedPref = getSharedPreferences("babkenjan", Context.MODE_PRIVATE);
        String a = sharedPref.getString("babken", "ppp");

        Log.i("sssssssssssss", "wwwwwwwwwwwwwwwwwwwwww" + a);
        getSupportFragmentManager().beginTransaction().replace(R.id.hom_conteiner, HomeFragment.newInstance(a)).commit();
    }
}
