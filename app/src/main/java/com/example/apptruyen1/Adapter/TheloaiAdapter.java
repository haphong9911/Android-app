package com.example.apptruyen1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.apptruyen1.Activity.TruyenDetailActivity;
import com.example.apptruyen1.Model.Theloaitoday;
import com.example.apptruyen1.Model.Truyendetail;
import com.example.apptruyen1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class TheloaiAdapter extends BaseAdapter {
    Context context;
    ArrayList<Truyendetail> truyendetailArrayList;

    public TheloaiAdapter(Context context, ArrayList<Truyendetail> truyendetails) {
        this.context = context;
        this.truyendetailArrayList = truyendetails;
    }

    @Override
    public int getCount() {

        return truyendetailArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.single_listtruyen,null);
        TextView txtTentruyen = (TextView) convertView.findViewById(R.id.txttentruyen);
        TextView txttacgia = (TextView) convertView.findViewById(R.id.txttacgia);
        TextView txttheloai = (TextView) convertView.findViewById(R.id.txttheloai);
        ImageView imgtruyen =(ImageView) convertView.findViewById(R.id.imgtruyen);
        
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,TruyenDetailActivity.class);
                startActivity(intent);
            }

            private void startActivity(Intent intent) {
                Intent intent1 = new Intent(context, TruyenDetailActivity.class);
                startActivity(intent1);
            }
        });

txtTentruyen.setText(truyendetailArrayList.get(position).getTentruyen());
txttacgia.setText(truyendetailArrayList.get(position).getTacgia());
txttheloai.setText(truyendetailArrayList.get(position).getTentheloai());
Picasso.with(convertView.getContext()).load(truyendetailArrayList.get(position).getHinhanhtruyen()).into(imgtruyen);
        return convertView;

    }
}
