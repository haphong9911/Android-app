package com.example.apptruyen1.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Truyenyeuthich {

@SerializedName("idtruyen")
@Expose
private String idtruyen;
@SerializedName("tentruyen")
@Expose
private String tentruyen;
@SerializedName("hinhanhtruyen")
@Expose
private String hinhanhtruyen;
@SerializedName("tacgia")
@Expose
private String tacgia;
@SerializedName("luotxem")
@Expose
private String luotxem;

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

public String getHinhanhtruyen() {
return hinhanhtruyen;
}

public void setHinhanhtruyen(String hinhanhtruyen) {
this.hinhanhtruyen = hinhanhtruyen;
}

public String getTacgia() {
return tacgia;
}

public void setTacgia(String tacgia) {
this.tacgia = tacgia;
}

public String getLuotxem() {
return luotxem;
}

public void setLuotxem(String luotxem) {
this.luotxem = luotxem;
}

}