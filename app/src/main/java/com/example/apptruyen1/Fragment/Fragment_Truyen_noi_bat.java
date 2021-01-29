package com.example.apptruyen1.Fragment;

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
import com.example.apptruyen1.Adapter.TruyennoibatAdapter;
import com.example.apptruyen1.Model.Truyennoibat;
import com.example.apptruyen1.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Truyen_noi_bat extends Fragment {
    View view;
    RecyclerView recyclerViewTruyennoibat;
    TextView txtxemthemtruyennoibat;
    TruyennoibatAdapter truyennoibatAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_truyen_noi_bat,container,false);
        recyclerViewTruyennoibat = view.findViewById(R.id.recycleviewTuyennoibat);
        txtxemthemtruyennoibat = view.findViewById(R.id.textviewxemthemtruyennoibat);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Truyennoibat>> callback = dataservice.GetTruyenNoiBat();
        callback.enqueue(new Callback<List<Truyennoibat>>() {
            @Override
            public void onResponse(Call<List<Truyennoibat>> call, Response<List<Truyennoibat>> response) {
                ArrayList<Truyennoibat> truyennoibatArrayList = (ArrayList<Truyennoibat>) response.body();
                truyennoibatAdapter = new TruyennoibatAdapter(getActivity(),truyennoibatArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                recyclerViewTruyennoibat.setLayoutManager(linearLayoutManager);
                recyclerViewTruyennoibat.setAdapter(truyennoibatAdapter);
            }

            @Override
            public void onFailure(Call<List<Truyennoibat>> call, Throwable t) {

            }
        });
    }
}
