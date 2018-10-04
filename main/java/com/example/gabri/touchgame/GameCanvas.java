package com.example.gabri.touchgame;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameCanvas extends Fragment implements View.OnTouchListener,View.OnClickListener{

    protected ImageView gameField;
    protected TextView score;
    protected Paint shapes;
    protected Bitmap mBitmap;
    protected Canvas mCanvas;
    protected GestureDetector mGesture;
    protected Random random;
    protected SimpleGesture simpleGesture;
    protected MainActivity activity;
    protected Button startTest;
    protected RectF rect;
    protected Presenter present;
    protected float width;
    protected float height;
    protected  float circleX;
    protected float circleY;


    public GameCanvas() {
        // Required empty public constructor
    }

    public  static GameCanvas newInstance(MainActivity activity)  {

        GameCanvas fragment = new GameCanvas();
        fragment.activity = activity;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View inflate = inflater.inflate(R.layout.fragment_game_canvas, container, false);
      this.gameField=inflate.findViewById(R.id.game_field);
      this.score = inflate.findViewById(R.id.score);
      this.startTest = inflate.findViewById(R.id.test_button);

      //Set On click (currently a test)
      this.startTest.setOnClickListener(this);
      this.gameField.setOnTouchListener(this);

      // Initialise Attribute
      this.simpleGesture = new SimpleGesture();
      this.random = new Random();

      this.mGesture = new GestureDetector(activity,simpleGesture);


      return inflate;
    }

    /*
    *  Test create canvas method
    *  DO NOT change
    *
    * */
    public void initiateCanvas(){
        this.mBitmap = Bitmap.createBitmap(this.gameField.getWidth(), this.gameField.getHeight(), Bitmap.Config.ARGB_8888);
        this.height = this.gameField.getHeight();
        this.width = this.gameField.getWidth();
        this.shapes = new Paint();
        this.gameField.setImageBitmap(this.mBitmap);
        this.mCanvas = new Canvas(this.mBitmap);
        this.present = new Presenter(this.activity);
        shapeRandomize();

    }

    /*
    * Method for clearing the canvas
    * */
    public void clearCanvas(){
        this.mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        this.gameField.invalidate();
    }

    /*
    * Shape randomise method
    * Create rectangle  and circle on randomised position
    * */
    protected void shapeRandomize(){
        this.shapes.setColor(this.activity.color);
        rect = this.present.randomisedRect();
        int bound1 = (int) this.width;
        int bound2 = (int) this.height;
         circleX = this.random.nextInt(bound1);
         circleY = this.random.nextInt(bound2);

        if(rect.contains(circleX, circleY) == true){
            shapeRandomize();
        }
        else{

            this.mCanvas.drawRect(rect, this.shapes);
            this.shapes.setColor(Color.MAGENTA);
            this.mCanvas.drawCircle(circleX, circleY, 80,this.shapes);
            Log.d("debug","x :" + circleX + " y :" + circleY);
            Log.d("debug", "randomized");
            Log.d("debug","left :" + rect.left +" top :" + rect.top + " right :" + rect.right + " bottom :" + rect.bottom);
        }


    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.mGesture.onTouchEvent(motionEvent);
        return false;
    }

    @Override
    public void onClick(View view) {
        initiateCanvas();
        Log.d("debug", "heigh : " + gameField.getHeight() + " width : " + gameField.getWidth());
    }

    /*
    * Inner class gesture
    *
    * */
    public class SimpleGesture extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            float x =  e.getX();
            float y =  e.getY();

            // circle equation for cartesioan coordinates
            float touchX = (float) Math.pow(x-circleX,2);
            float touchY = (float) Math.pow(y-circleY,2);



            if(activity.shapesCode == 1){

                 if(touchX + touchY <= 80 * 80){
                    present.addScore();
                     score.setText("Score : " + Integer.toString(present.getTotalScore()));
                    Log.d("debug","touched");
                    Log.d("debug","x :" + x + " y :" + y);
                    clearCanvas();
                    shapeRandomize();

                    // circleRandom();
                }
                 else if(x >= rect.left && x < rect.right && y >= rect.top && y < rect.bottom){
                     Log.d("debug","touched");
                     Log.d("debug","x :" + x + " y :" + y);
                     present.subScore();
                     score.setText("Score : " + Integer.toString(present.getTotalScore()));
                     clearCanvas();
                     shapeRandomize();
                     // circleRandom();

                 }
                else {
                    Log.d("debug","untouched");
                    Log.d("debug","x :" + x + " y :" + y);
                }
            }
            else if(activity.shapesCode == 2){
                if(x >= rect.left && x < rect.right && y >= rect.top && y < rect.bottom){
                    Log.d("debug","touched");
                    Log.d("debug","x :" + x + " y :" + y);
                    present.addScore();
                    score.setText("Score : " + Integer.toString(present.getTotalScore()));
                    clearCanvas();
                    shapeRandomize();
                    // circleRandom();

                }
                else if(touchX + touchY <= 80 * 80){
                    present.subScore();
                    score.setText("Score : " + Integer.toString(present.getTotalScore()));
                    Log.d("debug","touched");
                    Log.d("debug","x :" + x + " y :" + y);
                    clearCanvas();
                    shapeRandomize();

                    // circleRandom();
                }
                else {
                    Log.d("debug","untouched");
                    Log.d("debug","x :" + x + " y :" + y);
                }
            }
            return true;
        }
    }

}
