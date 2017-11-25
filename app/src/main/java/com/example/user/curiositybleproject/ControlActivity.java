package com.example.user.curiositybleproject;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 17/11/2016.
 */

public class ControlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_layout);
    }
}
