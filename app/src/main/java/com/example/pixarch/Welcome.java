package com.example.pixarch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView t1 = findViewById(R.id.weltv1);
        TextView t2 = findViewById(R.id.weltv2);
        Button b1 = findViewById(R.id.welbtn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Welcome.this,
                        Signup.class);
                startActivity(i);
            }
        });
    }
}