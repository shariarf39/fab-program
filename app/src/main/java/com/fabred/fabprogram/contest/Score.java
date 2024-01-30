package com.fabred.fabprogram.contest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.fabred.fabprogram.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Score extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;

    // Data structure to store user details
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score2);

        recyclerView = findViewById(R.id.recycleview);
        progressBar = findViewById(R.id.progressBar);

        // Initialize RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(Score.this));

        // Initialize RequestQueue for Volley
        RequestQueue requestQueue = Volley.newRequestQueue(Score.this);

        // Show progress bar
        progressBar.setVisibility(View.VISIBLE);

        // Make a GET request to the server to fetch data
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://fabred.xyz/Fab_Programming_Quiz/data/list_show.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Hide progress bar after getting the response
                        progressBar.setVisibility(View.GONE);

                        for (int x = 0; x < response.length(); x++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(x);

                                // Extract data from JSON
                                String name = jsonObject.getString("name");
                                String uni_name = jsonObject.getString("uni_name");
                                String Score = jsonObject.getString("Score");


                                // Create a HashMap to store the data
                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("name", name);
                                hashMap.put("uni_name", uni_name);
                                hashMap.put("Score", Score);


                                // Add the HashMap to the ArrayList
                                arrayList.add(hashMap);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        // If data is available, set up the RecyclerView adapter
                        if (arrayList.size() > 0) {
                            MyAdapter myAdapter = new MyAdapter();
                            recyclerView.setAdapter(myAdapter);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle errors
                        Log.d("serverRes", error.toString());
                    }
                });

        // Add the request to the RequestQueue
        requestQueue.add(jsonArrayRequest);
    }

    // RecyclerView Adapter
    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        // ViewHolder class
        private class MyViewHolder extends RecyclerView.ViewHolder {
            TextView id, name, uni_name, score;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                id = itemView.findViewById(R.id.id);
                name = itemView.findViewById(R.id.name);
                uni_name = itemView.findViewById(R.id.uni_name);
                score = itemView.findViewById(R.id.score);
            }
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.score_item, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            // Bind data to the ViewHolder
            HashMap<String, String> data = arrayList.get(position);
            holder.id.setText(""+position+".");
            holder.name.setText(data.get("name"));
            holder.uni_name.setText(data.get("uni_name"));
            holder.score.setText(data.get("Score"));
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }
    }
}
