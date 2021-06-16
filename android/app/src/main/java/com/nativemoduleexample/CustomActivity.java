package com.nativemoduleexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;

import static com.nativemoduleexample.CustomModule.sendEvent;

public class CustomActivity extends AppCompatActivity {
    Button button;

    MainApplication application;
    ReactNativeHost reactNativeHost;
    ReactInstanceManager reactInstanceManager;
    ReactApplicationContext reactApplicationContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        Intent intent = getIntent();

        String reactNativeMessage = intent.getStringExtra("reactNativeMessage");

        application = (MainApplication) this.getApplication();
        reactNativeHost = application.getReactNativeHost();
        reactInstanceManager = reactNativeHost.getReactInstanceManager();
        reactApplicationContext = (ReactApplicationContext) reactInstanceManager.getCurrentReactContext();

        Toast.makeText(this, reactNativeMessage, Toast.LENGTH_SHORT).show();

        button = findViewById(R.id.button);
        button.setOnClickListener(view -> {

            WritableMap data = Arguments.createMap();
            data.putString("nativeMessage", "Its coming from native side");

            sendEvent(reactApplicationContext, "dataCallback", data);
            finish();
        });
    }
}