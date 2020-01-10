package com.example.naveenchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private Button mragister,login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mragister = findViewById(R.id.button);
        login_button = findViewById(R.id.login_button);
        mragister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mRagisterIntent = new Intent(StartActivity.this,RagisterActivity.class);
                startActivity(mRagisterIntent);
            }
        });
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mRagisterIntent = new Intent(StartActivity.this,LoginActivity.class);
                startActivity(mRagisterIntent);
            }
        });
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}
