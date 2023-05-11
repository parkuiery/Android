package com.example.popcat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    ImageView sm;
    TextView count;
    Long clickCount = 0L;
    Button button;

    String s1;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    SoundPool clickSound;
    int clickSoundId;

    LottieAnimationView vMainAnimation1;
    LottieAnimationView vMainAnimation2;
    LottieAnimationView vMainAnimation3;
    LottieAnimationView vMainAnimation4;
    LottieAnimationView vMainAnimation5;
    LottieAnimationView vMainAnimation6;
    LottieAnimationView vMainAnimation7;
    LottieAnimationView vMainAnimation8;
    LottieAnimationView vMainAnimation9;
    LottieAnimationView vMainAnimation10;

    Vibrator vibrator;

    @SuppressWarnings("deprecation")
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("test", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        vMainAnimation1 = findViewById(R.id.v_main_animation_1);
        vMainAnimation2 = findViewById(R.id.v_main_animation_2);
        vMainAnimation3 = findViewById(R.id.v_main_animation_3);
        vMainAnimation4 = findViewById(R.id.v_main_animation_4);
        vMainAnimation5 = findViewById(R.id.v_main_animation_5);
        vMainAnimation6 = findViewById(R.id.v_main_animation_6);
        vMainAnimation7 = findViewById(R.id.v_main_animation_7);
        vMainAnimation8 = findViewById(R.id.v_main_animation_8);
        vMainAnimation9 = findViewById(R.id.v_main_animation_9);
        vMainAnimation10 = findViewById(R.id.v_main_animation_10);

        sm = findViewById(R.id.sm);
        count = findViewById(R.id.count);
        button = findViewById(R.id.button);
        clickSound = new SoundPool.Builder().build();
        clickSoundId = clickSound.load(this, R.raw.clicksound, 1);

        sm = findViewById(R.id.sm);
        count = findViewById(R.id.count);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        clickCount = sharedPreferences.getLong("count", 0L);
        count.setText(clickCount.toString());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCount = 0L;
                count.setText(clickCount.toString());
            }
        });
        //진동 울리기

        sm.setOnTouchListener(((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case (MotionEvent.ACTION_UP):
                    this.sm.setImageResource(R.drawable.shutmouse);
                    return true;
                case (MotionEvent.ACTION_DOWN):
                    this.sm.setImageResource(R.drawable.openmouth);
                    clickSound.play(clickSoundId, 1f, 1f, 0, 0, 1f);
                    int digit = (int) (clickCount % 10);
                    switch (digit) {
                        case 0:
                            vMainAnimation1.playAnimation();
                        case 1:
                            vMainAnimation2.playAnimation();
                        case 2:
                            vMainAnimation3.playAnimation();
                        case 3:
                            vMainAnimation4.playAnimation();
                        case 4:
                            vMainAnimation5.playAnimation();
                        case 5:
                            vMainAnimation6.playAnimation();
                        case 6:
                            vMainAnimation7.playAnimation();
                        case 7:
                            vMainAnimation8.playAnimation();
                        case 8:
                            vMainAnimation9.playAnimation();
                        case 9:
                            vMainAnimation10.playAnimation();
                    }
                    vibrator.vibrate(50);
                    clickCount++;
                    editor.putLong("count", clickCount).commit();
                    count.setText(clickCount.toString());
                    return true;
            }
            return false;
        }));
    }
}