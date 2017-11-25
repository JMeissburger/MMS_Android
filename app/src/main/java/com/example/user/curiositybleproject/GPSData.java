package com.example.user.curiositybleproject;

import android.location.Location;
import android.util.Log;

import com.example.user.curiositybleproject.Interfaces.IGPSData;

/**
 * Created by user on 21/11/2016.
 */

public class GPSData implements IGPSData {

    String mMyPosition = "myPosition";
    Location mLocation = new Location(mMyPosition);
    int step = 0;

    // ...Thread
    Thread mThread;
    boolean isThreadStart = false;

    public void startThread() {
        isThreadStart = true;
        mThread.start();
    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            double i = 48.86340374919554;
            double j = 2.287488430738449;
            int maxStep = 5775;
            while (isThreadStart) {
//                i += 0.000015/60;
//                j += 0.000020/60;

                step++;

//                Log.e("GPSData", "steps = " + String.valueOf(step));
                if (step < 2400) {
                    i += 0.00009242353 / 60;
                    j += 0.00006855726 / 60;
                } else if (step < 3450) {
                    i += 0.00003768678 / 60;
                    j += 0.00009366273 / 60;
                } else if (step < 4500) {
                    i += 0.00006076365 / 60;
                    j -= 0.00002510547 / 60;
                } else if (step < 5770) {
                    i += 0.00004488384 / 120;
                    j -= 0.0003511548 / 120;
                }

                if (step > maxStep) {
                    i = 48.86340374919554;
                    j = 2.287488430738449;
                    step = 0;
                }

                mLocation.setLatitude(i);
                mLocation.setLongitude(j);

                try {
                    Thread.sleep(1000 / 60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public GPSData() {
        mLocation.setLatitude(48.86340374919554);
        mLocation.setLongitude(2.287488430738449);

        mThread = new Thread(mRunnable);
        startThread();
    }

    @Override
    public Location getPosition() {
        return mLocation;
    }

    @Override
    public int getStep() {
        return step;
    }

    @Override
    public void stopThread() {
        isThreadStart = false;
        try {
            mThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
