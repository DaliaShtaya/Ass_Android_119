package com.example.ass_android_119;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
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
    private int quizSco;

    // Sample array of questions (replace with your actual data)
    private String[] question_Quiz = {
            "What is the chemical symbol for Hydrogen?",
            "What is the chemical symbol for Helium?",
            "What is the chemical symbol for Boron?"
    };

    private String[][] options = {
            {"H", "He", "B"},
            {"He", "N", "O"},
            {"Au", "B", "Cu"}
    };

    private String[] correct_Answer = {"H", "He", "B"};

    private int current_Index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView = findViewById(R.id.textview);
          Button1 = findViewById(R.id.button1);
        Button2  = findViewById(R.id.button2);
        Button3 = findViewById(R.id.button3);

        // SharedPreferences
        sharedPreferences = getSharedPreferences("QuizPreferences", Context.MODE_PRIVATE);
        quizSco = sharedPreferences.getInt("quizScore", 0);

        displayQuestion(current_Index);

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(Button1.getText().toString());
            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(Button2.getText().toString());
            }
        });

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(Button3.getText().toString());
            }
        });
    }

    private void displayQuestion(int index) {
        TextView.setText(question_Quiz[index]);
        Button1.setText(options[index][0]);
        Button2.setText(options[index][1]);
        Button3.setText(options[index][2]);
    }

    private void checkAnswer(String selectedOption) {
        if (selectedOption.equals(correct_Answer[current_Index])) {
            Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show();
            quizSco++; // Increment score for correct answer
        } else {
            Toast.makeText(this, "Incorrect Answer!", Toast.LENGTH_SHORT).show();
        }

        current_Index++;
        if (current_Index < question_Quiz.length) {
            displayQuestion(current_Index);
        } else {
            // Quiz Completed
            Toast.makeText(this, "Quiz finished Score: " + quizSco, Toast.LENGTH_SHORT).show();
            // Save quiz score to SharedPreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("quizScore", quizSco);
            editor.apply();
            finish();
        }
    }
}
