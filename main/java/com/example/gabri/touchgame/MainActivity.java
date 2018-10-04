package com.example.gabri.touchgame;

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
    protected  Button settings;
    protected Setting settingclass;
    protected int color;
    protected int shapesCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.startButt = this.findViewById(R.id.star_game_frag);
        this.fragment = this.getSupportFragmentManager();
        this.game = GameCanvas.newInstance(this);
        this.settings = this.findViewById(R.id.settingbtn);
        this.settingclass = Setting.newInstance(this);

        //set on click
        this.startButt.setOnClickListener(this);
        this.settings.setOnClickListener(this);

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
    }
}
