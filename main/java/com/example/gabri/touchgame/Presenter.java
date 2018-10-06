package com.example.gabri.touchgame;
import android.graphics.RectF;
import android.util.Log;

public class Presenter {
    protected  ScoreCounter scoreCount;
    protected MainActivity activity;
    protected RectContainer rectangle;
    protected RectF rect;
    protected CircleRandom circleRandom;

    Presenter(MainActivity activity){
        this.activity = new MainActivity();
        this.scoreCount = new ScoreCounter();
        this.circleRandom = new CircleRandom();
    }

    public void addScore(){
        this.scoreCount.add();
    }

    public void subScore(){
        this.scoreCount.sub();
    }

    public void resetScore() {
        this.scoreCount.setScore();
    }

    public int getTotalScore(){
       return this.scoreCount.getScore();
    }

    public RectF randomisedRect(){
        this.rectangle = new RectContainer();
        float left =this.rectangle.getRectangles().getLeft();
        float top = this.rectangle.getRectangles().getTop();
        float right = this.rectangle.getRectangles().getRight();
        float bottom = this.rectangle.rectangles.getBottom();

        rect = new RectF(left,top,right,bottom);

      return rect;
    }



}
