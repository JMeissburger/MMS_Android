package com.example.user.curiositybleproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.example.user.curiositybleproject.Interfaces.IGPSData;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.user.curiositybleproject.MainActivity.ceudruc;

/**
 * Created by user on 21/11/2016.
 */

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Handler mHandler = new Handler();
    private Handler mHandler2 = new Handler();
    private IGPSData myPositionGPSData;

    private Marker mPosition;
    MarkerOptions mPositionMarker = new MarkerOptions().title("My Position");
    MarkerOptions mPollutionMarker = new MarkerOptions().title("Level of pollution");

    Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            Location location = myPositionGPSData.getPosition();

            LatLng myPosition = new LatLng(location.getLatitude(), location.getLongitude());
//            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myPosition,10.0f));

            if (mMap != null) {

                if (mPosition != null) {
                    mPosition.remove();
                }

                mPositionMarker.position(myPosition);
                mPositionMarker.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_cedric));

                mPosition = mMap.addMarker(mPositionMarker);

                if (myPositionGPSData.getStep() == 5775) {
                    mMap.clear();
                }

//                Log.e("test" , "step = " + myPositionGPSData.getStep());

//                mMap.moveCamera(CameraUpdateFactory.newLatLng(myPosition));

            }

            mHandler.postDelayed(this, 1000 / 60);
        }
    };

    Runnable mRunnable2 = new Runnable() {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void run() {
            Location location = myPositionGPSData.getPosition();

            LatLng myPosition = new LatLng(location.getLatitude(), location.getLongitude());


//            Log.e("value of intValue = ", String.valueOf(intValue));


            mHandler2.postDelayed(this, 1500);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.map_activity);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e("MapActivity", "onPause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MapActivity", "onDestroy");
        myPositionGPSData.stopThread();
        mHandler.removeCallbacks(mRunnable, mRunnable2);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;

        LatLng latLng = new LatLng(48.86340374919554, 2.287488430738449);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(latLng)      // Sets the center of the map to Mountain View
                .zoom(18)                   // Sets the zoom
                .bearing(0)                // Sets the orientation of the camera to east
                .tilt(0)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        LatLng tracer = new LatLng(48.86783423379168, 2.2919073700904846);
        MarkerOptions mTracerMarker = new MarkerOptions().title("Tracer").position(tracer).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_tracer));
        mMap.addMarker(mTracerMarker);

        LatLng roadhog = new LatLng(48.86680472366957, 2.289968803524971);
        MarkerOptions mRoadhogMarker = new MarkerOptions().title("Roadhog").position(roadhog).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_roadhog));
        mMap.addMarker(mRoadhogMarker);

        // start walking guy
        myPositionGPSData = new GPSData();

        mHandler.post(mRunnable);
        mHandler2.post(mRunnable2);
    }
}
