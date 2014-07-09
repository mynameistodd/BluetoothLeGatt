package com.example.android.bluetoothlegatt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class GattReceiver extends BroadcastReceiver {
    public GattReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (BluetoothLeService.ACTION_DATA_AVAILABLE.equals(action)) {
            String data = intent.getStringExtra(BluetoothLeService.EXTRA_DATA);

            Characteristic characteristic = new Characteristic();
            characteristic.setValue(data);
            characteristic.saveInBackground();
        }
    }
}
