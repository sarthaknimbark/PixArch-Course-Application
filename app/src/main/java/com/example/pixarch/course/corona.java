package com.example.pixarch.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pixarch.R;

public class corona extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corona);
        Intent ic6 = getIntent();
        Button b = findViewById(R.id.cbtn1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(corona.this, "Thank You For Buying Our Course", Toast.LENGTH_SHORT).show();
            }
        });
    }
}