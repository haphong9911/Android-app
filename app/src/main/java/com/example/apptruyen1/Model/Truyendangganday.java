package com.example.apptruyen1.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Truyendangganday {

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
@SerializedName("ngaydang")
@Expose
private String ngaydang;

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

public String getNgaydang() {
return ngaydang;
}

public void setNgaydang(String ngaydang) {
this.ngaydang = ngaydang;
}

}