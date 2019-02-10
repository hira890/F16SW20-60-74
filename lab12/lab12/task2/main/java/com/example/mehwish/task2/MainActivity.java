package com.example.mehwish.task2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Geocoder geocoder;
    Double wayLatitude = 0.0, wayLongitude = 0.0 ;
    int locationRequestCode = 1000;
    FusedLocationProviderClient mFusedLocationClient;
    TextView txtLocation;
    LocationRequest locationRequest;
    LocationCallback locationCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLocation = findViewById(R.id.txtLocation);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(10000);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        return;
        }
        locationCallback = new LocationCallback() {

            @Override
            public void onLocationResult(LocationResult locationResult) {
                if(locationResult == null) { return; }
                for (Location location : locationResult.getLocations()) {
                    if(location!=null) {
                        wayLatitude.toString(location.getLatitude());
                        wayLongitude.toString(location.getLongitude());
                       // txtLocation.setText(String.format(Locale.US , "%s -- %s", wayLatitude, wayLongitude));
                        txtLocation.setText("Lat"+location.getLatitude()+"Lon"+location.getLongitude());
                        Toast.makeText(MainActivity.this, "Updated Location", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };

        geocoder = new Geocoder(this, Locale.getDefault());
        try {
                   List<Address> addresses = geocoder.getFromLocation(wayLatitude, wayLongitude,1);
                    for(int i = 0; i < addresses.size(); i++) {
                        String countryName = addresses.get(i).getCountryName();
                        String adminArea = addresses.get(i).getAdminArea();
                        String postalCode = addresses.get(i).getFeatureName();

                        txtLocation.setText(countryName + ", " + adminArea + ", " + postalCode);
                    }
                } catch (IOException e) {
                   e.printStackTrace();
                }

    }
}