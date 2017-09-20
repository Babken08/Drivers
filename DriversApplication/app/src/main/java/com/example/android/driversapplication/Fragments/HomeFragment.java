package com.example.android.driversapplication.Fragments;



import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.driversapplication.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private FirebaseAuth mAuth;
    private DatabaseReference myRef;

    private FloatingActionMenu fam;
    private FloatingActionButton fab1, fab2, fab3;
    private View rootView;
    private FirebaseUser user;
    private FirebaseDatabase database;
    private String mParam1;
    private FloatingActionButton fab4;
    private TextView tv;

    public HomeFragment() {}


    public static HomeFragment newInstance(String param1) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
        database = FirebaseDatabase.getInstance();

        myRef = database.getReference().child("drivers");

        mAuth = FirebaseAuth.getInstance();

        user = mAuth.getCurrentUser();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        tv = (TextView) rootView.findViewById(R.id.tv_balance);
        initFABMenu();
        return rootView;
    }

    private void initFABMenu() {
        fam = (FloatingActionMenu) rootView.findViewById(R.id.fab_menu);
        fab1 = (FloatingActionButton) rootView.findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) rootView.findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) rootView.findViewById(R.id.fab3);
        fab4 = (FloatingActionButton) rootView.findViewById(R.id.fab4);
        fam.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
        fab4.setOnClickListener(this);
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

                int balanse = Integer.parseInt(tv.getText().toString());
                if(balanse < 100) {
                    Toast.makeText(getContext(), "licqavoreq dzer hashiv@", Toast.LENGTH_SHORT).show();
                }else {
                    addValue("OnLine");
                }
                break;
            }
            case R.id.fab4: {
                addValue("OFFline");
                break;
            }
        }

    }

    private void addValue(String value) {
        if(!mParam1.equals("xxxxx")){
            myRef.child(mParam1).child("users").child(user.getUid()).child("status").setValue(value);
        } else {
            myRef.child("Taxi").child("users").child(user.getUid()).child("status").setValue(value);
            myRef.child("Shipping").child("users").child(user.getUid()).child("status").setValue(value);
        }
    }
}
