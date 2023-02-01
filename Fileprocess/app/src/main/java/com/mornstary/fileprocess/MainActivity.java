package com.mornstary.fileprocess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    Button btnNotice;
    TextView tvResult;
    InputStream inputs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNotice = findViewById(R.id.btnNotice);
        tvResult = findViewById(R.id.tvResult);
        //공지사항 버튼 이벤트
        btnNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    inputs = getResources().openRawResource(R.raw.notice);
                    byte[] txt = new byte[inputs.available()]; //new byte[20]; 20바이트까지만 읽어온다는 뜻
                    inputs.read(txt);
                    String msg = new String(txt);   //byte코드를 String으로 바꾸기.
                    tvResult.setText(msg);
                    // inputs.close(); //open했으니 반드시 close. 아직 안닫혔으니 [inputs.available()]에서 읽다가 에러나면 다른 파일 못읽음.
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "파일을 읽을 수 없습니다.", Toast.LENGTH_SHORT).show();
                } //왜 try-catch를 요구하지? - [inputs.available()] 읽다가 가짜 텍스트 파일이거나 해서 읽다가 에러나면 catch,
                finally {
                    try {
                        inputs.close();  // finally로 문서 닫기. 그러나 close하다가도 에러날 수도 있으므로 try-catch
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }//onClick 메소드 End
        });
    }//onCreate End
}//Class End