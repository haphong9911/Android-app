package com.example.apptruyen1.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.apptruyen1.Activity.DanhsachtruyenActivity;
import com.example.apptruyen1.Model.Quangcao;
import com.example.apptruyen1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<Quangcao> arraylistbanner;

    public BannerAdapter(Context context, ArrayList<Quangcao> arraylistbanner) {
        this.context = context;
        this.arraylistbanner = arraylistbanner;
    }

    @Override
    public int getCount() {
        return arraylistbanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_banner,null);
        ImageView imagebackgroundbanner = view.findViewById(R.id.imageviewbackgroundbanner);
        ImageView imagetruyenbanner = view.findViewById(R.id.imageviewbanner);
        TextView txttitletruyenbanner = view.findViewById(R.id.textviewtitlebanner);
        TextView txtnoidung = view.findViewById(R.id.textviewnoidung);

        Picasso.with(context).load(arraylistbanner.get(position).getHinhanh()).into(imagebackgroundbanner);
        Picasso.with(context).load(arraylistbanner.get(position).getHinhanhtruyen()).into(imagetruyenbanner);
        txttitletruyenbanner.setText(arraylistbanner.get(position).getTentruyen());
        txtnoidung.setText(arraylistbanner.get(position).getNoidung());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DanhsachtruyenActivity.class);
                intent.putExtra("banner",arraylistbanner.get(position));
                context.startActivities(new Intent[]{intent});
            }
        });

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
