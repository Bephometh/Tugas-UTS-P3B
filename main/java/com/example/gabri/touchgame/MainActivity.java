package com.example.gabri.touchgame;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected GameCanvas game;
    protected FragmentManager fragment;
    protected Button startButt;
    protected Button settings;
    protected Button scoreButt;
    protected Setting settingclass;
    protected History historyScore;
    protected Presenter presenter;
    protected int color = Color.BLUE;
    protected int shapesCode = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.startButt = this.findViewById(R.id.star_game_frag);
        this.fragment = this.getSupportFragmentManager();
        this.game = GameCanvas.newInstance(this);
        this.settings = this.findViewById(R.id.settingbtn);
        this.scoreButt = this.findViewById(R.id.history_button);
        this.settingclass = Setting.newInstance(this);
        this.historyScore = History.newInstance(this);
        this.presenter = new Presenter(this);

        //set on click
        this.startButt.setOnClickListener(this);
        this.settings.setOnClickListener(this);
        this.scoreButt.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == startButt){
            FragmentTransaction fragmentTransaction = this.fragment.beginTransaction();
            fragmentTransaction.replace(R.id.frag_container,game);
            fragmentTransaction.commit();
        }
        else if(view == settings){
            FragmentTransaction fragmentTransaction = this.fragment.beginTransaction();
            fragmentTransaction.replace(R.id.frag_container,settingclass);
            fragmentTransaction.commit();
        }
        else if(view == scoreButt){
            goToHistory();
        }
    }

    //pindah ke fragment score
    public void goToHistory(){
        FragmentTransaction fragmentTransaction = this.fragment.beginTransaction();
        fragmentTransaction.replace(R.id.frag_container,historyScore);
        fragmentTransaction.commit();
    }
}
