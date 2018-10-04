package com.example.gabri.touchgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

import java.util.Random;

public class RectRandom extends RectF {

    private Random rand;
    private float top;



    private float left;
    private float bottom;
    private  float right;
    private int color;

    RectRandom(){
        this.rand = new Random();
    }

    public int getColor() {
        return color;
    }

    public float getTop() {
        return top;
    }

    public float getLeft() {
        return left;
    }

    public float getBottom() {
        return bottom;
    }

    public float getRight() {
        return right;
    }

    /***
     *  Generate rectangle with randomised position
     *
     */
    public void createRect(){
        float determiner1 = this.rand.nextInt(500);
        float determiner2 =  this.rand.nextInt(800);

        left = determiner1;
        top = determiner2;
        right = determiner1+100;
        bottom = determiner2+100;

        this.color = Color.RED;

    }
}
