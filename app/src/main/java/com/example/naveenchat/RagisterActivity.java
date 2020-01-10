package com.example.naveenchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class RagisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static final String TAG = "RagisterActivity";
    private Button mragister;
    private TextInputLayout userNameTextinput, emailTextInput, passwordTextInput;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragister);
        mAuth = FirebaseAuth.getInstance();

        toolbar = findViewById(R.id.login_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Register User");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mragister = findViewById(R.id.login);
        userNameTextinput = findViewById(R.id.username);
        emailTextInput = findViewById(R.id.email_login);
        passwordTextInput = findViewById(R.id.password_login);

        mragister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registeruser(Objects.requireNonNull(userNameTextinput.getEditText()).getText().toString(),
                        Objects.requireNonNull(emailTextInput.getEditText()).getText().toString().trim(),
                        Objects.requireNonNull(passwordTextInput.getEditText()).getText().toString());
            }
        });
    }

    private void registeruser(String username, String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent intent = new Intent(RagisterActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                            // Sign in success, update UI with the signed-in user's information
                           // Log.d(TAG, "createUserWithEmail:success");
                           // FirebaseUser user = mAuth.getCurrentUser();
                            // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RagisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            // updateUI(null);
                        }

                        // ...
                    }
                });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
