package com.asadcomputer.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView pp;

    EditText name,email,rollno,contactno;

    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pp=findViewById(R.id.textView);

        name=findViewById(R.id.editText);
        email=findViewById(R.id.editText2);
        rollno=findViewById(R.id.editText3);
        contactno=findViewById(R.id.editText4);

        ok=findViewById(R.id.button);
    }
}
