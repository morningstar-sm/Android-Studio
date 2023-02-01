package com.mornstary.fourbutton3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnNaver, btn119, btnGallery, btnEnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNaver = findViewById(R.id.btnNaver);
        btn119 = findViewById(R.id.btn119);
        btnGallery = findViewById(R.id.btnGallery);
        btnEnd = findViewById(R.id.btnEnd);
        btnNaver.setOnClickListener(this);
        btn119.setOnClickListener(this);
        btnGallery.setOnClickListener(this);
        btnEnd.setOnClickListener(this);
    }//onCreate 메소드 End

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnNaver:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                startActivity(intent);
                break;
            case R.id.btn119:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/119"));
                startActivity(intent);
                break;
            case R.id.btnGallery:
                intent =new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,100);
                break;
            case R.id.btnEnd:
                finish();
                break;
        }//switch
    }
}//MainActivity