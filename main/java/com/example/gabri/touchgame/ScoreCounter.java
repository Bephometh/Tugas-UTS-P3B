package com.example.gabri.touchgame;

public class ScoreCounter implements Counter {

    protected int score;

    @Override
    public void add() {
        this.score +=100;

    }

    public void sub(){
        this.score -= 100;
    }


    public int getScore() {
        return score;
    }
}
