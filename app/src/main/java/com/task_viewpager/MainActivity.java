package com.task_viewpager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button simpleActivityButton, scrollableActivityButton, iconTextButton, IconActivityButton, customActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleActivityButton = findViewById(R.id.button1);                       // Moving to SimpleActivity
        scrollableActivityButton = findViewById(R.id.button2);                  //  Moving to ScrollableActivity
        iconTextButton = findViewById(R.id.button3);                            // Moving to IconTextActivity
        IconActivityButton = findViewById(R.id.button4);                        // Moving to IconActivity
        customActivityButton = findViewById(R.id.button5);                      // Moving to CustomActivity

        simpleActivityButton.setOnClickListener(this);
        scrollableActivityButton.setOnClickListener(this);
        iconTextButton.setOnClickListener(this);
        IconActivityButton.setOnClickListener(this);
        customActivityButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int view = v.getId();
        switch (view) {

            case R.id.button1:
                Intent i = new Intent(MainActivity.this, SimpleActivity.class);
                startActivity(i);
                break;


            case R.id.button2:
                Intent intent = new Intent(MainActivity.this, ScrollableActivity.class);
                startActivity(intent);
                break;

            case R.id.button3:
                Intent intent1 = new Intent(MainActivity.this, IconTextActivity.class);
                startActivity(intent1);
                break;

            case R.id.button4:
                Intent intent2 = new Intent(MainActivity.this, IconActivity.class);
                startActivity(intent2);
                break;

            case R.id.button5:
                Intent in = new Intent(MainActivity.this, CustomActivity.class);
                startActivity(in);
                break;

        }
    }
}
