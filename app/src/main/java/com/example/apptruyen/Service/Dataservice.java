package com.example.apptruyen.Service;

import com.example.apptruyen1.Model.Danhsachtheloai;
import com.example.apptruyen1.Model.Quangcao;
import com.example.apptruyen1.Model.Theloaitoday;
import com.example.apptruyen1.Model.Theloaitrongngay;
import com.example.apptruyen1.Model.Truyendangganday;
import com.example.apptruyen1.Model.Truyendetail;
import com.example.apptruyen1.Model.Truyenganday;
import com.example.apptruyen1.Model.Truyennoibat;
import com.example.apptruyen1.Model.Truyenyeuthich;

import java.sql.Struct;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
    @GET("truyen.php")
    Call<List<Quangcao>> GetDataBanner ();
    @GET("TheLoaiToday.php")
    Call<List<Theloaitoday>> GetTheloaiToday();
    @GET("TheLoaiTrongNgay.php")
    Call<Theloaitrongngay> GetTheloaitrongngay();
    @GET("Truyenall.php")
    Call<List<Truyennoibat>> GetTruyenNoiBat();
    @GET("truyenyeuthich.php")
    Call<List<Truyenyeuthich>> GetTruyenyeuthich();
    @GET("truyenhay.php")
    Call<List<Truyendangganday>> GetTruyendangganday();
    @FormUrlEncoded
    @POST("danhsachtruyen.php")
    Call<List<Truyenyeuthich>> GetDanhsachtruyentheoquangcao(@Field("idquangcao") String idquangcao);
    @GET("tungtruyen.php")
    Call<List<Truyenganday>> GetTruyenganday();

    @FormUrlEncoded
    @POST("theloaitoday.php")
    Call<Truyenyeuthich> Getdanhsachtheloai(@Field("idtheloai") String idtheloai);

    @GET("danhsachtheloai.php")
    Call<List<Danhsachtheloai>> Gettheloai();
    @GET("doctruyen.php")
    Call<List<Truyendetail>> GetThuvien();
   @FormUrlEncoded
    @POST("updateluotthich.php")
    Call<String> Updateluotthich (@Field("luotxem") String luotxem, @Field("Idtruyen") String Idtruyen);
 }
