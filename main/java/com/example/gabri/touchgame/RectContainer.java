package com.example.gabri.touchgame;

public class RectContainer {

    protected RectRandom rectangles;



    RectContainer(){
        rectangles = new RectRandom();
        rectangles.createRect();
    }

    public RectRandom getRectangles() {
        return rectangles;
    }
}
