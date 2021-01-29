package com.example.apptruyen1.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Quangcao implements Serializable {

@SerializedName("IDquangcao")
@Expose
private String iDquangcao;
@SerializedName("hinhanh")
@Expose
private String hinhanh;
@SerializedName("noidung")
@Expose
private String noidung;
@SerializedName("IDtruyen")
@Expose
private String iDtruyen;
@SerializedName("tentruyen")
@Expose
private String tentruyen;
@SerializedName("hinhanhtruyen")
@Expose
private String hinhanhtruyen;

public String getIDquangcao() {
return iDquangcao;
}

public void setIDquangcao(String iDquangcao) {
this.iDquangcao = iDquangcao;
}

public String getHinhanh() {
return hinhanh;
}

public void setHinhanh(String hinhanh) {
this.hinhanh = hinhanh;
}

public String getNoidung() {
return noidung;
}

public void setNoidung(String noidung) {
this.noidung = noidung;
}

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

public String getHinhanhtruyen() {
return hinhanhtruyen;
}

public void setHinhanhtruyen(String hinhanhtruyen) {
this.hinhanhtruyen = hinhanhtruyen;
}

}