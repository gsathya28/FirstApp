package com.clairvoyance.firstapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DisplayMessageActivity extends AppCompatActivity {

    String filename = "testFile";
    FileOutputStream outputStream;
    FileInputStream inputStream;
    byte[] byteHolder;
    String awesome = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text

        try {
            outputStream = openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(message.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            inputStream = openFileInput(filename);
            inputStream.read(byteHolder, 0, 0);
            awesome = byteHolder.toString();
        } catch (Exception e){
            e.printStackTrace();
        }

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(awesome);
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
