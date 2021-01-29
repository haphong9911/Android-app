package com.example.apptruyen1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apptruyen1.Model.Truyendetail;
import com.example.apptruyen1.R;
import com.squareup.picasso.Picasso;

public class TruyenDetailActivity extends AppCompatActivity {
    TextView txtdttentruyen ,txtdttentacgia ,txtdttheloai,txtdttrangthai,txtdtluotdoc,txtdtgioithieu,txtdtsochuong;
    ImageView imgdttruyen;
    Button bntdoctruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen_detail);

    anhxa();

    final Truyendetail truyendetail = (Truyendetail) getIntent().getSerializableExtra("truyen");
        Picasso.with(getApplicationContext()).load(truyendetail.getHinhanhtruyen()).into(imgdttruyen);
        txtdttentruyen.setText(truyendetail.getTentruyen());
        txtdttentacgia.setText("Tác giả: "+truyendetail.getTacgia());
        txtdttheloai.setText("Thể loại: "+truyendetail.getTentheloai());
        txtdttrangthai.setText("Trạng thái: "+truyendetail.getStatus());
        txtdtluotdoc.setText("Lượt đọc"+truyendetail.getLuotxem());
        txtdtsochuong.setText("Số chương: "+truyendetail.getSochuong());
        txtdtgioithieu.setText(truyendetail.getGioithieutruyen());

        bntdoctruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TruyenDetailActivity.this,DoctruyenActivity.class);
                intent1.putExtra("datatruyen",truyendetail);
                startActivity(intent1);
            }
        });


    }

    private void anhxa() {
        txtdttentruyen = (TextView)findViewById(R.id.txttentruyendetail);
        txtdttentacgia = (TextView)findViewById(R.id.txttacgiadetail);
        txtdttheloai =(TextView) findViewById(R.id.txttheloaidetail);
        txtdttrangthai =(TextView) findViewById(R.id.txttrangthaidetail);
        txtdtluotdoc = (TextView) findViewById(R.id.txtluotdocdetail);
        txtdtgioithieu=(TextView) findViewById(R.id.txtgioithieudetail);
        txtdtsochuong =(TextView)findViewById(R.id.txtsochuongdetail);
        imgdttruyen = (ImageView)findViewById(R.id.imgtruyendetail);
        bntdoctruyen = (Button)findViewById(R.id.btndoctruyen);

    }
}