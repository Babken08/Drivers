package com.example.android.driversapplication.Fragments;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.android.driversapplication.Models.TaxiDriver;
import com.example.android.driversapplication.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private DatabaseReference myRef;

    private FloatingActionMenu fam;
    private FloatingActionButton fab1, fab2, fab3;
    private View rootView;
    private FirebaseUser user;
    private FirebaseDatabase database;

    public HomeFragment() {}


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        mAuth = FirebaseAuth.getInstance();

        user = mAuth.getCurrentUser();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        initFABMenu();
        return rootView;
    }

    private void initFABMenu() {
        fam = (FloatingActionMenu) rootView.findViewById(R.id.fab_menu);
        fab1 = (FloatingActionButton) rootView.findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) rootView.findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) rootView.findViewById(R.id.fab3);
        fam.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab1:{
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.hom_conteiner,new HistoryFragment()).commit();
                break;
            }
            case R.id.fab2:{

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:37477070708"));
                startActivity(intent);

                break;
            }
            case R.id.fab3:{
                DatabaseReference r1 = myRef.child("Taxi").child("users");

                user =  mAuth.getCurrentUser();
                TaxiDriver d = new TaxiDriver();
                d.setStatus("online");
                DatabaseReference r = r1.child(user.getUid());
                r.setValue(d);
                break;
            }
        }

    }
}
