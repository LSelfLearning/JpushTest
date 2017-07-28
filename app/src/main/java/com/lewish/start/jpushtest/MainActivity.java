package com.lewish.start.jpushtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * author: sundong
 * created at 2017/7/27 9:43
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        PushManager.getInstance().onResume(this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        PushManager.getInstance().onPause(this);
        super.onPause();
    }
}
