package com.example.pixarch.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pixarch.R;

public class sketchup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sketchup);
        Intent ic2 = getIntent();

        Button b1 = findViewById(R.id.skbtn1);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(sketchup.this, "Thank You For Buying Our Course", Toast.LENGTH_SHORT).show();
            }
        });
    }
}