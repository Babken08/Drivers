package com.example.android.driversapplication.Activitys;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.driversapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText emaill;
    private EditText passwordd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        emaill = (EditText) findViewById(R.id.et_email);
        passwordd = (EditText) findViewById(R.id.et_password);

        Button btnRegister = (Button) findViewById(R.id.btn_register);
        mAuth = FirebaseAuth.getInstance();
        userinform();
        btnRegister.setOnClickListener(this);

    }

    private void userinform() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                Intent i ;
                if (user != null) {

                    i = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(i);
                    finish();

                } else {

                }
                // ...
            }
        };
    }

    private void register(String email, final String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(SplashActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            Toast.makeText(SplashActivity.this, R.string.task_noisSuccessful,
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                            finish();
                        }
                    }
                });
   }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_register) {
            String email = emaill.getText().toString();
            String password = passwordd.getText().toString();
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(getApplicationContext(), R.string.enter_email, Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(getApplicationContext(), R.string.enter_password, Toast.LENGTH_SHORT).show();
                return;
            }

            if (password.length() < 6) {
                Toast.makeText(getApplicationContext(), R.string.password_invalid, Toast.LENGTH_SHORT).show();
                return;
            }

            register(email, password);
        }
    }
}
