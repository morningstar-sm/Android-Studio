package com.mornstary.javaex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT); //액티비티 화면 크기 가로세로.
        LinearLayout layout = new LinearLayout(this);
        setContentView(layout,layoutParams);  //화면 꽉 차게 만들겠다. Params위치와 크기.
        Button btnHello = new Button(this);  // this : '액티비티 화면에 보여주겠다' 는 뜻
        TextView tvMessage = new TextView(this);
        btnHello.setText("인사하기");
        tvMessage.setTextSize(20);
        layout.addView(btnHello);//위젯을 담는다. View : 위젯 총칭
        layout.addView(tvMessage);
        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvMessage.setText("안녕하세요 여러분");
            }
        });
    }
}