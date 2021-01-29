package com.example.apptruyen1.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.apptruyen.Service.APIService;
import com.example.apptruyen.Service.Dataservice;
import com.example.apptruyen1.Activity.TruyenDetailActivity;
import com.example.apptruyen1.Adapter.TheloaiAdapter;
import com.example.apptruyen1.Model.Truyendetail;
import com.example.apptruyen1.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.apptruyen1.R.layout.fragment_the_loai;

public class Fragment_The_loai extends Fragment {
    ListView listtruyen;
    TheloaiAdapter theloaiAdapter;
    ArrayList<Truyendetail> thuvienArrayList;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_theloai,container,false);
        listtruyen=(ListView) view.findViewById(R.id.listviewthuvien);
        GetData();
        return view;

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Truyendetail>> callback = dataservice.GetThuvien();
        callback.enqueue(new Callback<List<Truyendetail>>() {
            @Override
            public void onResponse(Call<List<Truyendetail>> call, Response<List<Truyendetail>> response) {
                final ArrayList<Truyendetail> thuvienArrayList = (ArrayList<Truyendetail>) response.body();
                theloaiAdapter = new TheloaiAdapter(getActivity(), thuvienArrayList);
                listtruyen.setAdapter(theloaiAdapter);
                listtruyen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String tentruyen = thuvienArrayList.get(position).getTentruyen();
                        for (int i = 0; i < thuvienArrayList.size(); i++) {
                            if (thuvienArrayList.get(i).getTentruyen() == thuvienArrayList.get(i).getTentruyen()) {
                                Intent intent = new Intent(view.getContext(), TruyenDetailActivity.class);
                                intent.putExtra("truyen", thuvienArrayList.get(i));
                                startActivity(intent);
                                break;
                            }
                        }
                    }
                });
//                listtruyen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        String tentruyen = thuvienArrayList.get(position).getTentruyen();
//                        for (int i=0;i<thuvienArrayList.size();i++){
//                            if(thuvienArrayList.get(position).getTentruyen() == thuvienArrayList.get(i).getTentruyen()){
//                                Intent intent = new Intent(view.getContext(), TruyenDetailActivity.class);
//                                intent.putExtra("truyendetail", thuvienArrayList.get(i));
//                                startActivity(intent);
//                                break;
//                            }
//                        }
//                    }
//                });
//            }
//
//            @Override
//            public void onFailure(Call<List<Truyendetail>> call, Throwable t) {
//
//            }
//        });
            }

            @Override
            public void onFailure(Call<List<Truyendetail>> call, Throwable t) {

            }


        });
    }}