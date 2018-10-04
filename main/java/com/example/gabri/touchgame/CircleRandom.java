package com.example.gabri.touchgame;

import android.util.Log;

import java.util.Random;

public class CircleRandom {
    private Random rand;
    private float x;
    private float y;
    private float radius = 90;

    CircleRandom(){
        rand = new Random();
    }

    public void create(){
         x = rand.nextInt(600);
         y = rand.nextInt(600);
        //Log.d("debug","x :" + x + " y :" + y);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRadius() {
        return radius;
    }
}
