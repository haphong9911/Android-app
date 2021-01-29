package com.example.apptruyen1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.apptruyen.Service.APIService;
import com.example.apptruyen.Service.Dataservice;
import com.example.apptruyen1.Adapter.DanhsachtruyenAdapter;
import com.example.apptruyen1.Model.Quangcao;
import com.example.apptruyen1.Model.Theloaitoday;
import com.example.apptruyen1.Model.Truyendetail;
import com.example.apptruyen1.Model.Truyenyeuthich;
import com.example.apptruyen1.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtruyenActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewdanhsachtruyen;
    FloatingActionButton floatingActionButton;
    Quangcao quangcao;
    ImageView imgdanhsachtruyen;
    ArrayList<Truyenyeuthich> mangtruyen;
    DanhsachtruyenAdapter danhsachtruyenAdapter;
    Theloaitoday theloaitoday;
    Truyendetail truyendetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtruyen);
        DataIntent();
        anhxa();
        init();
        if(quangcao != null && !quangcao.getTentruyen().equals("")) {
            setValueInView(quangcao.getTentruyen(),quangcao.getHinhanhtruyen());
            getDataQuangCao(quangcao.getIDquangcao());
        }
        if(theloaitoday != null && !theloaitoday.getTentheloai().equals("") ){
            setValueInView(theloaitoday.getTentheloai(),theloaitoday.getHinhtheloai());
            GetDatatheloai(theloaitoday.getIDtheloai());
            
        }
    }

    private void GetDatatheloai(String idtheloai) {
        Dataservice dataservice = APIService.getService();
        Call<List<Truyenyeuthich>> callback = dataservice.GetDanhsachtruyentheoquangcao(idtheloai);
        callback.enqueue(new Callback<List<Truyenyeuthich>>() {
            @Override
            public void onResponse(Call<List<Truyenyeuthich>> call, Response<List<Truyenyeuthich>> response) {
                mangtruyen = (ArrayList<Truyenyeuthich>) response.body();
                danhsachtruyenAdapter = new DanhsachtruyenAdapter(DanhsachtruyenActivity.this,mangtruyen);
                recyclerViewdanhsachtruyen.setLayoutManager(new LinearLayoutManager(DanhsachtruyenActivity.this));
                recyclerViewdanhsachtruyen.setAdapter(danhsachtruyenAdapter);
            }

            @Override
            public void onFailure(Call<List<Truyenyeuthich>> call, Throwable t) {

            }
        });
    }

    private void getDataQuangCao(String idquangcao) {
        Dataservice dataservice = APIService.getService();
        Call<List<Truyenyeuthich>> callback = dataservice.GetDanhsachtruyentheoquangcao(idquangcao);
        callback.enqueue(new Callback<List<Truyenyeuthich>>() {
            @Override
            public void onResponse(Call<List<Truyenyeuthich>> call, Response<List<Truyenyeuthich>> response) {
                mangtruyen = (ArrayList<Truyenyeuthich>) response.body();
                danhsachtruyenAdapter = new DanhsachtruyenAdapter(DanhsachtruyenActivity.this,mangtruyen);
                recyclerViewdanhsachtruyen.setLayoutManager(new LinearLayoutManager(DanhsachtruyenActivity.this));
                recyclerViewdanhsachtruyen.setAdapter(danhsachtruyenAdapter);
            }

            @Override
            public void onFailure(Call<List<Truyenyeuthich>> call, Throwable t) {

            }
        });
    }

    private void setValueInView(String ten, String hinh) {
        collapsingToolbarLayout.setTitle(ten);
        try {
            URL url = new URL(hinh);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),bitmap);
            collapsingToolbarLayout.setBackground(bitmapDrawable);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load(hinh).into(imgdanhsachtruyen);
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
    }

    private void anhxa() {
        coordinatorLayout = findViewById(R.id.coordinatordstruyen);
        collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);
        toolbar = findViewById(R.id.toolbardanhsach);
        recyclerViewdanhsachtruyen = findViewById(R.id.recycleviewdanhsachtruyen);
        floatingActionButton = findViewById(R.id.floatingtruyen);
        imgdanhsachtruyen = findViewById(R.id.imageviewdanhsachtruyen);

    }

    private void DataIntent() {
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("banner")){
                quangcao = (Quangcao) intent.getSerializableExtra("banner");
            }
            if(intent.hasExtra("itemtheloai")){
                theloaitoday = (Theloaitoday) intent.getSerializableExtra("itemtheloai");
            }
            if (intent.hasExtra("truyendetail")){
                truyendetail = (Truyendetail) intent.getSerializableExtra("truyendetail");

            }
        }
    }
}