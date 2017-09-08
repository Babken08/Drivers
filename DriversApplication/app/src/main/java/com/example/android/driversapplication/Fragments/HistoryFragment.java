package com.example.android.driversapplication.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.driversapplication.Adapter.HistoryRecyclerAdapter;
import com.example.android.driversapplication.Models.History;
import com.example.android.driversapplication.R;

import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment {

    private List<History> historyList;
    private History history;


    public HistoryFragment(){}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance() {
        HistoryFragment fragment = new HistoryFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_history, container, false);
        imageList();
        RecyclerView historyRecycler = (RecyclerView)rootView.findViewById(R.id.history_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        historyRecycler.setLayoutManager(linearLayoutManager);
        historyRecycler.setAdapter(new HistoryRecyclerAdapter(historyList, getContext()));
        return rootView;
    }

    private void imageList() {
        historyList = new ArrayList<>();
        historyList.add(history);
        historyList.add(history);
        historyList.add(history);
        historyList.add(history);
        historyList.add(history);
        historyList.add(history);
        historyList.add(history);
        historyList.add(history);

    }

}
