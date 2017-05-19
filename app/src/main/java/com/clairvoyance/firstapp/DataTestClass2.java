package com.clairvoyance.firstapp;

import java.io.Serializable;

/**
 * Created by Sathya on 5/18/2017.
 * Trying out serialization of Objects in Objects
 */

class DataTestClass2 implements Serializable
{
    int data10;
    int data11;

    DataTestClass2(int x, int y)
    {
        data10 = x;
        data11 = y;
    }

    public String spitData()
    {
        return "Data 10: " + data10 + " Data 11: " + data11;
    }

}
