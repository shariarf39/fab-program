package com.fabred.fabprogram.contest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fabred.fabprogram.R;

public class Profile extends AppCompatActivity {

    TextView name, uni_name, emai;
    Button delete;

    SharedPreferences sharedPreferences;
    ProgressBar progress;
    TextView privacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name = findViewById(R.id.name);
        uni_name = findViewById(R.id.uni_name);
        emai = findViewById(R.id.email);
        progress = findViewById(R.id.progress);
        privacy = findViewById(R.id.privacy);


        delete = findViewById(R.id.delete);
        sharedPreferences = getSharedPreferences("contest_Panel", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String emails = sharedPreferences.getString("email", null);
        String uni_names = sharedPreferences.getString("uni_name",null);
        String names = sharedPreferences.getString("name",null);
        emai.setText("Email: " + emails);
        uni_name.setText("University: " + uni_names);

        name.setText("Name: " + names);
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String privacyPolicyUrl = "https://sites.google.com/view/fabprogram-privacy-policy/home";

                // Create an Intent to open a web browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(privacyPolicyUrl));

                // Check if there's a browser available to handle the Intent
                if (browserIntent.resolveActivity(getPackageManager()) != null) {
                    // Start the browser activity
                    startActivity(browserIntent);
                } else {
                    // Handle the case where there's no web browser installed
                    Toast.makeText(Profile.this, "No web browser installed", Toast.LENGTH_SHORT).show();
                }
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progress.setVisibility(View.VISIBLE);

                String url = "https://fabred.xyz/Fab_Programming_Quiz/data/delete.php?email=" +emails;
                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progress.setVisibility(View.GONE);
                        Toast.makeText(Profile.this, "Success", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Profile.this, Profile.class);
                        startActivity(intent);
                        new AlertDialog.Builder(Profile.this)
                                .setTitle("Delete")
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


                RequestQueue requestQueue = Volley.newRequestQueue(Profile.this);
                requestQueue.add(request);















                editor.putString("name", null);
                editor.putString("email", null);
                editor.putString("uni_name", null);
                editor.apply();


            }
        });
    }
}