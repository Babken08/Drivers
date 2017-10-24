package com.example.android.driversapplication.Service;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

/**
 * Created by Android on 24.10.2017.
 */

public class GPSTracker extends Service implements LocationListener{

    private final Context context;
    private boolean isGPSEnabled = false;
    private boolean isNetworkEnabled = false;

    Location mlocation;

    protected LocationManager mlocationManager;

    public GPSTracker() {

        context = getApplicationContext();
    }

    public GPSTracker(Context context) {
        this.context = context;
    }

    public Location getLocation() {
        try {
            mlocationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
            isGPSEnabled = mlocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            isNetworkEnabled = mlocationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {

                if (isGPSEnabled) {
                    if (mlocation == null) {
                        mlocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 0, this);
                        if (mlocationManager != null) {
                            mlocation = mlocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        }
                    }
                }

                if (mlocation == null) {
                    if (isNetworkEnabled) {
                        mlocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 120000, 0, this);
                        if (mlocationManager != null) {
                            mlocation = mlocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        }
                    }
                }
            }

        } catch (Exception ex) {

        }
        return mlocation;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
