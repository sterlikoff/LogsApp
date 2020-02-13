package ru.sterlikoff.logsapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView logTextView = null;

    protected void log(String log) {

        Log.d("Lifecycle", log);

        if (logTextView != null) {
            logTextView.append("\n");
            logTextView.append(log);
        }

    }

    protected void initViews() {
        logTextView = findViewById(R.id.log_text_view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        String bundleString = "Bundle is " + (savedInstanceState == null ? "null" : "not null");

        log("onCreate " + bundleString);

    }

    @Override
    protected void onStart() {
        super.onStart();
        log("onStart");
    }

    protected void onResume() {
        super.onResume();
        log("onResume");
    }

    protected void onPause() {
        super.onPause();
        log("onPause");
    }

    protected void onStop() {
        super.onStop();
        log("onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy");
    }

    protected void onRestart() {
        super.onRestart();
        log("onRestart");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        log("onPostCreate");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        log("onPostResume");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        log("onKeyDown " + Integer.toString(keyCode));
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        log("onLogKeyPress " + Integer.toString(keyCode));
        return super.onKeyLongPress(keyCode, event);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        log("onBackPressed");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        outState.putString("text", logTextView.getText().toString());

        super.onSaveInstanceState(outState);
        log("onSaveInstanceState");

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            logTextView.setText(savedInstanceState.getString("text"));
        }

        super.onRestoreInstanceState(savedInstanceState);
        log("onRestoreInstanceState");
    }

}
