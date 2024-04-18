package com.example.ass_android_119;

import android.os.Bundle;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    private Button explorebtn;
    private Button quiz_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        explorebtn = findViewById(R.id.explorebtn);
        quiz_btn = findViewById(R.id.quizbtn);

        // Set onClickListener for Explore Button
        explorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start ExploreActivity
                startActivity(new Intent(MainActivity.this, ExploreActivity.class));
            }
        });

        // Set onClickListener for Quiz Button
        quiz_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start QuizActivity
                startActivity(new Intent(MainActivity.this, QuizActivity.class));
            }
        });
    }
}