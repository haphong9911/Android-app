package com.example.apptruyen1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.apptruyen.Service.APIService;
import com.example.apptruyen.Service.Dataservice;
import com.example.apptruyen1.Adapter.DanhsachtruyenAdapter;
import com.example.apptruyen1.Adapter.DanhsachtruyendangganAdapter;
import com.example.apptruyen1.Model.Truyendangganday;
import com.example.apptruyen1.Model.Truyenganday;
import com.example.apptruyen1.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TruyenganActivity extends AppCompatActivity {
    RecyclerView recyclerViewalltruyen;
    Toolbar toolbartruyen;
    DanhsachtruyendangganAdapter danhsachtruyendangganAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyengan);
        init();
        GetData();
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Truyenganday>> callback = dataservice.GetTruyenganday();
        callback.enqueue(new Callback<List<Truyenganday>>() {
            @Override
            public void onResponse(Call<List<Truyenganday>> call, Response<List<Truyenganday>> response) {
                ArrayList<Truyenganday> mangtruyengan = (ArrayList<Truyenganday>) response.body();
                danhsachtruyendangganAdapter = new DanhsachtruyendangganAdapter(TruyenganActivity.this,mangtruyengan);
                recyclerViewalltruyen.setLayoutManager(new GridLayoutManager(TruyenganActivity.this,2));
                recyclerViewalltruyen.setAdapter(danhsachtruyendangganAdapter);
            }

            @Override
            public void onFailure(Call<List<Truyenganday>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerViewalltruyen = findViewById(R.id.recyclerviewalltruyen);
        toolbartruyen = findViewById(R.id.toolbaralltruyen);
        setSupportActionBar(toolbartruyen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Truyện Đăng Gần Đây");
        toolbartruyen.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}