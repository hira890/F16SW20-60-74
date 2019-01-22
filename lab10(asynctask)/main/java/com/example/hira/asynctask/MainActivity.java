package com.example.hira.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ProgressBar pb ;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb=findViewById(R.id.progressBar);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            new downloader().execute();
            }
        });
    }
    class downloader extends AsyncTask<Void, Integer, Integer>{
@Override
protected void onPreExecute(){
    super.onPreExecute();
    pb.setMax(100);
}

@Override
protected void onProgressUpdate(Integer...Values){
super.onProgressUpdate(Values);
pb.setProgress(Values[0]);
}

        @Override
        protected Integer doInBackground(Void... voids) {

    for(int i=0;i<100;i++){
        publishProgress(i);
        try {
            Thread.sleep(100);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Toast.makeText(getApplicationContext(),"update completed !!",Toast.LENGTH_LONG).show();
        }
    }
}
