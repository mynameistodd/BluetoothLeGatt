package com.example.android.bluetoothlegatt;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by todd on 7/7/14.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "7W9y8Zjy1WHlTdWsL8W8fXu6gkhoTx7839SWELDD", "kaFrcmwHvIoUTjVkO2WArCOIZFMFwebYUtYiIIz9");

//        ParseObject testObject = new ParseObject("TestObject");
//        testObject.put("foo", "bar");
//        testObject.saveInBackground();
    }
}
