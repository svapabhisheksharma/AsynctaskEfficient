package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.AsyncClasses.Async1;
import com.example.myapplication.AsyncClasses.AsyncTaskCompleteListener;
import com.example.myapplication.AsyncClasses.BackgroundTask;
import com.example.myapplication.R;

public class MainActivity2 extends AppCompatActivity implements AsyncTaskCompleteListener<Object> {

    public TextView tv1;
    public Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button1 = findViewById(R.id.button1);
        tv1 = findViewById(R.id.textView1);
        final Async1 async1 = new Async1(this);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                async1.execute(1212);
                button1.setText("Running Asynctask");
            }
        });
    }

    @Override
    public void onTaskComplete(Object result) {
        tv1.setText(result.toString());
        button1.setText("Asynctask Completed");
        button1.setClickable(false);
    }
}