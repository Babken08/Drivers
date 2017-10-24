package com.example.android.driversapplication.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.driversapplication.Activitys.MapsActivity;
import com.example.android.driversapplication.R;
import com.example.android.driversapplication.Utils.NetworkUtil;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private DatabaseReference myRef;
    private View rootView;
    private FirebaseUser user;
    private String mParam1;
    private TextView tv;
    private ImageView img;

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
        FirebaseDatabase  database = FirebaseDatabase.getInstance();

        myRef = database.getReference().child("drivers");

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        user = mAuth.getCurrentUser();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        tv = (TextView) rootView.findViewById(R.id.tv_balance);
        img = (ImageView) rootView.findViewById(R.id.image_welcome);

        initFABMenu();
        return rootView;
    }

    private void initFABMenu() {
        img.setOnClickListener(this);
        FloatingActionMenu fam = (FloatingActionMenu) rootView.findViewById(R.id.fab_menu);
        FloatingActionButton fab1 = (FloatingActionButton) rootView.findViewById(R.id.fab1);
        FloatingActionButton fab2 = (FloatingActionButton) rootView.findViewById(R.id.fab2);
        FloatingActionButton  fab3 = (FloatingActionButton) rootView.findViewById(R.id.fab3);
        FloatingActionButton fab4 = (FloatingActionButton) rootView.findViewById(R.id.fab4);
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
                    return;
                }
                String statusInternet = NetworkUtil.getConnectivityStatusString(getContext());
                if(statusInternet.equals("Not connected to Internet")){
                    Toast.makeText(getContext(), "plase enabled your Internet", Toast.LENGTH_SHORT).show();
                }else {
                    addValue("OnLine");
                }

                break;
            }
            case R.id.fab4: {
                addValue("OFFline");
                break;
            }
            case R.id.image_welcome: {


                Intent i = new Intent(getActivity(), MapsActivity.class);
                startActivity(i);
                break;
            }
        }

    }

    private void addValue(String value) {
//
//        if(mParam1.equals("Taxi4")){
////            myRef.child("Taxi").child("seats4").child(user.getUid()).child("status").setValue(value);
////            myRef.child("Shipping").child(user.getUid()).child("status").setValue(value);
//            myRef.child("Taxi4").child(user.getUid()).child("status").setValue(value);
////        }else if(mParam1.equals("xxxxx7")){
////            myRef.child("Taxi").child("seats7").child(user.getUid()).child("status").setValue(value);
//////            myRef.child("Shipping").child(user.getUid()).child("status").setValue(value);
//        }else if(mParam1.equals("ShippingTruck")){
//            myRef.child("ShippingTruck").child(user.getUid()).child("status").setValue(value);
////        }else if(mParam1.equals("ShippingTruck6")) {
////            myRef.child("ShippingTruck").child("truck6").child(user.getUid()).child("status").setValue(value);
////        }else if(mParam1.equals("ShippingTruck9")) {
////            myRef.child("ShippingTruck").child("truck9").child(user.getUid()).child("status").setValue(value);
////        }else if(mParam1.equals("Taxi4")) {
////            myRef.child("Taxi").child("seats4").child(user.getUid()).child("status").setValue(value);
//        }else if(mParam1.equals("Taxi7")) {
//            myRef.child("Taxi7").child(user.getUid()).child("status").setValue(value);
//        }else {
//            myRef.child(mParam1).child(user.getUid()).child("status").setValue(value);
//
//        }

        myRef.child(mParam1).child(user.getUid()).child("status").setValue(value);

    }
}
