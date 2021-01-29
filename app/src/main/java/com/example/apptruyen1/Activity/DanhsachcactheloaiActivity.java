package com.example.apptruyen1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.apptruyen.Service.APIService;
import com.example.apptruyen.Service.Dataservice;
import com.example.apptruyen1.Adapter.DanhsachtheloaiAdapter;
import com.example.apptruyen1.Model.Danhsachtheloai;
import com.example.apptruyen1.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachcactheloaiActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerViewdanhsachtheloai;
    DanhsachtheloaiAdapter danhsachtheloaiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachcactheloai);
        anhxa();
        init();
        GetData();
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Danhsachtheloai>> callback = dataservice.Gettheloai();
        callback.enqueue(new Callback<List<Danhsachtheloai>>() {
            @Override
            public void onResponse(Call<List<Danhsachtheloai>> call, Response<List<Danhsachtheloai>> response) {
                ArrayList<Danhsachtheloai> mangcactheloai = (ArrayList<Danhsachtheloai>) response.body();
                danhsachtheloaiAdapter = new DanhsachtheloaiAdapter(DanhsachcactheloaiActivity.this,mangcactheloai);
                recyclerViewdanhsachtheloai.setLayoutManager(new GridLayoutManager(DanhsachcactheloaiActivity.this,2));
                recyclerViewdanhsachtheloai.setAdapter(danhsachtheloaiAdapter);
            }

            @Override
            public void onFailure(Call<List<Danhsachtheloai>> call, Throwable t) {

            }
        });
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Thể Loại");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorbutton));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void anhxa() {
        toolbar = findViewById(R.id.toolbardanhsachtheloai);
        recyclerViewdanhsachtheloai = findViewById(R.id.recyleviewtheloai);
    }
}