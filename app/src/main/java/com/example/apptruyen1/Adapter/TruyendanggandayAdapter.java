package com.example.apptruyen1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptruyen1.Model.Truyendangganday;
import com.example.apptruyen1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TruyendanggandayAdapter extends RecyclerView.Adapter<TruyendanggandayAdapter.ViewHolder> {
    Context context;

    public TruyendanggandayAdapter(Context context, ArrayList<Truyendangganday> mangtruyendangganday) {
        this.context = context;
        this.mangtruyendangganday = mangtruyendangganday;
    }

    ArrayList<Truyendangganday> mangtruyendangganday;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_truyendangganday,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Truyendangganday truyendangganday = mangtruyendangganday.get(position);
        holder.txttentruyen.setText(truyendangganday.getTentruyen());
        holder.txttacgia.setText(truyendangganday.getTacgia());
        Picasso.with(context).load(truyendangganday.getHinhanhtruyen()).into(holder.imghinhtruyen);

    }

    @Override
    public int getItemCount() {
        return mangtruyendangganday.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imghinhtruyen;
        TextView txttentruyen,txttacgia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imghinhtruyen = itemView.findViewById(R.id.imageviewtruyendangganday);
            txttentruyen = itemView.findViewById(R.id.textviewtentruyendangganday);
            txttacgia = itemView.findViewById(R.id.textviewtentacgiatruyendangganday);
        }
    }
}
