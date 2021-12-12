package com.course.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements OnProductItemClickListener{
    ArrayList<Products> items = new ArrayList<Products>();
    OnProductItemClickListener listener;

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Products item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void addItem(Products item){
        items.add(item);
    }
    public void setItems(ArrayList<Products> items){
        this.items = items;
    }
    public Products getItem(int position){
        return items.get(position);
    }
    public void setItem(int position,Products item){
        items.set(position,item);
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder, view, position);
        }
    }
    public void setOnItemClickListener(OnProductItemClickListener listener){
        this.listener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textName;
        TextView textCost;
        TextView textNote;



        public ViewHolder(View itemView, final OnProductItemClickListener listener){
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textName = itemView.findViewById(R.id.textView);
            textCost = itemView.findViewById(R.id.textView2);
            textNote = itemView.findViewById(R.id.textView3);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, view,position);
                    }
                }
            });
        }

        public void setItem(Products item){
            textNote.setText(item.getNote());
            textName.setText(item.getName());
            textCost.setText(item.getCost());
            imageView.setImageResource(item.getID());
        }
    }
}