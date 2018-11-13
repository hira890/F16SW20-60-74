package com.example.hira.labtask2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2,t3;
    ImageView img;
    Button b1,b2;
    int count=0;
String[] names=new String[]{
        "hira mustafa",
        "mehwish shaikh",
        "nida zafar"
};
    String[] rollno =new String[]{
            "f16sw20",
            "f16sw60",
            "f16sw74"
    };
    String[] email=new String[]{
            "hiraf.mustafa@gmail.com",
            "mehwishshaikh@gmail.com",
            "nidazafar@gmail.com"
    };
    int[]images=new int[]{
            R.drawable.hira,
            R.drawable.mish,
            R.drawable.nida

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        img=findViewById(R.id.i1);
        t1.setText(names[count]);
        t2.setText(rollno[count]);
        t3.setText(email[count]);
        img.setImageResource(images[count]);

    }
    public void next(View view) {
        if (count < 3) {
            count++;
            t1.setText(names[count]);
            t2.setText(rollno[count]);
            t3.setText(email[count]);
            img.setImageResource(images[count]);
        }
    }
    public void pevious(View view) {
        if (count > 0) {
            count--;
            t1.setText(names[count]);
            t2.setText(rollno[count]);
            t3.setText(email[count]);
            img.setImageResource(images[count]);
        }
    }
}