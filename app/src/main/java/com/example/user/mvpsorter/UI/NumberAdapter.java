package com.example.user.mvpsorter.UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.mvpsorter.R;

import java.util.ArrayList;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.ViewHolder>{

    private ArrayList<Integer> integerArrayList;

    public NumberAdapter(ArrayList<Integer> integerArrayList){
        this.integerArrayList = integerArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.number_single, viewGroup, false);
        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.numberView.setText(String.valueOf(integerArrayList.get(i)));
    }


    @Override
    public int getItemCount() {
        return integerArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView numberView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            numberView = itemView.findViewById(R.id.number_view);
        }
    }
}
