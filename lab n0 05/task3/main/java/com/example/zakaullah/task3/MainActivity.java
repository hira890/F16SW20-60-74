package com.example.zakaullah.task3;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {


    SensorManager sensorManager;
    Sensor sensor;
    ImageView imageView;
    int images[] = {R.drawable.one, R.drawable.two,R.drawable.three, R.drawable.four};
    int x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        imageView = findViewById(R.id.imageView);

        imageView.setImageResource(images[0]);


    }

    @Override
    protected void onStart() {
        super.onStart();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged (Sensor sensor, int accuracy){

    }

    @Override
    public void onSensorChanged (SensorEvent event){

//        if (event.values[0] > 0.5){
//
//            if (x>=4){
//                Toast toast = Toast.makeText(getApplicationContext(), "That's it!", Toast.LENGTH_SHORT);
//                toast.show();
//            }
//            else{
//                x++;
//                imageView.setImageResource(images[x]);
//            }
//
//        }
        //else if (event.values[0] > -0.5){}

        if (event.values[1] > 2){
            if (x>=4){
//                Toast toast = Toast.makeText(getApplicationContext(), "That's it!", Toast.LENGTH_SHORT);
//                toast.show();
            }
            else{
                x++;
                imageView.setImageResource(images[x]);
            }
        }
        else if (event.values[1] > -2){
            if (x<=0){
//                Toast toast = Toast.makeText(getApplicationContext(), "Can't go back further!", Toast.LENGTH_SHORT);
//                toast.show();
            }
            else{
                x--;
                imageView.setImageResource(images[x]);
            }

        }

//        if (event.values[2] > 0.5){
//            if (x>=4){
//                Toast toast = Toast.makeText(getApplicationContext(), "That's it!", Toast.LENGTH_SHORT);
//                toast.show();
//            }
//            else{
//                x++;
//                imageView.setImageResource(images[x]);
//            }
//        }
        //else if (event.values[2] > -0.5){}

    }

}
