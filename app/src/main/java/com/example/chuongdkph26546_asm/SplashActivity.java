package com.example.chuongdkph26546_asm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //Ẩn tên ứng dụng trên thanh tiêu đề
        getSupportActionBar().hide(); // Ẩn cả thanh tiêu đề đi
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //Bật chế độ toàn màn hình

        setContentView(R.layout.activity_splash);



        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }

}