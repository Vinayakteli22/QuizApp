package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;






public class c_quiz extends AppCompatActivity implements View.OnClickListener {
    private TextView timerTextView,questionTextView,totalquestiontextView;
    private CountDownTimer countDownTimer;
    private boolean quizSubmitted = false;
    Button ansA,ansB,ansC,ansD,Submit;
    String passstatus="";
    String selectedAnser="";
    int score,currentquestionindex,questionnumber=0;
            int totalquestion=QuestionBank.C_question.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cquiz);
        timerTextView=findViewById(R.id.ctimer);
        showQuizInfoDialog();
        questionTextView=findViewById(R.id.C_question);
        totalquestiontextView=findViewById(R.id.totalques);
        ansA=(Button) findViewById(R.id.C_option1);
        ansB=(Button) findViewById(R.id.C_option2);
        ansC=(Button) findViewById(R.id.C_option3);
        ansD=(Button) findViewById(R.id.C_option4);
        Submit=findViewById(R.id.C_submit);
        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        Submit.setOnClickListener(this);
        if(currentquestionindex==0){
            showQuizInfoDialog();
        }
        C_loadNewQuestion();
        changeStatusBarColor(getResources().getColor(R.color.black));

    }
    public void C_loadNewQuestion(){
        if(currentquestionindex < totalquestion){
            questionTextView.setText(QuestionBank.C_question[currentquestionindex]);
            ansA.setText(QuestionBank.C_choices[currentquestionindex][0]);
            ansB.setText(QuestionBank.C_choices[currentquestionindex][1]);
            ansC.setText(QuestionBank.C_choices[currentquestionindex][2]);
            ansD.setText(QuestionBank.C_choices[currentquestionindex][3]);
            questionnumber++;
            totalquestiontextView.setText("Questions: "+questionnumber+"/ "+totalquestion);

        } else {
            finishQuiz();
        }
    }
    public void finishQuiz(){
        if(score>totalquestion*0.60){
            passstatus="Pass";
        }else{
            passstatus="Fail";
        }
    }
    private void showQuizInfoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.dialog_quiz_info, null);

        builder.setView(dialogView);

        builder.setTitle("C Programming Quiz");

        builder.setPositiveButton("Start", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                startQuiz();
            }
        });

        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void startQuiz() {
        long totalTimeMillis = 10 * 60 * 1000;
        long intervalMillis = 1000;
        countDownTimer = new CountDownTimer(totalTimeMillis, intervalMillis) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Update the timerTextView with the remaining time
                updateTimerText(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                timerTextView.setText("Time's up!");
                if (!quizSubmitted) {
                                      quizSubmitted = true;
                }
            }
        };
        countDownTimer.start();
    }
    private void updateTimerText(long millisUntilFinished) {
        int minutes = (int) (millisUntilFinished / 1000) / 60;
        int seconds = (int) (millisUntilFinished / 1000) % 60;
        timerTextView.setText(String.format("%02d:%02d", minutes, seconds));
    }




    // Method to display the result in an AlertDialog
    private void showResultDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(" C Quiz")
                .setMessage(passstatus + "\nYour Score: " + score + " out of "+totalquestion)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle OK button click if needed
                        dialog.dismiss();
                        finish();
                        Toast.makeText(c_quiz.this, "Thank You for completing the Quiz ", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton("Restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                restartQuiz();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Stop the countdown timer to avoid memory leaks
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override
    public void onClick(View view) {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickButton = (Button) view;

        if (clickButton.getId() == R.id.C_submit) {
            if (selectedAnser.equals(QuestionBank.C_answer[currentquestionindex])) {
                score++;
            }

            if (currentquestionindex < totalquestion - 1) {
                // If there are more questions, load the next question
                currentquestionindex++;
                C_loadNewQuestion();
            } else {
                // If it's the last question, finish the quiz and show the result
                finishQuiz();
                showResultDialog();            }
        } else {
            // Choice button is clicked
            selectedAnser = clickButton.getText().toString();
            clickButton.setBackgroundColor(Color.MAGENTA);
        }
    }

    void restartQuiz(){
        score=0;
        currentquestionindex=0;
        C_loadNewQuestion();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("C  Quiz")
                .setMessage("Do You Want to End the Quiz..")
                .setPositiveButton("OK", (dialog, which) -> {
                    // Handle OK button click if needed
                    dialog.dismiss();
                    finish();
                    Toast.makeText(c_quiz.this, "Thank You for completing the Quiz ", Toast.LENGTH_SHORT).show();
                });
        builder.setNegativeButton("Restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                restartQuiz();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void changeStatusBarColor(int color) {
        Window window = getWindow();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // For devices with Lollipop and above
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // For devices with KitKat to Lollipop
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            // Create a View with the desired color and height of the status bar
            View statusBarView = new View(this);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight());
            statusBarView.setBackgroundColor(color);

            // Add the View to the layout
            ViewGroup decorView = (ViewGroup) window.getDecorView();
            decorView.addView(statusBarView, params);
        }
    }

    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}