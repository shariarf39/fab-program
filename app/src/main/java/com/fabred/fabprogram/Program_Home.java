package com.fabred.fabprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Program_Home extends AppCompatActivity {

    ImageView imageView, l_img;
    TextView des, l_text;
    SharedPreferences sharedPreferences;
    androidx.cardview.widget.CardView l_next;

  //  @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_home);
        imageView = findViewById(R.id.images);
        des = findViewById(R.id.describtion);
        l_img = findViewById(R.id.l_img);
        l_text = findViewById(R.id.l_text);
        l_next = findViewById(R.id.l_next);

        sharedPreferences = getSharedPreferences("fab_program", Context.MODE_PRIVATE);
        String element = sharedPreferences.getString("language", "Nothing");

        if(element.equals("cpp")){
            imageView.setImageResource(R.drawable.cpp);
            des.setText("C++ \n\nC++ Programming language");
            l_text.setText("Learn C++");
            l_img.setImageResource(R.drawable.cpp);
        } else if (element.equals("java")) {
            imageView.setImageResource(R.drawable.java);
            des.setText("Java \n\nJava Programming language");
            l_text.setText("Learn Java");
            l_img.setImageResource(R.drawable.java);

        }else if (element.equals("py")) {
            imageView.setImageResource(R.drawable.python);
            des.setText("Python \n\nPython Programming language");
            l_text.setText("Learn Python");
            l_img.setImageResource(R.drawable.python);

        }else if (element.equals("js")) {
            imageView.setImageResource(R.drawable.js);
            des.setText("JavaScript \n\nJavaScript Programming language");
            l_text.setText("Learn \nJavaScript");
            l_img.setImageResource(R.drawable.js);

        }else{
            des.setText("App Error");
            Toast.makeText(this, "Error app Please Try Again Later", Toast.LENGTH_SHORT).show();
        }

        l_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Program_Home.this, Basic_To_Advance.class));
            }
        });


    }
}