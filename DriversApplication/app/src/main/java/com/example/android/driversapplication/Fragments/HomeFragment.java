package com.example.android.driversapplication.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.driversapplication.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private FloatingActionMenu fam;
    private FloatingActionButton fab1, fab2, fab3;
    private View rootView;

    public HomeFragment() {}


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                break;
            }
            case R.id.fab3:{
                break;
            }
        }

    }
}
