package com.example.apptruyen1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptruyen.Service.APIService;
import com.example.apptruyen.Service.Dataservice;
import com.example.apptruyen1.Model.Truyenyeuthich;
import com.example.apptruyen1.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtruyenAdapter extends RecyclerView.Adapter<DanhsachtruyenAdapter.ViewHolder>{

    Context context;
    ArrayList<Truyenyeuthich> mangtruyen;

    public DanhsachtruyenAdapter(Context context, ArrayList<Truyenyeuthich> mangtruyen) {
        this.context = context;
        this.mangtruyen = mangtruyen;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danh_sach_truyen,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Truyenyeuthich truyenyeuthich = mangtruyen.get(position);
        holder.txttentruyen.setText(truyenyeuthich.getTentruyen());
        holder.txttentacgia.setText(truyenyeuthich.getTacgia());
        holder.txtindex.setText(position + 1 +"");

    }

    @Override
    public int getItemCount() {
        return mangtruyen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtindex,txttentruyen,txttentacgia;
        ImageView imgluotthich;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttentacgia = itemView.findViewById(R.id.textviewtentacgia1);
            txtindex = itemView.findViewById(R.id.textviewdanhsachindex);
            txttentruyen = itemView.findViewById(R.id.textviewtentruyen);
            imgluotthich = itemView.findViewById(R.id.imageviewluotthich);
            imgluotthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgluotthich.setImageResource(R.drawable.iconlove);
                    Dataservice dataservice = APIService.getService();
                    Call<String> callback = dataservice.Updateluotthich("1",mangtruyen.get(getPosition()).getIdtruyen());
                    callback.enqueue(new Callback<String>() {
                                         @Override
                                         public void onResponse(Call<String> call, Response<String> response) {
                                             String ketqua = response.body();
                                             if (ketqua.equals("oke")) {
                                                 Toast.makeText(context, "Đã Thích", Toast.LENGTH_SHORT).show();
                                             } else {
                                                 Toast.makeText(context, "Lỗi", Toast.LENGTH_SHORT).show();
                                             }
                                         }

                                         @Override
                                         public void onFailure(Call<String> call, Throwable t) {

                                         }
                                     });
                    imgluotthich.setEnabled(false);
                }
            });
        }
    }
}
