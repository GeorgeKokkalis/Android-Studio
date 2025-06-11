package com.example.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class onomaRVadapter extends RecyclerView.Adapter<onomaRVadapter.ViewHolder> {

    private ArrayList<onomaModal> onomaModalArrayList;
    private Context context;
     public onomaRVadapter(ArrayList <onomaModal> onomaModalArrayList , Context context ) {

         this.onomaModalArrayList = onomaModalArrayList;
         this.context = context;
     }

     @NonNull
     @Override
     public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_onomata, parent,false);
         return new ViewHolder(view);
     }

     @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        onomaModal modal = onomaModalArrayList.get(position);
        holder.viewID.setText(modal.getId());
        holder.viewOnoma.setText(modal.getOnona());
        holder.viewEponymo.setText(modal.getEponymo());
    }

    @Override
    public int getItemCount(){
         return onomaModalArrayList.size();
    }





    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView viewID;
        private TextView viewOnoma;
        private TextView viewEponymo;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            viewID= itemView.findViewById(R.id.viewID);
            viewOnoma = itemView.findViewById(R.id.viewOnoma);
            viewEponymo = itemView.findViewById(R.id.viewEponymo);

        }



    }








}
