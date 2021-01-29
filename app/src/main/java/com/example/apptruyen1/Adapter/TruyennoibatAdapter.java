package com.example.apptruyen1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptruyen1.Model.Truyennoibat;
import com.example.apptruyen1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TruyennoibatAdapter extends RecyclerView.Adapter<TruyennoibatAdapter.ViewHolder>{

    Context context;
    ArrayList<Truyennoibat> mangtruyennoibat;

    public TruyennoibatAdapter(Context context, ArrayList<Truyennoibat> mangtruyennoibat) {
        this.context = context;
        this.mangtruyennoibat = mangtruyennoibat;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        view = inflater.inflate(R.layout.dong_truyennoibat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Truyennoibat truyenNoiBat = mangtruyennoibat.get(position);
        holder.txttruyennoibat.setText(truyenNoiBat.getTentruyen());
        holder.txttacgia.setText(truyenNoiBat.getTacgia());
        Picasso.with(context).load(truyenNoiBat.getHinhanhtruyen()).into(holder.imgtruyennoibat);
    }

    @Override
    public int getItemCount() {
        if (mangtruyennoibat!=null){
            return mangtruyennoibat.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgtruyennoibat;
        TextView txttruyennoibat , txttacgia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgtruyennoibat = itemView.findViewById(R.id.imageviewtruyennoibat);
            txttruyennoibat =  itemView.findViewById(R.id.textviewtruyennoibat);
            txttacgia = itemView.findViewById(R.id.textviewtentacgia);
        }
    }
}
