package com.example.exe3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ManHinhChinh extends AppCompatActivity {
Button btnNhaThuoc, btnThuoc, btnHoaDon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);
        btnNhaThuoc = findViewById(R.id.NhaThuoc);
        btnThuoc = findViewById(R.id.Thuoc);
        btnHoaDon = findViewById(R.id.HoaDon);

        setEvent();
    }

    private void setEvent() {
        btnNhaThuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}