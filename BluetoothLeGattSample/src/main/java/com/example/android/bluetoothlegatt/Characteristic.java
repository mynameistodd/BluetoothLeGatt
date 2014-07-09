package com.example.android.bluetoothlegatt;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by todd on 7/9/14.
 */
@ParseClassName("Characteristic")
public class Characteristic extends ParseObject {
    private String value;

    public String getValue() {
        return getString("value");
    }

    public void setValue(String value) {
        put("value", value);
    }

    public Characteristic() {
    }
}
