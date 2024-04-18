package com.example.ass_android_119;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private TextView TextView;
    private Button Button1;
    private Button Button2;
    private Button Button3;


    private String[] Exam_qu = {
            "What is the chemical symbol for Hydrogen?",
            "What is the chemical symbol for Helium?",
            "What is the chemical symbol for Boron?"
    };

    private String[][] option_answer = {
            {"H", "He", "O"},
            {"He", "N", "O"},
            {"Au", "B", "Cu"}
    };

    private String[]  Answers = {"H", "He", "B"};

    // Current question index
    private int current_Index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView= findViewById(R.id.textview);
        Button1 = findViewById(R.id.button1);
        Button2 = findViewById(R.id.button2);
        Button3 = findViewById(R.id.button3);

        displayQuestion(current_Index);

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        TextView.setText(Exam_qu[index]);
        Button1.setText(option_answer [index][0]);
        Button2.setText(option_answer [index][1]);
        Button3.setText(option_answer [index][2]);
    }

    private void checkAnswer(String selectedOption) {
        if (selectedOption.equals(Answers[current_Index])) {
            Toast.makeText(this, "Correct Answer!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Incorrect Answer!", Toast.LENGTH_LONG).show();
        }

        current_Index++;
        if (current_Index < Exam_qu.length) {
            displayQuestion(current_Index);
        } else {
            Toast.makeText(this, "Quiz Completed and finish!!!!!", Toast.LENGTH_LONG).show();
            finish();         }
    }
}