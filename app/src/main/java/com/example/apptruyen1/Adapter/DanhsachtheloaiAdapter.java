package com.example.apptruyen1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptruyen1.Activity.DanhsachcactheloaiActivity;
import com.example.apptruyen1.Activity.DanhsachtruyenActivity;
import com.example.apptruyen1.Model.Danhsachtheloai;
import com.example.apptruyen1.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhsachtheloaiAdapter extends RecyclerView.Adapter<DanhsachtheloaiAdapter.ViewHolder> {

    Context context;
    ArrayList<Danhsachtheloai> mangtheloail;
    Danhsachtheloai danhsachtheloai = new Danhsachtheloai();

    public DanhsachtheloaiAdapter(Context context, ArrayList<Danhsachtheloai> mangtheloail) {
        this.context = context;
        this.mangtheloail = mangtheloail;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_cac_the_loai,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        danhsachtheloai = mangtheloail.get(position);
        Picasso.with(context).load(danhsachtheloai.getHinhtheloai()).into(holder.imghinhnen);
        holder.txttentheloai.setText(danhsachtheloai.getTentheloai());

    }

    @Override
    public int getItemCount() {
        return mangtheloail.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imghinhnen;
        TextView txttentheloai;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imghinhnen = itemView.findViewById(R.id.imageviewdanhsachtheloai);
            txttentheloai = itemView.findViewById(R.id.textviewdanhsachcactheloai);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(context,DanhsachtruyenActivity.class);
//                    intent.putExtra("itemtheloai", mangtheloail.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
