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
import com.example.apptruyen1.Model.Truyenganday;
import com.example.apptruyen1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachtruyendangganAdapter extends RecyclerView.Adapter<DanhsachtruyendangganAdapter.ViewHolder>{
    Context context;

    public DanhsachtruyendangganAdapter(Context context, ArrayList<Truyenganday> truyengandayArrayList) {
        this.context = context;
        this.truyengandayArrayList = truyengandayArrayList;
    }

    ArrayList<Truyenganday> truyengandayArrayList;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_allganday,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Truyenganday truyenganday = truyengandayArrayList.get(position);
        Picasso.with(context).load(truyenganday.getHinhanhtruyen()).into(holder.imageViewtruyendangganday);
        holder.txtalltruyenganday.setText(truyenganday.getTentruyen());
        holder.txttacgia.setText(truyenganday.getTacgia());
    }

    @Override
    public int getItemCount() {
        return truyengandayArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageViewtruyendangganday;
        TextView txtalltruyenganday,txttacgia;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewtruyendangganday = itemView.findViewById(R.id.imageviewdanhsachtruyendangganday);
            txtalltruyenganday = itemView.findViewById(R.id.textviewdanhsachtruyendangganday);
            txttacgia = itemView.findViewById(R.id.textviewtacgiatruyenganday);
        }
    }
}
