package com.mornstarY.bmicheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtHeight, edtWeight;
    Button btnBMICheck;
    TextView txtResult;
    ImageView imageBMI;
    int height, weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        btnBMICheck = findViewById(R.id.btnBMICheck);
        txtResult = findViewById(R.id.txtResult);
        imageBMI = findViewById(R.id.imageBMI); //좌측은 클래스 필드, 우측의 imageBMI는 xml파일 변수(?).
        //버튼 클릭 이벤트
        btnBMICheck.setOnClickListener(new View.OnClickListener() { //OnClickListener 추상메소드 오버라이딩 할 거
            @Override
            public void onClick(View view) {
                height = Integer.parseInt(edtHeight.getText().toString());
                weight = Integer.parseInt(edtWeight.getText().toString());
                int standardWeight = (int) ((height-100) * 0.9);	// 표준몸무게=(키-100)*0.9
                if(weight > standardWeight + 5) {
                    txtResult.setText("비만입니다. 운동하세요");
                    imageBMI.setImageResource(R.drawable.ob);
                }
                else if(weight >= standardWeight - 5) {
                    txtResult.setText("정상입니다. 꾸준히 유지하세요");
                    imageBMI.setImageResource(R.drawable.good);
                }
                else {
                    txtResult.setText("마른체형입니다. 밥 많이 드세요.");
                    imageBMI.setImageResource(R.drawable.thin);
                }
            }//onClick End

        });

/*    Button btnHello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHello = findViewById(R.id.btnHello);  //R.id.btnHello에서 btnHello는 앞에서 작업한 xml의 id이름임(버튼이름)
        btnHello.setOnClickListener(new View.OnClickListener() {  //익명으로 만들건데, 클릭하면  ~~해줘 라고 추상메소드를 만들것.
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"안녕하세요 여러분 뇽뇽", Toast.LENGTH_SHORT).show();
            }
        });

 */

    }
}