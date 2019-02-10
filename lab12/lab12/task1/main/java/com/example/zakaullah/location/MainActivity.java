package com.example.zakaullah.location;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button getLocationBtn;
    TextView textView;
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    Location mLastLocation;
    double latitude,longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLocationBtn = findViewById(R.id.getLocationBtn);
        textView = findViewById(R.id.textView);

        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION_PERMISSION);
        }
        else{
            Toast.makeText(getApplicationContext(),"location Already Granted",Toast.LENGTH_LONG).show();
        }
        FusedLocationProviderClient mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location!= null){
                    mLastLocation = location;
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                }

            }
        });

        mFusedLocationProviderClient.getLastLocation().addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Failes to get Location",Toast.LENGTH_LONG).show();
            }
        });

        getLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                try{
                    List<Address> addresses = geocoder.getFromLocation(latitude,longitude,REQUEST_LOCATION_PERMISSION);
                    for (int i = 0; i< addresses.size(); i++){
                        String countryName = addresses.get(i).getCountryName();
                        String adminarea = addresses.get(i).getAdminArea();
                        String postalcode = addresses.get(i).getFeatureName();

                        textView.setText(countryName+", "+adminarea+ ", "+postalcode);
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[],int[] grantResults){
        switch (requestCode){
            case REQUEST_LOCATION_PERMISSION:{
                if ((grantResults.length>0 ) && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    System.out.print("Permission Granted");
                }
                else{
                    System.out.print("Permission denied");
                }
            }
        }
    }

}
