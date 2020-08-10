package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.AsyncClasses.Async0;
import com.example.myapplication.AsyncClasses.AsyncTaskCompleteListener;
import com.example.myapplication.AsyncClasses.BackgroundTask;
import com.example.myapplication.AsyncClasses.BaseClass;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity implements AsyncTaskCompleteListener<Object> {

    public TextView tv0;
    public Button button0,gotobutton0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        gotobutton0 = findViewById(R.id.gotobutton0);
        tv0 = findViewById(R.id.textView0);
        final Async0 async0 = new Async0(this);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                async0.execute("Task Completed");
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
    public void onTaskComplete(Object result) {
        tv0.setText(result.toString());
        button0.setText("Asynctask Completed");
        button0.setClickable(false);
    }
}