package com.clairvoyance.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }

    public void nextView(View view)
    {
        Intent intent = new Intent(this, CalendarExampleActivity.class);
        startActivity(intent);
    }

    public void calculateBMI(View view)
    {
        EditText heightEntered = (EditText) findViewById(R.id.heightEntered);
        EditText weightEntered = (EditText) findViewById(R.id.weightEntered);
        Double weight = Double.parseDouble(weightEntered.getText().toString());
        Double height = Double.parseDouble(heightEntered.getText().toString());
        Double bmi = (703 * weight) / (height * height);

        TextView bmiText = (TextView) findViewById(R.id.BMItext);
        bmiText.setText(bmi.toString());
    }
}
