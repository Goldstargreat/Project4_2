package kr.ac.kopo.project4_2;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox chkStart;
    LinearLayout linearSub;
    TextView txtQuestion;
    RadioGroup radioGroup;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnOk; // 확인 버튼
    ImageView imgPet; // 동물 사진

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기: ");

        chkStart = findViewById(R.id.chkStart); // xml 요소 연결
        txtQuestion = findViewById(R.id.txtQuestion);
        radioGroup = findViewById(R.id.radioGroup);
        rdoDog = findViewById(R.id.rdoDog);
        rdoCat = findViewById(R.id.rdoCat);
        rdoRabbit = findViewById(R.id.rdoRabbit);
        btnOk = findViewById(R.id.btnOk);
        imgPet = findViewById(R.id.imgPet);

        // 체크박스 이벤트
        chkStart.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
            {   // 숨겨져 있던 것을 보이게
                txtQuestion.setVisibility(View.VISIBLE);
                radioGroup.setVisibility(View.VISIBLE);
                btnOk.setVisibility(View.VISIBLE);
            } else
            {
                txtQuestion.setVisibility(View.GONE);
                radioGroup.setVisibility(View.GONE);
                btnOk.setVisibility(View.GONE);
                imgPet.setVisibility(View.GONE);
            }
        });

        // 버튼 클릭 이벤트
        btnOk.setOnClickListener(v -> {

            imgPet.setVisibility(View.VISIBLE);
            if (rdoDog.isChecked())
            {
                imgPet.setImageResource(R.drawable.dog);
            } else if (rdoCat.isChecked())
            {
                imgPet.setImageResource(R.drawable.cat);
            } else if (rdoRabbit.isChecked())
            {
                imgPet.setImageResource(R.drawable.rabbit);
            } else
            {
                Toast.makeText(getApplicationContext(), "동물을 선택하세요!", Toast.LENGTH_SHORT).show();
                imgPet.setVisibility(View.GONE);
            }
        });
    }
}