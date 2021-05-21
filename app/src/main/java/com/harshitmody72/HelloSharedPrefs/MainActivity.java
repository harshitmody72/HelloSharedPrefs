package com.harshitmody72.HelloSharedPrefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.harshitmody72.callbacks.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bind;
    // For the count of the text view
    int count = 0;

    // for the back ground color of the text view
    int backgroundColor = Color.parseColor("#C3BCBC");
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize binding
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        preferences = getPreferences(MODE_PRIVATE);

        //check shared preferences on configuration change
        //check shared preferences on restart app
        if (preferences != null){
            count = preferences.getInt(Constants.COUNT, 0);
            backgroundColor = preferences.getInt(Constants.COLOR, backgroundColor);
            bind.countTextView.setText(String.valueOf(count));
            bind.countTextView.setBackgroundColor(backgroundColor);
        }
    }

    /**
     * Increase the count value
     * update Count TextView
     */
    public void countUp(View view) {
        count++;
        bind.countTextView.setText(String.valueOf(count));
    }

    /**
     * To update the background color of the text view
     */
    public void blackBackground(View view) {
        backgroundColor = Color.parseColor("#FF000000");
        bind.countTextView.setBackgroundColor(backgroundColor);

    }

    /**
     * To update the background color of the text view
     */
    public void redBackground(View view) {
        backgroundColor = Color.parseColor("#CF1919");
        bind.countTextView.setBackgroundColor(backgroundColor);
    }

    /**
     * To update the background color of the text view
     */
    public void blueBackground(View view) {
        backgroundColor = Color.parseColor("#263DBC");
        bind.countTextView.setBackgroundColor(backgroundColor);
    }

    /**
     * To update the background color of the text view
     */
    public void greenBackground(View view) {
        backgroundColor = Color.parseColor("#12C619");
        bind.countTextView.setBackgroundColor(backgroundColor);
    }

    /**
     * To reset the count value to 0 and display in the text view
     */
    public void reset(View view) {
        // To reset the count
        count = 0;
        bind.countTextView.setText(String.valueOf(count));

        // To reset the color
        backgroundColor = Color.parseColor("#C3BCBC");
        bind.countTextView.setBackgroundColor(backgroundColor);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //store value in shared Preference
        preferences.edit()
                .putInt(Constants.COUNT, count)
                .putInt(Constants.COLOR, backgroundColor)
                .apply();
    }
}