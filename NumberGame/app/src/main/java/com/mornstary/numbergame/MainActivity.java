package com.mornstary.numbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //선언부
    EditText edtNumber;
    Button btnGameStart, btnResult, btnEnd;
    TextView hintAndResult;
    ImageView imgGame;
    int myNum, comNum, count, choice; //내숫자, 컴숫자 변수, 몇번째 시도인지 변수, 복불복 메뉴 변수
    Random rand = new Random();
    String[] menu = {"편의점커피", "음료수", "과자한봉지", "꽝(없음)", "꿀밤 한대", "삼각김밥"}; //이긴사람의 랜덤메뉴
    
    //연결부
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNumber = findViewById(R.id.edtNumber);
        btnGameStart = findViewById(R.id.btnGameStart);
        btnResult = findViewById(R.id.btnResult);
        hintAndResult = findViewById(R.id.hintAndResult);
        btnEnd = findViewById(R.id.btnEnd);
        imgGame = findViewById(R.id.imgGame);
        
        //실행부
        //게임시작 버튼 이벤트
        btnGameStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                comNum = (int)(Math.random()*100)+1;
                btnResult.setEnabled(true);  //결과확인 버튼을 활성화
                btnGameStart.setEnabled(false); //게임이 끝나서 맞출 때 까지는 게임 시작버튼 비활성화
                hintAndResult.setText("자! 게임이 시작되었습니다.");
                imgGame.setImageResource(R.drawable.number);  // 게임 끝난 후 new 게임이 시작된 게 보이도록 그림 수정
            }
        });
        //결과확인 버튼 이벤트
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    myNum = Integer.parseInt(edtNumber.getText().toString());
                    count++;  //이 카운트가 적은 사람이 이기게 할 것
                    if (myNum > comNum) {
                        hintAndResult.setText("당신의 숫자가 커요. 좀 더 작은 수를 넣어보세요\n(" + count + "번 틀림)");
                        imgGame.setImageResource(R.drawable.wrong);
                    } else if (myNum < comNum) {
                        hintAndResult.setText("당신의 숫자가 작아요. 좀 더 큰 수를 넣어보세요\n(" + count + "번 틀림)");
                        imgGame.setImageResource(R.drawable.wrong);
                    } else {
                        choice = rand.nextInt(menu.length); //메뉴가 복불복으로 선택됨
                        hintAndResult.setText("축하합니다. 맞추셨습니다!\n(맞춘 횟수 = " + count + ")\n내기상품=>" + menu[choice]);
                        imgGame.setImageResource(R.drawable.good);
                        btnResult.setEnabled(false);
                        btnGameStart.setEnabled(true);
                    }
                    edtNumber.setText(""); //입력 후 결과확인을 누르면 글자를 지워지도록 세팅
                } catch (NumberFormatException e){
                    hintAndResult.setText("숫자를 입력하고 결과확인 버튼을 누르세요");
                }
            }
        }); //btnResult End
        //앱 종료 버튼 이벤트
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}