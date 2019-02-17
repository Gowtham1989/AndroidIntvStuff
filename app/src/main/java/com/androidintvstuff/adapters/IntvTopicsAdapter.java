package com.androidintvstuff.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidintvstuff.R;
import com.androidintvstuff.model.IntvTopics;

import java.util.List;

public class IntvTopicsAdapter extends RecyclerView.Adapter<IntvTopicsAdapter.MyIntvTopicsHolder> {

    private List<IntvTopics> mIntvTopics;

    public IntvTopicsAdapter(List<IntvTopics> mIntvTopics){
        this.mIntvTopics = mIntvTopics;
    }

    @Override
    public MyIntvTopicsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.intvtopicsadapter,parent,false);
        return new MyIntvTopicsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyIntvTopicsHolder holder, int position) {
        IntvTopics intvTopics = mIntvTopics.get(position);
        holder.mTitle.setText(intvTopics.getIntvTopic());
        holder.mListItems.setBackgroundColor(Color.parseColor(intvTopics.getIntvColor()));
    }

    @Override
    public int getItemCount() {
        return mIntvTopics.size();
    }

    public class MyIntvTopicsHolder extends RecyclerView.ViewHolder{

        public TextView mTitle;
        public LinearLayout mListItems;

        public MyIntvTopicsHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.mTitle);
            mListItems = itemView.findViewById(R.id.mListItems);
        }
    }


}
