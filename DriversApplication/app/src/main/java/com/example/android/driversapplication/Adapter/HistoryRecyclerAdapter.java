package com.example.android.driversapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.driversapplication.Models.History;
import com.example.android.driversapplication.R;

import java.util.List;

public class HistoryRecyclerAdapter extends RecyclerView.Adapter<HistoryRecyclerAdapter.MyViewHolder> {

    private List<History> list;
    private Context context;

    public HistoryRecyclerAdapter(List<History> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public HistoryRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_row_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//ssssssss

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDistance;
        private TextView tvSummary;
        private TextView tvDate;

        MyViewHolder(View view) {
            super(view);
            tvDistance = (TextView) itemView.findViewById(R.id.tv_distance);
            tvSummary = (TextView) itemView.findViewById(R.id.tv_summary);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);

        }
    }


}
