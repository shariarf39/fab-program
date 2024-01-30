package com.fabred.fabprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuestionCollection extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView lblQuestion, p_position;
    RadioButton optionA;
    RadioButton optionB;
    RadioButton optionC;
    RadioButton optionD;
    Button confirm;
    String rightAnswer;
    String Answer;
    public static List<QuestionModule> question_list;
    int score;
    int wrong;
    int position=1;
    public static String SUBJECT_NAME = "";
    public static ArrayList<ArrayList<QuestionModule>> questionBank = new ArrayList<>();
    public static ArrayList<HashMap<String, String>> subjectList = new ArrayList<>();
    LinearLayout rootLay;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        rootLay = findViewById(R.id.rootLay);
        confirm = findViewById(R.id.confirm);
        lblQuestion = findViewById(R.id.lblPergunta);
        optionA = findViewById(R.id.opcaoA);
        optionB = findViewById(R.id.opcaoB);
        optionC = findViewById(R.id.opcaoC);
        optionD = findViewById(R.id.opcaoD);
        p_position = findViewById(R.id.p_position);
        score = 0;
        radioGroup = findViewById(R.id.radioGroup);


        loadQuestion();
        p_position.setText(String.valueOf(position)+"/"+question_list.size());




        sharedPreferences = getSharedPreferences("c_ans", Context.MODE_PRIVATE);
        editor= sharedPreferences.edit();

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        loadQuestion();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (rootLay != null)
            rootLay.startAnimation(AnimationUtils.loadAnimation(QuestionCollection.this, R.anim.middle_to_top));
    }


    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired
    private long mBackPressed;

    // When user click bakpress button this method is called
    @Override
    public void onBackPressed() {

        // When landing in home screen

        super.onBackPressed();
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        } else {

            startActivity(new Intent(QuestionCollection.this, MainActivity.class));
        }

        mBackPressed = System.currentTimeMillis();

    }

    private void loadQuestion() {
        //Toast.makeText(getApplicationContext(), "Total Questions: "+question_list.size(), Toast.LENGTH_SHORT).show();
        if (question_list.size() > 0) {
            QuestionModule q = question_list.remove(0);
            lblQuestion.setText(q.getQuestion());
            List<String> answers = q.getAnswers();

            optionA.setText(answers.get(0));
            optionB.setText(answers.get(1));
            optionC.setText(answers.get(2));
            optionD.setText(answers.get(3));
            rightAnswer = q.getRightAnswer();
        } else {
            Intent intent = new Intent(this, ScoreActivity.class);
            intent.putExtra("score", score);
            intent.putExtra("wrong", wrong);
            intent.putExtra("total", score+wrong);
            startActivity(intent);
            finish();
        }
    }

    public void loadAnswer(View view) {
        int op = radioGroup.getCheckedRadioButtonId();

        if (op == R.id.opcaoA) {
            Answer = "A";
        } else if (op == R.id.opcaoB) {
            Answer = "B";

        } else if (op == R.id.opcaoC) {
            Answer = "C";

        } else if (op == R.id.opcaoD) {
            Answer = "D";

        } else {
            return;
        }


        radioGroup.clearCheck();

        this.startActivity(isRightOrWrong(Answer));

    }

    private Intent isRightOrWrong(String Answer) {
        Intent screen;
        int j =0;


        if (Answer.equals(rightAnswer)) {
            this.score += 1;
            this.position += 1;
            p_position.setText(String.valueOf(position)+"/"+question_list.size());

            screen = new Intent(this, RightActivity.class);



        } else {


            editor.putString("ans",rightAnswer);
            editor.commit();

            this.position += 1;
            p_position.setText(String.valueOf(position)+"/"+question_list.size());

            this.wrong+=1;



            String correctOptionText = "";

            if (rightAnswer.equals("A")) {
                correctOptionText = optionA.getText().toString();
            } else if (rightAnswer.equals("B")) {
                correctOptionText = optionB.getText().toString();
            } else if (rightAnswer.equals("C")) {
                correctOptionText = optionC.getText().toString();
            } else if (rightAnswer.equals("D")) {
                correctOptionText = optionD.getText().toString();
            }
            j++;

            editor.putString("ans",correctOptionText);
            editor.putString("option","");
            editor.putString("wrong", String.valueOf(j));
            editor.commit();

            Toast.makeText(this,  correctOptionText, Toast.LENGTH_SHORT).show();


            screen = new Intent(this, WrongActivity.class);
        }

        return screen;
    }


    //===============================================================================================


    //====================================================================
    //====================================================================
    public static ArrayList<QuestionModule> questions;

    public static void createQuestionBank(Context context) {
        QuestionCollection.subjectList = new ArrayList<>();
        QuestionCollection.questionBank = new ArrayList<>();


        //------------- Subject 1


        //////////////from server


        RequestQueue queue = Volley.newRequestQueue(context);










        String url_contest = "https://fabred.xyz/Fab_Programming_Quiz/contest.json";

        StringRequest stringRequest_contest = new StringRequest(Request.Method.GET, url_contest,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("response", response);

                        try {
                            if (response.startsWith("[")) {

                                JSONArray jsonArray = new JSONArray(response);

                                questions = new ArrayList() {
                                    {

                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                                            // Extract question details
                                            String questionText = jsonObject.getString("question");
                                            String correctOption = jsonObject.getString("rightans");
                                            String optionA = jsonObject.getString("option1");
                                            String optionB = jsonObject.getString("option2");
                                            String optionC = jsonObject.getString("option3");
                                            String optionD = jsonObject.getString("option4");


                                            add(new QuestionModule(questionText, correctOption, optionA, optionB, optionC, optionD));

                                        }

                                    }
                                };


                                ((MainActivity) context).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        QuestionModule.createQuestionsForSubject("Contest", R.drawable.contest, questions);

                                    }
                                });
                            } else {
                                Log.e("error", "Invalid JSON format in the response");
                                // Handle the case when the response is not a valid JSON array
                            }
                        } catch (JSONException e) {
                            Log.e("error", "JSONException: " + e.getMessage());
                            e.printStackTrace();
                            // Handle JSON parsing error
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", "VolleyError: " + error.getMessage());

            }
        });


        queue.add(stringRequest_contest);










    //C Quiz


        String url = "https://fabred.xyz/Fab_Programming_Quiz/c.json";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("response", response);

                        try {
                            if (response.startsWith("[")) {

                                JSONArray jsonArray = new JSONArray(response);

                                questions = new ArrayList() {
                                    {
                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                                            // Extract question details
                                            String questionText = jsonObject.getString("question");
                                            String correctOption = jsonObject.getString("rightans");
                                            String optionA = jsonObject.getString("option1");
                                            String optionB = jsonObject.getString("option2");
                                            String optionC = jsonObject.getString("option3");
                                            String optionD = jsonObject.getString("option4");


                                            add(new QuestionModule(questionText, correctOption, optionA, optionB, optionC, optionD));

                                        }
                                    }
                                };


                                ((MainActivity) context).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        QuestionModule.createQuestionsForSubject("C Quiz", R.drawable.category_icon1, questions);

                                    }
                                });
                            } else {
                                Log.e("error", "Invalid JSON format in the response");
                                // Handle the case when the response is not a valid JSON array
                            }
                        } catch (JSONException e) {
                            Log.e("error", "JSONException: " + e.getMessage());
                            e.printStackTrace();
                            // Handle JSON parsing error
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", "VolleyError: " + error.getMessage());
                // Handle errors, e.g., display a message to the user or log the error
            }
        });


        queue.add(stringRequest);


        /// C++ Quiz

        String url_cpp = "https://fabred.xyz/Fab_Programming_Quiz/cpp.json";

        StringRequest stringRequest_cpp = new StringRequest(Request.Method.GET, url_cpp,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("response", response);

                        try {
                            if (response.startsWith("[")) {

                                JSONArray jsonArray = new JSONArray(response);

                                questions = new ArrayList() {
                                    {
                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                                            // Extract question details
                                            String questionText = jsonObject.getString("question");
                                            String correctOption = jsonObject.getString("rightans");
                                            String optionA = jsonObject.getString("option1");
                                            String optionB = jsonObject.getString("option2");
                                            String optionC = jsonObject.getString("option3");
                                            String optionD = jsonObject.getString("option4");


                                            add(new QuestionModule(questionText, correctOption, optionA, optionB, optionC, optionD));

                                        }
                                    }
                                };


                                ((MainActivity) context).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        QuestionModule.createQuestionsForSubject("C++ Quiz", R.drawable.category_icon2, questions);

                                    }
                                });
                            } else {
                                Log.e("error", "Invalid JSON format in the response");
                                // Handle the case when the response is not a valid JSON array
                            }
                        } catch (JSONException e) {
                            Log.e("error", "JSONException: " + e.getMessage());
                            e.printStackTrace();
                            // Handle JSON parsing error
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", "VolleyError: " + error.getMessage());

            }
        });


        queue.add(stringRequest_cpp);


        //------------- Python


        String url_py = "https://fabred.xyz/Fab_Programming_Quiz/py.json";

        StringRequest stringRequest_py = new StringRequest(Request.Method.GET, url_py,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("response", response);

                        try {
                            if (response.startsWith("[")) {

                                JSONArray jsonArray = new JSONArray(response);

                                questions = new ArrayList() {
                                    {
                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                                            // Extract question details
                                            String questionText = jsonObject.getString("question");
                                            String correctOption = jsonObject.getString("rightans");
                                            String optionA = jsonObject.getString("option1");
                                            String optionB = jsonObject.getString("option2");
                                            String optionC = jsonObject.getString("option3");
                                            String optionD = jsonObject.getString("option4");


                                            add(new QuestionModule(questionText, correctOption, optionA, optionB, optionC, optionD));

                                        }
                                    }
                                };


                                ((MainActivity) context).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        QuestionModule.createQuestionsForSubject("Python Quiz", R.drawable.category_icon3, questions);

                                    }
                                });
                            } else {
                                Log.e("error", "Invalid JSON format in the response");
                                // Handle the case when the response is not a valid JSON array
                            }
                        } catch (JSONException e) {
                            Log.e("error", "JSONException: " + e.getMessage());
                            e.printStackTrace();
                            // Handle JSON parsing error
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", "VolleyError: " + error.getMessage());

            }
        });


        queue.add(stringRequest_py);

        //------------- Subject 3 JAVA


        String url_java = "https://fabred.xyz/Fab_Programming_Quiz/java.json";

        StringRequest stringRequest_java = new StringRequest(Request.Method.GET, url_java,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("response", response);

                        try {
                            if (response.startsWith("[")) {

                                JSONArray jsonArray = new JSONArray(response);

                                questions = new ArrayList() {
                                    {
                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                                            // Extract question details
                                            String questionText = jsonObject.getString("question");
                                            String correctOption = jsonObject.getString("rightans");
                                            String optionA = jsonObject.getString("option1");
                                            String optionB = jsonObject.getString("option2");
                                            String optionC = jsonObject.getString("option3");
                                            String optionD = jsonObject.getString("option4");


                                            add(new QuestionModule(questionText, correctOption, optionA, optionB, optionC, optionD));

                                        }
                                    }
                                };


                                ((MainActivity) context).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        QuestionModule.createQuestionsForSubject("Java Quiz", R.drawable.category_icon4, questions);

                                    }
                                });
                            } else {
                                Log.e("error", "Invalid JSON format in the response");
                                // Handle the case when the response is not a valid JSON array
                            }
                        } catch (JSONException e) {
                            Log.e("error", "JSONException: " + e.getMessage());
                            e.printStackTrace();
                            // Handle JSON parsing error
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", "VolleyError: " + error.getMessage());

            }
        });


        queue.add(stringRequest_java);

        //------------- Subject 4 HTML

        String url_html = "https://fabred.xyz/Fab_Programming_Quiz/html.json";

        StringRequest stringRequest_html = new StringRequest(Request.Method.GET, url_html,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("response", response);

                        try {
                            if (response.startsWith("[")) {

                                JSONArray jsonArray = new JSONArray(response);

                                questions = new ArrayList() {
                                    {
                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                                            // Extract question details
                                            String questionText = jsonObject.getString("question");
                                            String correctOption = jsonObject.getString("rightans");
                                            String optionA = jsonObject.getString("option1");
                                            String optionB = jsonObject.getString("option2");
                                            String optionC = jsonObject.getString("option3");
                                            String optionD = jsonObject.getString("option4");


                                            add(new QuestionModule(questionText, correctOption, optionA, optionB, optionC, optionD));

                                        }
                                    }
                                };


                                ((MainActivity) context).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        QuestionModule.createQuestionsForSubject("Html Quiz", R.drawable.category_icon5, questions);

                                    }
                                });
                            } else {
                                Log.e("error", "Invalid JSON format in the response");
                                // Handle the case when the response is not a valid JSON array
                            }
                        } catch (JSONException e) {
                            Log.e("error", "JSONException: " + e.getMessage());
                            e.printStackTrace();
                            // Handle JSON parsing error
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", "VolleyError: " + error.getMessage());

            }
        });


        queue.add(stringRequest_html);


        //------------- Subject 5 JAVA SCRIPT

        String url_js = "https://fabred.xyz/Fab_Programming_Quiz/js.json";

        StringRequest stringRequest_js = new StringRequest(Request.Method.GET, url_js,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("response", response);

                        try {
                            if (response.startsWith("[")) {

                                JSONArray jsonArray = new JSONArray(response);

                                questions = new ArrayList() {
                                    {
                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                                            // Extract question details
                                            String questionText = jsonObject.getString("question");
                                            String correctOption = jsonObject.getString("rightans");
                                            String optionA = jsonObject.getString("option1");
                                            String optionB = jsonObject.getString("option2");
                                            String optionC = jsonObject.getString("option3");
                                            String optionD = jsonObject.getString("option4");


                                            add(new QuestionModule(questionText, correctOption, optionA, optionB, optionC, optionD));

                                        }
                                    }
                                };


                                ((MainActivity) context).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        QuestionModule.createQuestionsForSubject("JavaScript Quiz", R.drawable.category_icon6, questions);


                                    }
                                });
                            } else {
                                Log.e("error", "Invalid JSON format in the response");
                                // Handle the case when the response is not a valid JSON array
                            }
                        } catch (JSONException e) {
                            Log.e("error", "JSONException: " + e.getMessage());
                            e.printStackTrace();
                            // Handle JSON parsing error
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", "VolleyError: " + error.getMessage());

            }
        });


        queue.add(stringRequest_js);


        //------------- Subject 6

        // Programming Contest

    }







}


