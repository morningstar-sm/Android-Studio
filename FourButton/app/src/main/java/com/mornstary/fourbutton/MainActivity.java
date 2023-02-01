package com.mornstary.fourbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnNaver, btn119, btnGallery, btnEnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNaver = findViewById(R.id.btnNaver);
        btn119 = findViewById(R.id.btn119);
        btnGallery = findViewById(R.id.btnGallery);
        btnEnd = findViewById(R.id.btnEnd);
        //네이버 버튼 이벤트
        btnNaver.setOnClickListener(new View.OnClickListener() {  //onClickListener 이 인터페이스
            @Override
            public void onClick(View view) {  //추상메소드
                Intent naver = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"));
                startActivity(naver);
            }
        });
        //119 전화걸기 이벤트
        btn119.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call119 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/119"));
                startActivity(call119);
            }
        });
        //갤러리 열기 이벤트
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery =new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(gallery,100);
            }
        });
        //앱종료 이벤트
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}