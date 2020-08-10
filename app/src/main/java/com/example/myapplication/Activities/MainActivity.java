package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.AsyncClasses.AsyncTaskCompleteListener;
import com.example.myapplication.AsyncClasses.BackgroundTask;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity implements AsyncTaskCompleteListener<String> {

    public TextView tv0;
    public Button button0,gotobutton0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        gotobutton0 = findViewById(R.id.gotobutton0);
        tv0 = findViewById(R.id.textView0);
        final BackgroundTask<String> backgroundTask = new BackgroundTask<>(this);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundTask.execute("Task Completed");
                button0.setText("Running Asynctask");
            }
        });

        gotobutton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),MainActivity2.class));
            }
        });
    }

    @Override
    public void onTaskComplete(String result) {
        tv0.setText(result);
        button0.setText("Asynctask Completed");
        button0.setClickable(false);
    }
}