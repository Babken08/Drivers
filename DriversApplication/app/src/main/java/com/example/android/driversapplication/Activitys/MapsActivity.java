package com.example.android.driversapplication.Activitys;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.android.driversapplication.R;
import com.example.android.driversapplication.Service.GPSTracker;
import com.example.android.driversapplication.Service.LocationService;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.firebase.database.DatabaseReference;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnPoiClickListener {

    private GoogleMap mMap;
    private DatabaseReference mLatRef;
    private DatabaseReference mLngRef;
    private BroadcastReceiver mBroadcastReceiver;
    private double currentLat;
    private double currentLng;
    private Location mLocation;
    private Marker currentMarker;
    private boolean isFirstLocationDetection;
    private Location locationUser;
    private SharedPreferences shared;
    private Intent serviceIntent;
    private LatLng latLngUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        serviceIntent = new Intent(this, LocationService.class);
        startService(serviceIntent);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // starService();
        // Add a marker in Sydney, Australia, and move the camera.
//        LatLng sydney = new LatLng(lat, lng);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        GPSTracker gpsTracker = new GPSTracker(getApplicationContext());
        Location mLocation = gpsTracker.getLocation();
                    double mLatitude = mLocation.getLatitude();
            double mLongitude = mLocation.getLongitude();

            LatLng myLocation = new LatLng(mLatitude, mLongitude);
        mMap.setMyLocationEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 15));
       // firstLocation();
    }

//    public void firstLocation() {
//        GPSTracker gpsTracker = new GPSTracker(getApplicationContext());
//        Location mLocation = gpsTracker.getLocation();
//
//        if(mLocation == null) {
//            Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(i);
//        } else {
//            double mLatitude = mLocation.getLatitude();
//            double mLongitude = mLocation.getLongitude();
//
//            LatLng myLocation = new LatLng(mLatitude, mLongitude);
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
//            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 15));
//        }
//    }
//
//    private void listenLocationChanges() {
//        if (mBroadcastReceiver == null) {
//            mBroadcastReceiver = new BroadcastReceiver() {
//                @Override
//                public void onReceive(Context context, Intent intent) {
//                    if (mMap != null) mMap.clear();
//                    currentLat = (double) intent.getExtras().get("lat");
//                    currentLng = (double) intent.getExtras().get("lng");
//                    mLocation = (Location) intent.getExtras().get("mLocation");
//                    if (locationUser.getLatitude() != 0 && locationUser.getLongitude() != 0) {
//                        if (locationUser.distanceTo(mLocation) <= 50) {
//                            //shared.edit().remove("location").apply();
//                        }
//                    }
//                    addCurrentMarker(currentLat, currentLng);
//                }
//
//            };
//        }
//        registerReceiver(mBroadcastReceiver, new IntentFilter("LOCATION_UPDATE"));
//    }


    @Override
    public void onPoiClick(PointOfInterest pointOfInterest) {

    }
}
