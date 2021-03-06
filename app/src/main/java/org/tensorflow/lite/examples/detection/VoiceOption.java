//2022-02-12
package org.tensorflow.lite.examples.detection;

import static android.util.Log.ERROR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;


public class VoiceOption extends AppCompatActivity {

    private TextToSpeech tts;
    //private EditText editText;
    //private TextView random, random2;
    private Button voicefrequencyHigh,voicefrequencyLow,voicefast,voicelow,reset;
    public static float speed=1;
    public int frequency=1;
    /*
    private final double border_Left=(double)1/640*212;
    private final double border_Lower=(double)1/640*212;
    private final double border_Right=(double)1/640*426;
    private final double border_Top=(double)1/640*426; */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_option);
        //editText=(EditText)  findViewById(R.id.editText);
        voicefrequencyHigh=(Button) findViewById(R.id.voicefrequency);
        voicefrequencyLow=(Button) findViewById(R.id.voicefrequency2);
        voicefast=(Button) findViewById(R.id.voicefast);
        voicelow=(Button) findViewById(R.id.voicelow);
        reset=(Button) findViewById(R.id.reset);

        tts = new TextToSpeech(this);




        voicefrequencyHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                tts.incrementFreq();
                TestText("목소리 빈도가 늘어납니다.");
            }
        });

        voicefrequencyLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                tts.decrementFreq();
                TestText("목소리 빈도가 줄어듭니다.");
            }
        });

        voicefast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(speed>=2){}

                else {
                   // speed += 0.2;
                    tts.incrementSpeed();
                    Toast.makeText(getApplicationContext(), "speed:"+Float.toString(tts.getSpeed()),Toast.LENGTH_SHORT).show();
                    TestText("목소리 속도가 빨라집니다.");
                }
                //tts.getSpeed(2.0);   //읽는 속도 2배 빠르게
                //editText 문장 읽기
            }
        });

        voicelow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(speed<=0){}

                else {
                    tts.decrementSpeed();
                    Toast.makeText(getApplicationContext(), "speed:"+Float.toString(tts.getSpeed()),Toast.LENGTH_SHORT).show();
                    TestText("목소리 속도가 느려집니다.");
                }


            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                tts.reset();
                TestText("기본 설정 상태로 초기화합니다.");

            }
        });
    }
    public void TestText(String text)
    {
        tts.readText(text);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(tts!=null)
            tts.stop();
    }

 /*
    private String inputLocation(double x_median, double y_median, double height, double width) {
        String Temp="";

        if(x_median< border_Left) { //x 중앙값이 왼쪽 경계에 있을때

            if(y_median <border_Lower) {
                Temp = "왼쪽 하단";
            }
            else {
                Temp= (y_median >= border_Lower && y_median < border_Top) ? "왼쪽":"왼쪽 상단";
            }
        }
        else if(x_median >= border_Left && x_median< border_Right ) { //x 중앙값이 중앙 경계에 있을때

            if (y_median < border_Lower) {
                Temp = "중앙 하단";
            } else {
                Temp = (y_median >= border_Lower && y_median < border_Top) ? "중앙" : "중앙 상단";
            }
        }
        else if(x_median > border_Right){
            if (y_median < border_Lower) {
                Temp = "오른쪽 하단";
            } else {
                Temp = (y_median >= border_Lower && y_median < border_Top) ? "오른쪽" : "오른쪽 상단";
            }
        }
        else System.out.println("label value error");

        return Temp;
    }
 */
   /* @Override
    protected void onDestroy() {
        super.onDestroy();
        //TTs 객체가 남아있다면 메모리에서 제거
        if(tts != null){
            tts.stop();
            tts.shutdown();
            tts=null;
        }
    }
    */
}