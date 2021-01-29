package com.example.apptruyen1.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptruyen.Service.APIService;
import com.example.apptruyen.Service.Dataservice;
import com.example.apptruyen1.Adapter.TruyenhotAdapter;
import com.example.apptruyen1.Model.Truyenyeuthich;
import com.example.apptruyen1.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Truyenyeuthich extends Fragment {
    View view;
    RecyclerView recyclerViewTruyenhot;
    TruyenhotAdapter truyenhotAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_truyenyeuthich,container,false);
        recyclerViewTruyenhot = view.findViewById(R.id.recyleviewTruyenhot);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Truyenyeuthich>> callback = dataservice.GetTruyenyeuthich();
        callback.enqueue(new Callback<List<Truyenyeuthich>>() {
            @Override
            public void onResponse(Call<List<Truyenyeuthich>> call, Response<List<Truyenyeuthich>> response) {
                ArrayList<Truyenyeuthich> TruyenArrayList = (ArrayList<Truyenyeuthich>) response.body();
                truyenhotAdapter = new TruyenhotAdapter(getActivity(),TruyenArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerViewTruyenhot.setLayoutManager(linearLayoutManager);
                recyclerViewTruyenhot.setAdapter(truyenhotAdapter);
            }

            @Override
            public void onFailure(Call<List<Truyenyeuthich>> call, Throwable t) {

            }
        });
        }
    }

