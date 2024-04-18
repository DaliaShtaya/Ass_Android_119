package com.example.ass_android_119;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class QuizActivity extends AppCompatActivity {

    private TextView TextView;
    private Button Button1;
    private Button Button2;
    private Button Button3;

    private SharedPreferences sharedPreferences;
    private int quiz_Score;

    private int current_Index = 0;

    private String[] questions = {"What is the chemical symbol for Hydrogen?",
            "What is the chemical symbol for Helium?",
            "What is the chemical symbol for Boron?"};
    private String[][] options_Select = {{"H", "He", "O"},
            {"C", "He", "O"},
            {"Au", "Ag", "B"}};
    private String[] correctAnswers = {"H", "He", "B"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView = findViewById(R.id.textview);
        Button1 = findViewById(R.id.button1);
        Button2 = findViewById(R.id.button2);
        Button3 = findViewById(R.id.button3);

        sharedPreferences = getSharedPreferences("QuizPreferences", Context.MODE_PRIVATE);

        if (savedInstanceState != null) {
            current_Index = savedInstanceState.getInt("currentQuestionIndex", 0);
            quiz_Score = savedInstanceState.getInt("quizScore", 0);
        }

        displayQuestion(current_Index);

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(Button1.getText().toString());
            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(Button2.getText().toString());
            }
        });

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(Button3.getText().toString());
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentQuestionIndex", current_Index);
        outState.putInt("quizScore", quiz_Score);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Any operations to be done when the activity is resumed
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Any operations to be done when the activity is paused
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Any cleanup operations to be done when the activity is destroyed
    }

    private void displayQuestion(int index) {
        TextView.setText(questions[index]);
        Button1.setText(options_Select[index][0]);
        Button2.setText(options_Select[index][1]);
        Button3.setText(options_Select[index][2]);
    }

    private void checkAnswer(String selectedOption) {
        if (selectedOption.equals(correctAnswers[current_Index])) {
            Toast.makeText(this, "Correct Answer", Toast.LENGTH_LONG).show();
            quiz_Score++;
        } else {
            Toast.makeText(this, "Incorrect Answer!", Toast.LENGTH_LONG).show();
        }

        current_Index++;
        if (current_Index < questions.length) {
            displayQuestion(current_Index);
        } else {
            Toast.makeText(this, "Quiz Completed! Score: " + quiz_Score, Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("quizScore", quiz_Score);
            editor.apply();
            finish();
        }
    }
}
