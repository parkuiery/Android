package com.example.recyclerviewexample;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {


    private ArrayList<String> locallDataSet;

    //뷰 홀더 클래스
   public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
        public TextView getTextView(){
            return textView;
        }


    }

    //생성자
    public MainAdapter (ArrayList<String> dataSet) {
       locallDataSet = dataSet;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.recyclerview_item, parent, false);
        MainAdapter.ViewHolder viewHolder = new MainAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String text = locallDataSet.get(position);
        holder.textView.setText(text);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(holder.itemView.getContext(), SecoundActivity.class);
//                holder.itemView.getContext().startActivity(intent);
                Intent intent = new Intent(v.getContext(), SecoundActivity.class);
                intent.putExtra("item_number",position);
                v.getContext().startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return locallDataSet.size();
    }


}
