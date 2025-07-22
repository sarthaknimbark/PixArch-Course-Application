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

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity {
    FirebaseAuth mAuth;
    GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mAuth = FirebaseAuth.getInstance();
        ImageView iv1 = findViewById(R.id.siiv1);
        TextView t1 = findViewById(R.id.sitv1);
        TextView t2 = findViewById(R.id.sitv2);
        EditText et1 = findViewById(R.id.siet1);
        TextView t3 = findViewById(R.id.sitv3);
        EditText et2 = findViewById(R.id.siet2);
        TextView t4 = findViewById(R.id.sitv4);
        Button b1 = findViewById(R.id.sibtn1);
        Button b2 = findViewById(R.id.sibtn2);
        ProgressBar progressBar = findViewById(R.id.sipp);
        TextView t5 = findViewById(R.id.sitv5);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInWithGoogle();
            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(Signin.this, Signup.class);
                startActivity(i3);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = et1.getText().toString();
                String Pass = et2.getText().toString();

                if (TextUtils.isEmpty(Email)) {
                    Toast.makeText(Signin.this, "Please enter Your Email", Toast.LENGTH_SHORT).show();
                    et1.setError("Email is Required");
                    et1.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                    Toast.makeText(Signin.this, "Please, Re-Enter Your Email_Id", Toast.LENGTH_SHORT).show();
                    et1.setError("Valid Email Required");
                    et1.requestFocus();
                } else if (TextUtils.isEmpty(Pass)) {
                    Toast.makeText(Signin.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    et2.setError("Please Enter your Password");
                    et2.requestFocus();
                } else if (et2.length() < 8) {
                    Toast.makeText(Signin.this, "Password should contain 8 Elements", Toast.LENGTH_SHORT).show();
                    et2.setError("Password is too weak");
                    et2.requestFocus();
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    loginUser(Email, Pass);
                }
            }
        });
    }

    private void signInWithGoogle() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Google Sign-In failed ", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void navigateToSecondActivity() {
        Intent i5 = new Intent(Signin.this, Course.class);
        startActivity(i5);
        finish();
    }

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        ProgressBar progressBar = findViewById(R.id.sipp);
                        progressBar.setVisibility(View.GONE);

                        if (task.isSuccessful()) {
                            Toast.makeText(Signin.this, "You are Logged in now", Toast.LENGTH_SHORT).show();
                            navigateToSecondActivity();
                        } else {
                            Toast.makeText(Signin.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
