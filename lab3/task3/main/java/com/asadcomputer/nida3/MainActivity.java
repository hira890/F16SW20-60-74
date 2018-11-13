package com.asadcomputer.nida3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView hello, message;
    Button getstart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello = findViewById(R.id.textView2);
        getstart = findViewById(R.id.button2);
        message = findViewById(R.id.textView);

        Intent i = getIntent();

        message.setText(i.getStringExtra("entremessage"));
    }

    public void showclick(View view) {
        Intent myintent = new Intent(MainActivity.this, secondactivity.class);
        startActivity(myintent);
    }
}