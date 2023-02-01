package com.mornstary.fourbutton2;

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
        MyListener listener = new MyListener();
        btnNaver.setOnClickListener(listener); //내부클래스의 메소드를 사용할 것
        btn119.setOnClickListener(listener);
        btnGallery.setOnClickListener(listener);
        btnEnd.setOnClickListener(listener);
    }//onCreate 메소드 End
    //내부 클래스
    class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View view) { //추상메소드 오버라이드 할 것
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
        }//onClick
    }//MyListener
}//MainActivity 클래스 End