package com.example.android.bluetoothlegatt;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by todd on 7/9/14.
 */
@ParseClassName("Characteristic")
public class Characteristic extends ParseObject {
    private String uuid;
    private String value;
    private Date capturedAt;
    private Device device;

    public String getUuid() {
        return getString("uuid");
    }

    public void setUuid(String uuid) {
        put("uuid", uuid);
    }

    public String getValue() {
        return getString("value");
    }

    public void setValue(String value) {
        put("value", value);
    }

    public Date getCapturedAt() {
        return getDate("capturedAt");
    }

    public void setCapturedAt(Date capturedAt) {
        put("capturedAt", capturedAt);
    }

    public Device getDevice() {
        return (Device) get("device");
    }

    public void setDevice(Device device) {
        put("device", device);
    }

    public Characteristic() {
    }
}
