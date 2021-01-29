package com.example.apptruyen1.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Truyendetail implements Serializable {

    @SerializedName("IDtruyen")
    @Expose
    private String iDtruyen;
    @SerializedName("tentruyen")
    @Expose
    private String tentruyen;
    @SerializedName("tacgia")
    @Expose
    private String tacgia;
    @SerializedName("hinhanhtruyen")
    @Expose
    private String hinhanhtruyen;
    @SerializedName("IDtheloai")
    @Expose
    private String iDtheloai;
    @SerializedName("ngaydang")
    @Expose
    private String ngaydang;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("luotxem")
    @Expose
    private String luotxem;
    @SerializedName("tentheloai")
    @Expose
    private String tentheloai;
    @SerializedName("IDnoidungtruyen")
    @Expose
    private String iDnoidungtruyen;
    @SerializedName("noidung")
    @Expose
    private String noidung;
    @SerializedName("gioithieutruyen")
    @Expose
    private String gioithieutruyen;
    @SerializedName("sochuong")
    @Expose
    private String sochuong;

    public String getIDtruyen() {
        return iDtruyen;
    }

    public void setIDtruyen(String iDtruyen) {
        this.iDtruyen = iDtruyen;
    }

    public String getTentruyen() {
        return tentruyen;
    }

    public void setTentruyen(String tentruyen) {
        this.tentruyen = tentruyen;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getHinhanhtruyen() {
        return hinhanhtruyen;
    }

    public void setHinhanhtruyen(String hinhanhtruyen) {
        this.hinhanhtruyen = hinhanhtruyen;
    }

    public String getIDtheloai() {
        return iDtheloai;
    }

    public void setIDtheloai(String iDtheloai) {
        this.iDtheloai = iDtheloai;
    }

    public String getNgaydang() {
        return ngaydang;
    }

    public void setNgaydang(String ngaydang) {
        this.ngaydang = ngaydang;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLuotxem() {
        return luotxem;
    }

    public void setLuotxem(String luotxem) {
        this.luotxem = luotxem;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    public String getIDnoidungtruyen() {
        return iDnoidungtruyen;
    }

    public void setIDnoidungtruyen(String iDnoidungtruyen) {
        this.iDnoidungtruyen = iDnoidungtruyen;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getGioithieutruyen() {
        return gioithieutruyen;
    }

    public void setGioithieutruyen(String gioithieutruyen) {
        this.gioithieutruyen = gioithieutruyen;
    }

    public String getSochuong() {
        return sochuong;
    }

    public void setSochuong(String sochuong) {
        this.sochuong = sochuong;
    }

}