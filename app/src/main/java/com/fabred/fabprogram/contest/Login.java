package com.fabred.fabprogram.contest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fabred.fabprogram.MainActivity;
import com.fabred.fabprogram.QuestionCollection;
import com.fabred.fabprogram.R;

public class Login extends AppCompatActivity {

    Button submit_button;
    EditText name, email, uni_name;
    ProgressBar progressBar;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        submit_button = findViewById(R.id.submit_button);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        uni_name = findViewById(R.id.uni_name);
        progressBar = findViewById(R.id.progress);

        sharedPreferences = getSharedPreferences("contest_Panel", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
     /*   editor.putString("savedScore", scores+ " ("+ QuestionCollection.SUBJECT_NAME+")");
        editor.apply();*/

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f_name = name.getText().toString();
                String f_email = email.getText().toString();
                String f_uni_name = uni_name.getText().toString();

                if(TextUtils.isEmpty(f_name)){
                    name.setError("Enter Your Name");
                    name.requestFocus();
                    return;
                }
               else if(TextUtils.isEmpty(f_email)){
                    email.setError("Enter Your Email");
                    name.requestFocus();
                    return;
                }
               else if (TextUtils.isEmpty(f_uni_name)) {
                   uni_name.setError("Enter Your University Name");
                   uni_name.requestFocus();
                   return;

                }
               else{
                   progressBar.setVisibility(View.VISIBLE);
                }


               //////////////////-------------------
            //    $sql = "INSERT INTO `user_data` (`name`, `uni_name`, `email`, `u_id` , `Score`) VALUES ('$name', '$uni', '$email', '$u_id', '$Score')";


                String url = "https://fabred.xyz/Fab_Programming_Quiz/data/registration.php?name=" + f_name + "&email=" + f_email + "&uni_name=" + f_uni_name;
                progressBar.setVisibility(View.VISIBLE);
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.GONE);


                        editor.putString("name", f_name);
                        editor.putString("email", f_email);
                        editor.putString("uni_name", f_uni_name);
                        editor.apply();


                        Toast.makeText(Login.this, "Registration Done", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, QuestionCollection.class);
                        startActivity(intent);


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


                RequestQueue requestQueue = Volley.newRequestQueue(Login.this);
                requestQueue.add(stringRequest);




            }
        });


    }

    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired
    private long mBackPressed;

    // When user click bakpress button this method is called
    @Override
    public void onBackPressed() {
        // When user press back button

        super.onBackPressed();
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            startActivity(new Intent(Login.this, MainActivity.class));

        } else {

            startActivity(new Intent(Login.this, MainActivity.class));
        }

        mBackPressed = System.currentTimeMillis();


    }
}