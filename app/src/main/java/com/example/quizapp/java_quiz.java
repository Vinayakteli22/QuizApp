package com.example.quizapp;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



import java.util.List;

public class java_quiz extends AppCompatActivity implements View.OnClickListener {
    private TextView timerTextView;
    private CountDownTimer countDownTimer;
    Button ansA,ansB,ansC,ansD,Submit;
    TextView questiontext,totalquestion;
     public boolean quizSubmitted=true;
     public int score=0;
     public int totalQuestion=QuestionBank.questions.length,questionNumber=0;
     public int currentQuestionindes=0;
     String selectedAnser="";
    public  String passstatus="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_quiz);

        timerTextView = findViewById(R.id.timer);
        questiontext=findViewById(R.id.question);
        totalquestion=findViewById(R.id.totalques);
        ansA= (Button) findViewById(R.id.option1);
        ansB= (Button) findViewById(R.id.option2);
        ansC= (Button) findViewById(R.id.option3);
        ansD= (Button) findViewById(R.id.option4);
        Submit=(Button) findViewById(R.id.submit);
        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        Submit.setOnClickListener(this);

        if(currentQuestionindes==0){
            showQuizInfoDialog();
        }
        loadNewQuestion();


        changeStatusBarColor(getResources().getColor(R.color.black));

    }
    public void loadNewQuestion(){
        if(currentQuestionindes < totalQuestion){
            questiontext.setText(QuestionBank.questions[currentQuestionindes]);
            ansA.setText(QuestionBank.choices[currentQuestionindes][0]);
            ansB.setText(QuestionBank.choices[currentQuestionindes][1]);
            ansC.setText(QuestionBank.choices[currentQuestionindes][2]);
            ansD.setText(QuestionBank.choices[currentQuestionindes][3]);
            questionNumber++;
            totalquestion.setText("Questions: "+questionNumber+"/ "+totalQuestion);

        } else {
            finishQuiz();
        }
    }

    public void finishQuiz(){
        if(score>totalQuestion*0.60){
            passstatus="Pass";
        }else{
            passstatus="Fail";
        }
    }

    // Alert box
    private void showQuizInfoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.dialog_quiz_info, null);

        builder.setView(dialogView);

        builder.setTitle("Java Quiz");

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

    // Method to start the quiz timer
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
                    //int score = calculateScore();
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


    // Updated method to display the result with the score directly
    private void showResultDialogWithScore() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Java Quiz ")
                .setMessage(passstatus + "\nYour Score: " + score + " out of "+totalQuestion)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle OK button click if needed
                        dialog.dismiss();
                        finish();
                        Toast.makeText(java_quiz.this, "Thank You for completing the Quiz ", Toast.LENGTH_SHORT).show();
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

        if (clickButton.getId() == R.id.submit) {
            if (selectedAnser.equals(QuestionBank.correctAnswer[currentQuestionindes])) {
                score++;
            }

            if (currentQuestionindes < totalQuestion - 1) {
                // If there are more questions, load the next question
                currentQuestionindes++;
                loadNewQuestion();
            } else {
                // If it's the last question, finish the quiz and show the result
                finishQuiz();
                showResultDialogWithScore();
            }
        } else {
            // Choice button is clicked
            selectedAnser = clickButton.getText().toString();
            clickButton.setBackgroundColor(Color.MAGENTA);
        }
    }
    void restartQuiz(){
        score=0;
        currentQuestionindes=0;
        loadNewQuestion();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Java Quiz")
                .setMessage("Do You Want to End the Quiz..")
                .setPositiveButton("OK", (dialog, which) -> {
                    // Handle OK button click if needed
                    dialog.dismiss();
                    finish();
                    Toast.makeText(java_quiz.this, "Thank You for completing the Quiz ", Toast.LENGTH_SHORT).show();
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
