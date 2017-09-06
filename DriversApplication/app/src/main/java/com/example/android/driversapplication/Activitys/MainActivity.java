package com.example.android.driversapplication.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.driversapplication.Fragments.RegisterFragment;
import com.example.android.driversapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.conto, RegisterFragment.newInstance()).commit();
    }
}
