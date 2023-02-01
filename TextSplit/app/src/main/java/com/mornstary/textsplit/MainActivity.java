package com.mornstary.textsplit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    TextView tvTitle, txtResult;
//  RadioButton[] rdoQ1, rdoQ2, rdoQ3, rdoQ4;
    RadioButton[] rdoQ = new RadioButton[4];
    Integer[] rdoQID = {R.id.rdoQ1, R.id.rdoQ2, R.id.rdoQ3, R.id.rdoQ4}; //id 값을 상수값으로 보관하고 있기 떄문에 이게 가능.
    Integer[] testImage = {R.drawable.test1, R.drawable.test2, R.drawable.test3, R.drawable.test4};
    Button btnResult;
    ImageView imgItem; //xml이랑 java랑 연결 되어 있으면 보라색
    int choice; //연결이 안되어 있으면 회색. 
    String[] spStr; //test.txt의 #구분자로 배열의 방에 각각 넣을 것.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitle = findViewById(R.id.tvTitle);
        txtResult = findViewById(R.id.txtResult);
/*      rdoQ1 = findViewById(R.id.rdoQ1);
        rdoQ2 = findViewById(R.id.rdoQ2);
        rdoQ3 = findViewById(R.id.rdoQ3);
        rdoQ4 = findViewById(R.id.rdoQ4);   */
        for(int i =0; i<rdoQ.length; i++){
            rdoQ[i] = findViewById(rdoQID[i]); //배열로 필드 추가
        }
        btnResult = findViewById(R.id.btnResult);
        imgItem = findViewById(R.id.imgItem);
        //Raw폴더에 있는 test.txt를 가져와서 split메소드로 분리해서 배열에 보관
        try{
            InputStream is = getResources().openRawResource(R.raw.test);
            byte[] txt = new byte[is.available()]; //길이대로 다 가져오기
            is.read(txt);
            String str = new String(txt);
            spStr = str.split("#");
            tvTitle.setText("질문 : " + spStr[0] + "(10년후 나의 모습)");
    /*      rdoQ1.setText(spStr[1]);
            rdoQ2.setText(spStr[2]);
            rdoQ3.setText(spStr[3]);
            rdoQ4.setText(spStr[4]);    */
            for(int i=0; i<rdoQ.length; i++){
                rdoQ[i].setText(spStr[i+1]);
            }
        }catch (IOException e){
            Toast.makeText(getApplicationContext(), "파일을 읽을 수 없습니다.", Toast.LENGTH_SHORT).show();  //메인에 보여줄 것, 보여줄 문자, 보여줄 시간
        }

        //Radio버튼을 클릭할 때마다 해당 이미지를 imageview에 보여주기
        //를 배열로 할 수 있다.
    /*  rdoQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice = 5; //질문 선택 1에 대한 답변
                imgItem.setImageResource(R.drawable.test1);
                txtResult.setText("");

            }
        });
         rdoQ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice = 6; //질문 선택2에 대한 답변
                imgItem.setImageResource(R.drawable.test2);
            }
        });
        rdoQ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice = 7;
                imgItem.setImageResource(R.drawable.test3);
            }
        });
        rdoQ4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice = 8;
                imgItem.setImageResource(R.drawable.test4);
            }
        }); */
        for(int i=0; i<rdoQ.length; i++){
            final int index = i; //choice와 testImagep[index]값이 제대로 되기 위해 final 값을 요구(에러), 그래서 이걸 추가.
            rdoQ[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    choice = index +5; //질문 선택 1에 대한 답변
                    imgItem.setImageResource(testImage[index]); //배열로 필드추가
                    txtResult.setText("");
                }
            });
        } //for End

        //결과 보기 버튼 이벤트로 테스트 결과를 textView에 보여주기
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResult.setText(spStr[choice]);
            }
        });
    }
}