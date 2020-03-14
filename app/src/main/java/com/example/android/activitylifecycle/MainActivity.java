package com.example.android.activitylifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private final String LIFECYCLE_LOG_KEY = "lifecycleLogKey";
    private TextView mLogTextView;
    private Button mResetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLogTextView = findViewById(R.id.log_text_view);
        mResetButton = findViewById(R.id.reset_button);

        if (savedInstanceState != null && savedInstanceState.containsKey(LIFECYCLE_LOG_KEY)){
            mLogTextView.setText(savedInstanceState.getString(LIFECYCLE_LOG_KEY));
        }

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLogTextView.setText("");
            }
        });

        mLogTextView.append("ON CREATE CALLED\n");

        Log.i(TAG, "ON CREATE CALLED");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "ON START CALLED");
        mLogTextView.append("ON START CALLED\n");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "ON RESUME CALLED");
        mLogTextView.append("ON RESUME CALLED\n");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "ON PAUSE CALLED");
        mLogTextView.append("ON PAUSE CALLED\n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "ON STOP CALLED");
        mLogTextView.append("ON STOP CALLED\n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "ON DESTROY CALLED");
        mLogTextView.append("ON DESTROY CALLED\n");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "ON RESTART CALLED");
        mLogTextView.append("ON RESTART CALLED\n");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(TAG, "ON SAVED INSTANCES CALLED");
        mLogTextView.append("SAVED INSTANCES CALLED\n");

        outState.putString(LIFECYCLE_LOG_KEY,mLogTextView.getText().toString());
    }
}
