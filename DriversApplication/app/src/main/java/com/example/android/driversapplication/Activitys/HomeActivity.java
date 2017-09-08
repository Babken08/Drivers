package com.example.android.driversapplication.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.driversapplication.Fragments.HomeFragment;
import com.example.android.driversapplication.Fragments.RegisterFragment;
import com.example.android.driversapplication.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportFragmentManager().beginTransaction().replace(R.id.hom_conteiner, HomeFragment.newInstance()).commit();
    }

    @Override
    public void onBackPressed() {
       super.onBackPressed();
        finish();
    }
}
