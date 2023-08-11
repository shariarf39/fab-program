package com.fabred.fabprogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Basic_To_Advance extends AppCompatActivity {
    ImageView imageView;
    SharedPreferences sharedPreferences;
    CardView basic, condition, datatype;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_to_advance);
        imageView = findViewById(R.id.lan_img);
        basic = findViewById(R.id.basic);
        datatype = findViewById(R.id.data_type);
        condition = findViewById(R.id.conditon);


        sharedPreferences = getSharedPreferences("fab_program", Context.MODE_PRIVATE);
        String element = sharedPreferences.getString("language", "Nothing");

        sharedPreferences = getSharedPreferences("basic_to_advance", Context.MODE_PRIVATE);
        editor= sharedPreferences.edit();

        if(element.equals("cpp")){
            imageView.setImageResource(R.drawable.cpp);

        } else if (element.equals("java")) {
            imageView.setImageResource(R.drawable.java);


        }else if (element.equals("py")) {
            imageView.setImageResource(R.drawable.python);

        }else if (element.equals("js")) {
            imageView.setImageResource(R.drawable.js);


        }else{

            Toast.makeText(this, "Error app Please Try Again Later", Toast.LENGTH_SHORT).show();
        }

        // ===============On Click

        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("language","basic");
                editor.commit();
                startActivity(new Intent(Basic_To_Advance.this, Basic.class));
            }
        });
        datatype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("language","basic");
                editor.commit();
                startActivity(new Intent(Basic_To_Advance.this, DataType.class));
            }
        });
        condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("language","basic");
                editor.commit();
                startActivity(new Intent(Basic_To_Advance.this, Conditions.class));
            }
        });
    }
}