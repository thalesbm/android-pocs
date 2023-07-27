package com.example.android.intent;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class Main5Activity extends AppCompatActivity {

    private final String TAG = Main5Activity.class.getSimpleName();

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Log.e(TAG, "onCreate()");

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNextActivity();
            }
        });
    }

    /**
     * If set, and the activity being launched is already running in the current task, then instead
     * of launching a new instance of that activity, all of the other activities on top of it will be
     * closed and this Intent will be delivered to the (now on top) old activity as a new Intent.
     *
     * Intent.FLAG_ACTIVITY_CLEAR_TOP - will remove all activities on top of Main2Activity included Main2Activity
     * Intent.FLAG_ACTIVITY_SINGLE_TOP - will remove all activities on top of Main2Activity but will keep Main2Activity
     */
    private void goToNextActivity() {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy()");
    }
}
