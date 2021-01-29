package com.example.apptruyen1.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.apptruyen1.Model.Truyendetail;
import com.example.apptruyen1.R;
import com.squareup.picasso.Picasso;

import org.sufficientlysecure.htmltextview.HtmlTextView;

public class DoctruyenActivity extends AppCompatActivity {
    ImageView imgdoctruyen;
    HtmlTextView txtnoidung;
    TextView txttentruyen;
    Truyendetail thuvien;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctruyen);
        anhxa();
        Truyendetail thuvien = (Truyendetail) getIntent().getSerializableExtra("datatruyen");
        txtnoidung.setHtml(thuvien.getNoidung());
        txttentruyen.setText(thuvien.getTentruyen());
        Picasso.with(getApplicationContext()).load(thuvien.getHinhanhtruyen()).into(imgdoctruyen);
    }

    private void anhxa() {
        txtnoidung = (HtmlTextView) findViewById(R.id.noidungtruyen);
        txttentruyen =(TextView)findViewById(R.id.txtdoctruyen);
        imgdoctruyen = (ImageView) findViewById(R.id.imgdoctruyen);
    }
    
}
