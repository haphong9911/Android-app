package com.example.apptruyen1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.apptruyen1.R;

public class dangki extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangki);
        anhxa();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dangki.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(dangki.this, "dang ky thanh cong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void anhxa() {
        button = findViewById(R.id.button_register);
    }
}