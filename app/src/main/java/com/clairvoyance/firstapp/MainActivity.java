package com.clairvoyance.firstapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Called when user taps Send Button
    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.enterHeight);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);

        int x = 7;
        DataTestClass2 test1 = new DataTestClass2(10, 11);
        DataTestClass2 test2 = new DataTestClass2(23, 56);
        DataTestClass2 test3 = new DataTestClass2(78, 90);

        DataTestClass2[] array = {test1, test2, test3};

        DataTestClass e = new DataTestClass(x, array);
        try{
            FileOutputStream fileOut = openFileOutput(message, Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.print("Serialized Data Saved!");
        }catch (IOException i)
        {
            i.printStackTrace();
        }

        startActivity(intent);
    }
}
