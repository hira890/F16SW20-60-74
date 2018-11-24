package com.asadcomputer.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView programmingList=findViewById(R.id.programminglist);
        programmingList.setLayoutManager(new LinearLayoutManager(this));
        String[] languages={"java", "javascript"};
        programmingList.setAdapter(new progrmmingAdapter(languages));


    }
}
