package com.clairvoyance.firstapp;

import java.io.Serializable;

/**
 * Created by Sathya on 5/18/2017.
 * Trying out serialization of Stuff
 */

class DataTestClass implements Serializable
{
    private String name = "Name";
    private int data1 = 5;
    private int data2;
    private DataTestClass2[] data4;

    DataTestClass(int inputData, DataTestClass2[] dataArray)
    {
        data2 = inputData;
        System.out.print(data1);
        System.out.println(data2);
        data4 = dataArray;
    }

    String getName()
    {
        return name;
    }

    String getDataInt()
    {
        return ("Data 1: " + data1 + " Data 2: " + data2);
    }
    String getDataArray()
    {
        String dataString = " Array: ";
        for (DataTestClass2 aData4 : data4)
        {
            dataString += aData4.data10;
            dataString += " ";
            dataString += aData4.data11;
            dataString += " ";
        }
        return dataString;
    }
}
