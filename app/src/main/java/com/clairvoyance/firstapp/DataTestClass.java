package com.clairvoyance.firstapp;

import java.io.Serializable;

/**
 * Created by Sathya on 5/18/2017.
 */

public class DataTestClass implements Serializable
{
    private String name = "Name";
    private int data1 = 5;
    private int data2;
    public String data3 = new String();
    private int[] data4;

    public DataTestClass(int inputData, int[] dataArray)
    {
        data2 = inputData;
        System.out.print(data1);
        System.out.println(data2);
        System.out.println(data3);
        data4 = dataArray;
    }

}
