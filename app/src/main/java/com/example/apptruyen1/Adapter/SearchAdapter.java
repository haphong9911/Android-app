package com.example.apptruyen1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptruyen1.Activity.DoctruyenActivity;
import com.example.apptruyen1.Model.Truyendetail;
import com.example.apptruyen1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    Context context;
    ArrayList<Truyendetail> mangtruyen;

    public SearchAdapter(Context context, ArrayList<Truyendetail> mangtruyen) {
        this.context = context;
        this.mangtruyen = mangtruyen;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater inflater = LayoutInflater.from(parent.getContext());
       View view = inflater.inflate(R.layout.dong_searchtruyen,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Truyendetail truyendetail = mangtruyen.get(position);
        holder.txttentruyen.setText(truyendetail.getTentruyen());
        holder.txttacgia.setText(truyendetail.getTacgia());
        Picasso.with(context).load(truyendetail.getHinhanhtruyen()).into(holder.imgtruyen);


    }

    @Override
    public int getItemCount() {
        return mangtruyen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttentruyen,txttacgia;
        ImageView imgtruyen,imgluotthich;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttentruyen = itemView.findViewById(R.id.textviewsearchtruyen);
            txttacgia = itemView.findViewById(R.id.textviewsearchtacgia);
            imgtruyen = itemView.findViewById(R.id.imagesearchtruyen);
            imgluotthich = itemView.findViewById(R.id.imageviewsearchluotthich);
        }
    }
}
