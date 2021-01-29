package com.example.apptruyen1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptruyen1.Model.Theloaitoday;
import com.example.apptruyen1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TheloaiTodayAdapter extends RecyclerView.Adapter<TheloaiTodayAdapter.ViewHolder> {
    Context context;
    ArrayList<Theloaitoday> mangtheloaitoday;
    public TheloaiTodayAdapter(Context context, ArrayList<Theloaitoday> mangtheloaitoday) {
        this.context = context;
        this.mangtheloaitoday = mangtheloaitoday;
    }
    @NonNull
    @Override
    public TheloaiTodayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        view = inflater.inflate(R.layout.dong_the_loai_today,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheloaiTodayAdapter.ViewHolder holder, int position) {
        Theloaitoday theLoaiToday = mangtheloaitoday.get(position);
        holder.txttentheloai.setText(theLoaiToday.getTentheloai());
        Picasso.with(context).load(theLoaiToday.getHinhtheloai()).into(holder.imgtheloaitoday);
    }

    @Override
    public int getItemCount() {
        return mangtheloaitoday.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgtheloaitoday;
        TextView txttentheloai;

        public ViewHolder( View itemView){
            super(itemView);
            imgtheloaitoday = itemView.findViewById(R.id.imgtheloaitoday);
            txttentheloai = itemView.findViewById(R.id.txttentheloaitoday);
        }
    }
}
