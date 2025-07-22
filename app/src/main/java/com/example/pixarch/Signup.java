package com.example.pixarch;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Intent i = getIntent();
        Intent i3 = getIntent();
        ImageView iv1 = findViewById(R.id.suiv1);
        TextView t1 = findViewById(R.id.sutv1);
        TextView t2 = findViewById(R.id.sutv2);
        EditText et1 = findViewById(R.id.suet1);
        TextView t3 = findViewById(R.id.sutv3);
        EditText et2 = findViewById(R.id.suet2);
        TextView t4 = findViewById(R.id.sutv4);
        EditText et3 = findViewById(R.id.suet3);
        Button b = findViewById(R.id.subtn);
        ProgressBar progressBar = findViewById(R.id.supp);
        TextView t5 = findViewById(R.id.sutv5);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String username, Email, Password;
                username = String.valueOf(et1.getText());
                Email = String.valueOf(et2.getText());
                Password = String.valueOf(et3.getText());

                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(Signup.this, "Enter Username", Toast.LENGTH_SHORT).show();
                    et1.setError("User Name is Required");
                    et1.requestFocus();
                    // return;
                }

                else if (TextUtils.isEmpty(Email)) {
                    Toast.makeText(Signup.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    et2.setError("Email is Required");
                    et2.requestFocus();
                    // return;

                } else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                    Toast.makeText(Signup.this, "Please, Re-Enter Your Email_Id", Toast.LENGTH_SHORT).show();
                    et2.setError("Valid email Required");
                    et2.requestFocus();

                } else if (TextUtils.isEmpty(Password)) {
                    Toast.makeText(Signup.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    et3.setError("Please Enter your Password");
                    et3.requestFocus();
                    // return;
                } else if (et3.length() < 8) {
                    Toast.makeText(Signup.this, "Password should be contain 8 Element", Toast.LENGTH_SHORT).show();
                    et3.setError("Password is too weak");
                    et3.requestFocus();
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    registerUser(username,Email,Password);
                }

            }

            private void registerUser(String username, String Email, String Password) {
                FirebaseAuth auth = FirebaseAuth.getInstance();
                Task<AuthResult> authResultTask = auth.createUserWithEmailAndPassword(Email,Password)
                        .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {
                                    Toast.makeText(Signup.this, "User Account Created Successfully", Toast.LENGTH_SHORT).show();
                                    Intent i2 = new Intent(Signup.this, Course.class);
                                    i2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                                            | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(i2);
                                    finish();
                                }
                            }
                        });
            }
        });


        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Signup.this,
                        Signin.class);
                startActivity(i1);
            }
        });

    }
}