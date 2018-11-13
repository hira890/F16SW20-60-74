package com.asadcomputer.nida3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class secondactivity extends AppCompatActivity {

    EditText entremessage;
    Button submitt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        entremessage=findViewById(R.id.editText);
        submitt=findViewById(R.id.button);
    }
    public void showclick(View view){
        Intent in=new Intent(this, MainActivity.class);
        in.putExtra("entremessage",entremessage.getText().toString());
        startActivity(in);
    }
}
