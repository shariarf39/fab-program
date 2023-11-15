package com.fabred.fabprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class WrongActivity extends AppCompatActivity {
    TextView correct_ans;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong);

        correct_ans = findViewById(R.id.correct_ans);

        sharedPreferences = getSharedPreferences("c_ans", Context.MODE_PRIVATE);
        String ans = sharedPreferences.getString("ans", "Nothing");
        String option = sharedPreferences.getString("option", "Nothing");

        correct_ans.setText("Correct Ans:\n " +option+". "+ans);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
        MediaPlayer audio = MediaPlayer.create(this, R.raw.wrong);
        audio.start();
        thread.start();
    }
}