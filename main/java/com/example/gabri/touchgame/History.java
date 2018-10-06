package com.example.gabri.touchgame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class History extends Fragment{
    protected TextView tv1 , tv2,tvNewHightScore;
    protected MainActivity activity;
    private int highScorenow =0;

    public History() {
        // Required empty public constructor
    }

    public static History newInstance(MainActivity activity) {
        History fragment = new History();
        fragment.activity = activity;
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_history, container, false);
        this.tv1 = inflate.findViewById(R.id.tvScore);
        this.tv2 = inflate.findViewById(R.id.tvYScore);
        this.tvNewHightScore = inflate.findViewById(R.id.tvNewHighScore);
        check();
        tv2.setText(activity.game.getScoreNow()+"");
        //changeText();
        check();
        return inflate;
    }

    //cek score tertinggi sama score baru
    public void check(){
        int newScore = activity.game.getScoreNow();//ngambil dari TextView score
        int highScore = Integer.valueOf(tv1.getText().toString());//high score pas di fragment score
        //yang ini kondisinya kalo high score sama newScorenya belom ada
        if(highScorenow < newScore){
            tv1.setText(newScore+"");
            highScorenow = newScore;
            tvNewHightScore.setText("NEW HIGH SCORE");
        }
        else{
            tv1.setText(highScorenow+"");
        }
    }

}
