package com.asadcomputer.nida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name,email,password,date;
    TextView iam;
    RadioButton male,female;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.editText);
        email=findViewById(R.id.editText2);
        password=findViewById(R.id.editText3);
        name=findViewById(R.id. editText4);

        iam=findViewById(R.id.textView);

        male=findViewById(R.id.radioButton);
        female=findViewById(R.id.radioButton2);

        signup=findViewById(R.id.button);
    }
}
