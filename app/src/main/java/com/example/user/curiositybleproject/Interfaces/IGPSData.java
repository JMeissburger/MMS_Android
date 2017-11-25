package com.example.user.curiositybleproject.Interfaces;

import android.location.Location;

/**
 * Created by user on 21/11/2016.
 */

public interface IGPSData {
    Location getPosition();
    int getStep();
    void stopThread();
}
