package com.example.apptruyen1.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Truyennoibat {

@SerializedName("Idtruyen")
@Expose
private String idtruyen;
@SerializedName("Tentruyen")
@Expose
private String tentruyen;
@SerializedName("Tacgia")
@Expose
private String tacgia;
@SerializedName("Hinhanhtruyen")
@Expose
private String hinhanhtruyen;

public String getIdtruyen() {
return idtruyen;
}

public void setIdtruyen(String idtruyen) {
this.idtruyen = idtruyen;
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

}