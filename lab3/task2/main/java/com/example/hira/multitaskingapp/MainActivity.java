package com.example.hira.multitaskingapp;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name;
    Button call, camera, contact, browser, calllog, gallery, dialpad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editText);
        call = findViewById(R.id.button);
        camera = findViewById(R.id.button2);
        browser = findViewById(R.id.button3);
        calllog = findViewById(R.id.button4);
        gallery = findViewById(R.id.button5);
        contact = findViewById(R.id.button6);
        dialpad = findViewById(R.id.button7);
        call.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {
                String number = name.getText().toString();
                Intent callintent = new Intent(Intent.ACTION_CALL);
                callintent.setData(Uri.parse("Tel:" + number));
                startActivity(callintent);
            }
        });

    }

    public void camera(View view) {
        Intent camintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(camintent);
    }

    public void bowser(View view) {
        Intent webintent = new Intent(Intent.ACTION_VIEW);
        webintent.setData(Uri.parse(name.getText().toString()));
        startActivity(webintent);
    }

    public void dialer(View view) {
        Intent dialintent = new Intent(Intent.ACTION_DIAL);
        startActivity(dialintent);
        startActivity(dialintent);
    }

    public void gallery(View view) {
        Intent galintent = new Intent(Intent.ACTION_VIEW);
        galintent.setData(Uri.parse("content://media/external/images/media/"));
        startActivity(galintent);
    }

    public void contact(View view) {
        Intent conintent = new Intent(Intent.ACTION_VIEW);
        conintent.setData(Uri.parse("content://contacts/people/"));
        startActivity(conintent);
    }
    public void calllog(View view){
        Intent calllog=new Intent(Intent.ACTION_VIEW);
        calllog.setData(Uri.parse("content://call_log/calls/1"));
        startActivity(calllog);
    }
}