package com.fabred.fabprogram;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;

public class ScoreActivity extends AppCompatActivity {

    TextView txtscore;
    TextView txtStatus, tvSubjectName, wrong_score,textView2;
    MediaPlayer audio;
    ImageView imgBack;
    Button score_submit;
    SharedPreferences sharedPreferences;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        imgBack = findViewById(R.id.imgBack);
        tvSubjectName = findViewById(R.id.tvSubjectName);
        txtscore = findViewById(R.id.txtscore);
        textView2 = findViewById(R.id.textView2);
        wrong_score = findViewById(R.id.wrong);
        txtStatus = findViewById(R.id.txtStatus);
        score_submit = findViewById(R.id.score_submit);
        progressBar = findViewById(R.id.progressBar);






        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);

        Intent intent = getIntent();
        String scores = String.valueOf(intent.getIntExtra("score", 0));
        String wrong = String.valueOf(intent.getIntExtra("wrong", 0));
        String total = String.valueOf(intent.getIntExtra("total", 0));

        txtscore.setText(scores);
        txtStatus.setText(setStatus(scores));
        wrong_score.setText("Wrong: "+wrong);
        textView2.setText("Total: "+total+"\n"+"Correct:");

        String nssss = "Contest";

        sharedPreferences = getSharedPreferences("contest_Panel", MODE_PRIVATE);

        String email = sharedPreferences.getString("subjectName", "NoData");


        audio.start();
        if(QuestionCollection.SUBJECT_NAME.equals(nssss)){
            score_submit.setVisibility(View.VISIBLE);
        }else{
            score_submit.setVisibility(View.GONE);

        }



        score_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // Create a DatePickerDialog

                String date = String.valueOf(year-month-day);



                sharedPreferences = getSharedPreferences("contest_Panel", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String email = sharedPreferences.getString("email", "No Data");
                String url = "https://fabred.xyz/Fab_Programming_Quiz/data/update.php?email=" +email+ "&Score=" +scores + "&u_id="+date;

                progressBar.setVisibility(View.VISIBLE);
                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(ScoreActivity.this, "Success", Toast.LENGTH_SHORT).show();


                        new AlertDialog.Builder(ScoreActivity.this)
                                .setTitle("Submitted")
                                .setMessage("Thank You")
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Whatever...
                                        dialog.cancel();
                                    }
                                }).show();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


                RequestQueue requestQueue = Volley.newRequestQueue(ScoreActivity.this);
                requestQueue.add(request);
            }
        });


        tvSubjectName.setText(QuestionCollection.SUBJECT_NAME);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(ScoreActivity.this, MainActivity.class);
                home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(home);
                finish();
            }
        });

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("savedScore", scores+ " ("+ QuestionCollection.SUBJECT_NAME+")");
        editor.apply();




    }

    private String setStatus(String scores){
        int score = Integer.parseInt(scores);

        if(score >= 8){
            audio = MediaPlayer.create(this, R.raw.high_score);
            return "অভিনন্দন!! খুব ভালো করেছেন";
        }

        if (score >= 5){
            audio = MediaPlayer.create(this,  R.raw.medium_score);
            return "ভালো হয়েছে। আবার চেষ্টা করুন";
        }

        audio = MediaPlayer.create(this,  R.raw.low_score);
        return "আরো ভালো করতে হবে :) ";

    }




    //=======================================================

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent home = new Intent(ScoreActivity.this, MainActivity.class);
        home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(home);
        finish();
    }
}