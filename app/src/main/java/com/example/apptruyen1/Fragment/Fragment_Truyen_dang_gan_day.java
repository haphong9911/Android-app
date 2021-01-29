package com.example.apptruyen1.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptruyen.Service.APIService;
import com.example.apptruyen.Service.Dataservice;
import com.example.apptruyen1.Activity.TruyenganActivity;
import com.example.apptruyen1.Adapter.TruyendanggandayAdapter;
import com.example.apptruyen1.Model.Truyendangganday;
import com.example.apptruyen1.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Truyen_dang_gan_day extends Fragment {
    View view;
    RecyclerView recyclerViewtruyendangganday;
    TextView txtxemthemtruyendangganday;
    TruyendanggandayAdapter truyendanggandayAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_truyendangganday,container,false);
        recyclerViewtruyendangganday = view.findViewById(R.id.recycleviewtruyendangganday);
        txtxemthemtruyendangganday = view.findViewById(R.id.textviewxemthemtruyendangganday);
        txtxemthemtruyendangganday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TruyenganActivity.class);
                startActivity(intent);
            }
        });
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Truyendangganday>> callback = dataservice.GetTruyendangganday();
        callback.enqueue(new Callback<List<Truyendangganday>>() {
            @Override
            public void onResponse(Call<List<Truyendangganday>> call, Response<List<Truyendangganday>> response) {
                ArrayList<Truyendangganday> truyendanggandayArrayList = (ArrayList<Truyendangganday>) response.body();
                truyendanggandayAdapter = new TruyendanggandayAdapter(getActivity(),truyendanggandayArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                recyclerViewtruyendangganday.setLayoutManager(linearLayoutManager);
                recyclerViewtruyendangganday.setAdapter(truyendanggandayAdapter);
            }

            @Override
            public void onFailure(Call<List<Truyendangganday>> call, Throwable t) {

            }
        });
    }
}
