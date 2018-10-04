package com.example.gabri.touchgame;
import android.graphics.RectF;
import android.util.Log;

public class Presenter {
    protected  ScoreCounter scoreCount;
    protected MainActivity activity;
    protected RectContainer rectangle;
    protected GameCanvas gameCanvas;
    protected RectF rect;
    protected CircleRandom circleRandom;
    protected float circX;
    protected float circY;
    protected float circRad;

    Presenter(MainActivity activity){
        this.scoreCount = new ScoreCounter();
        this.activity = new MainActivity();
        this.gameCanvas = GameCanvas.newInstance(activity);
        this.circleRandom = new CircleRandom();
    }

    public void addScore(){
        this.scoreCount.add();
    }

    public void subScore(){
        this.scoreCount.sub();
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

        this.circleRandom.create();
        this.circX = this.circleRandom.getX();
        this.circY = this.circleRandom.getY();
        this.circRad = this.circleRandom.getRadius();

        if(rect.contains(this.circX, this.circY) == true){
            randomisedRect();
        }
        else{

            Log.d("debug","heigth : " + gameCanvas.height + "Width : " + gameCanvas.width);
            return rect;
        }
        Log.d("debug","heigth : " + gameCanvas.height + "Width : " + gameCanvas.width);
        return rect;
    }



}
