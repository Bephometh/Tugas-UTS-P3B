package com.example.gabri.touchgame;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

public class Setting extends Fragment implements  View.OnClickListener {
        protected RadioButton r1, r2; //Pilihan bentuk kotak atau lingkaran
        protected RadioButton rBiru, rHijau, rMerah; //Radio Button untuk pilih warna
        protected MainActivity activity;
        protected GameCanvas gc;

        public Setting() {
                // Required empty public constructor
        }

        public static Setting newInstance(MainActivity activity) {
                Setting fragment = new Setting();
                fragment.activity = activity;
                return fragment;
        }


        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
                // Inflate the layout for this fragment
                View inflate = inflater.inflate(R.layout.fragment_settings, container, false);
                r1 = inflate.findViewById(R.id.choiceCircle);
                r2 = inflate.findViewById(R.id.choiceRectangle);
                rBiru = inflate.findViewById(R.id.radioBiru);
                rMerah = inflate.findViewById(R.id.radioMerah);
                rHijau = inflate.findViewById(R.id.radioHijau);

                //Set OnClick Button
                rBiru.setOnClickListener(this);
                rMerah.setOnClickListener(this);
                rHijau.setOnClickListener(this);

                return inflate;

        }


        /**
         * Untuk memilih bentuk dan warna sebelum start game
         * @param view
         */
        public void onClick(View view) {
                if (view.getId() == rBiru.getId()) { //Jika yang dipilih warna hijau akan berubah warna shapenya jadi biru
                        this.activity.color = Color.BLUE;

                } else if (view.getId() == rHijau.getId()) { //Jika yang dipilih warna biru akan berubah warna shapenya jadi hijau
                        this.activity.color = Color.GREEN;
                }
                else if(view.getId() == rMerah.getId()){ //Jika yang dipilih warna merah akan berubah warna shapenya jadi merah
                    this.activity.color = Color.RED;
                }

                if(view.getId() == r1.getId()){ //Jika yang dipilih r1 shapes akan menjadi circle saat bermain

                }
                else if (view.getId() == r2.getId()){ //Jika yang dipilih r2 shapes akan menjadi rectangle saat bermain

                }

        }
}