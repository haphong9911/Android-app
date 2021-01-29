package com.example.apptruyen1.Fragment;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.apptruyen1.Activity.DanhsachcactheloaiActivity;
import com.example.apptruyen1.Adapter.TheloaiTodayAdapter;
import com.example.apptruyen1.Model.Theloaitoday;
import com.example.apptruyen1.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.PendingIntent.getActivity;

public class Fragment_Theloaitoday  extends Fragment {
    RecyclerView recyclerViewtheloaitoday;
    TextView txtxemthemtheloai;
    TheloaiTodayAdapter theloaitodayAdapter;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_the_loai,container,false);
        recyclerViewtheloaitoday = view.findViewById(R.id.recyclerviewtheloai);
        txtxemthemtheloai = view.findViewById(R.id.txtxemthemtheloai);
        GetData();
        txtxemthemtheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DanhsachcactheloaiActivity.class);
                startActivity(intent);

            }
        });
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Theloaitoday>> callback = dataservice.GetTheloaiToday();
        callback.enqueue(new Callback<List<Theloaitoday>>() {
            @Override
            public void onResponse(Call<List<Theloaitoday>> call, Response<List<Theloaitoday>> response) {
                ArrayList<Theloaitoday> theloaitoday = (ArrayList<Theloaitoday>) response.body();
                theloaitodayAdapter = new TheloaiTodayAdapter(getActivity(), theloaitoday);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewtheloaitoday.setLayoutManager(linearLayoutManager);
                recyclerViewtheloaitoday.setAdapter(theloaitodayAdapter);
            }

            @Override
            public void onFailure(Call<List<Theloaitoday>> call, Throwable t) {

            }
        });
//        callback.enqueue(new Callback<List<Theloaitoday>>() {
//            @Override
//            public void onResponse(Call<List<Theloaitoday>> call, Response<List<Theloaitoday>> response) {
//                ArrayList<Theloaitoday> theLoaiToday = (ArrayList<Theloaitoday>) response.body();
//                theloaitodayAdapter = new TheloaitodayAdapter(getActivity(), );
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//                recyclerViewtheloaitoday.setLayoutManager(linearLayoutManager);
//                recyclerViewtheloaitoday.setAdapter(theloaitodayAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<TheLoaiToday>> call, Throwable t) {
//
//            }
//        });

    }
}
