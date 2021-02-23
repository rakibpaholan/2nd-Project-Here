package com.example.a2ndproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class Splash_Screen extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progresses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        progressBar = (ProgressBar)findViewById(R.id.progressBar_id);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                goForwork();
            }
        });
        thread.start();
    }

    public void doWork(){
        for (progresses=0; progresses<=100; progresses= progresses+1){
            try {
                Thread.sleep(20);
                progressBar.setProgress(progresses);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void goForwork(){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
}