package com.example.user.curiositybleproject;

/**
 * Created by user on 07/11/2016.
 */

/*
    private BluetoothAdapter mBluetoothAdapter;
    private int REQUEST_ENABLE_BT = 1;
    private ArrayAdapter<String> mArrayAdapter;
 */

public class Comment {

    /*
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            // Device does not support Bluetooth
        } else {
            Toast.makeText(getApplicationContext(), "Device supports Bluetooth", Toast.LENGTH_LONG).show();
        }

        ListView mListView = (ListView) findViewById(R.id.discovery_list);
        mArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        mListView.setAdapter(mArrayAdapter);

        Button mActivateButton = (Button) findViewById(R.id.activate_button);
        mActivateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mBluetoothAdapter.isEnabled()) {
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
                } else {
                    Toast.makeText(getApplicationContext(), "Bluetooth is already enabled", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button mScanButton = (Button) findViewById(R.id.scan_button);
        mScanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find();
            }
        });
    }

    private void find() {
        mBluetoothAdapter.startDiscovery();

        // Register the BroadcastReceiver
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mReceiver, filter); // Don't forget to unregister during onDestroy
    }

    // Create a BroadcastReceiver for ACTION_FOUND
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            // When discovery finds a device
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Get the BluetoothDevice object from the Intent
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                // Add the name and address to an array adapter to show in a ListView
                mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
            }
        }
    };
     */

}
