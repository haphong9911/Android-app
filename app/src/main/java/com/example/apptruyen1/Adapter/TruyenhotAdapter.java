package com.example.apptruyen1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptruyen1.Model.Truyenyeuthich;
import com.example.apptruyen1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TruyenhotAdapter extends RecyclerView.Adapter<TruyenhotAdapter.ViewHolder> {
    Context context;
    ArrayList<Truyenyeuthich> truyenyeuthichArrayList;

    public TruyenhotAdapter(Context context, ArrayList<Truyenyeuthich> truyenyeuthichArrayList) {
        this.context = context;
        this.truyenyeuthichArrayList = truyenyeuthichArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_truyen_hot,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Truyenyeuthich truyenyeuthich = truyenyeuthichArrayList.get(position);
        holder.txtten.setText(truyenyeuthich.getTentruyen());
        holder.txttacgia.setText(truyenyeuthich.getTacgia());
        Picasso.with(context).load(truyenyeuthich.getHinhanhtruyen()).into(holder.imghinh);

    }

    @Override
    public int getItemCount() {
        return truyenyeuthichArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtten,txttacgia;
        ImageView imghinh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtten = itemView.findViewById(R.id.textviewtentruyenhot);
            txttacgia = itemView.findViewById(R.id.textviewtentacgiahot);
            imghinh = itemView.findViewById(R.id.imageviewtruyenhot);
        }
    }
}
