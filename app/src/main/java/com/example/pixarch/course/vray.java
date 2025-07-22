package com.example.pixarch.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pixarch.R;

public class vray extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vray);
        Intent ic5 = getIntent();
        Button b = findViewById(R.id.vbtn1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(vray.this, "Thank You For Buying Our Course", Toast.LENGTH_SHORT).show();
            }
        });
    }
}