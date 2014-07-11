package com.example.android.bluetoothlegatt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.Date;
import java.util.UUID;

public class GattReceiver extends BroadcastReceiver {
    private SharedPreferences prefs;
    public GattReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        final String action = intent.getAction();

        if (BluetoothLeService.ACTION_DATA_AVAILABLE.equals(action)) {
            String deviceObjectId = prefs.getString("deviceObjectId", "unknown");

            final String data = intent.getStringExtra(BluetoothLeService.EXTRA_DATA);
            final String uuid = intent.getStringExtra(BluetoothLeService.EXTRA_UUID);

            ParseQuery<Device> query = ParseQuery.getQuery(Device.class);
            query.setCachePolicy(ParseQuery.CachePolicy.CACHE_ELSE_NETWORK);
            query.getInBackground(deviceObjectId, new GetCallback<Device>() {
                @Override
                public void done(Device device, ParseException e) {
                    Characteristic characteristic = new Characteristic();
                    characteristic.setUuid(uuid);
                    characteristic.setValue(data);
                    characteristic.setCapturedAt(new Date());
                    characteristic.setDevice(device);
                    characteristic.saveInBackground();
                }
            });


        }
    }
}
