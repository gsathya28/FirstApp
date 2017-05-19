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
import java.io.IOException;
import java.io.ObjectInputStream;

public class DisplayMessageActivity extends AppCompatActivity {

    FileOutputStream outputStream;
    FileInputStream inputStream;

    String awesome;
    String finalString;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        /*
        try {
            outputStream = openFileOutput(message, Context.MODE_PRIVATE);
            outputStream.write(message.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Reading the File
        try {
            inputStream = openFileInput(message);
            byte[] byteHolder = new byte[inputStream.available()];
            inputStream.read(byteHolder);
            awesome = new String(byteHolder);
            inputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(awesome);
        */

        DataTestClass e;
        try{
            FileInputStream fileIn = openFileInput(message);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (DataTestClass) in.readObject();
            in.close();
            fileIn.close();
        }catch (IOException i)
        {
            i.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("DataTest not found!");
            c.printStackTrace();
            return;
        }
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(e.getName() + e.getDataInt() + e.getDataArray());

    }

    public void nextView(View view)
    {
        Intent intent = new Intent(this, CalendarExampleActivity.class);
        startActivity(intent);
    }

    public void calculateBMI(View view)
    {
        EditText findFile = (EditText) findViewById(R.id.heightEntered);
        String fileLoc = findFile.getText().toString();
        try {
            FileInputStream newInputStream = openFileInput(fileLoc);
            byte[] byteHolderTwo = new byte[newInputStream.available()];
            newInputStream.read(byteHolderTwo);
            finalString = new String(byteHolderTwo);
            newInputStream.close();
            TextView bmiText = (TextView) findViewById(R.id.BMItext);
            bmiText.setText(finalString);
        } catch(Exception e)
        {
            TextView bmiText = (TextView) findViewById(R.id.BMItext);
            bmiText.setText("Can't find anything!");
        }
    }
}
