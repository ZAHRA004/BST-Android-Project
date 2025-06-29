/*package com.example.hello;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.Object;
import android.app.Activity.*;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.hello.Adapters.OnBoardingAdapter;
import com.example.hello.Helpers.SaveState;

public abstract class Activity_slide1 extends Context {

    CardView nextCard;
    LinearLayout dotsLayout;
    ViewPager viewPager;
    TextView[] dots;
    int currentPotion;
    SaveState saveState;   */

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {

        Activity_slide1.getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide2);

        Button nextCard = viewPager.findViewById(R.id.nextCard);
        dotsLayout = viewPager.findViewById(R.id.dostLayout);
        viewPager = viewPager.findViewById(R.id.slider);
        dotsFountion(1);
        saveState = new SaveState(Activity_slide1.this, "OB");
        if(saveState.getState() == 2){
            Intent i = new Intent(Activity_slide1.this, MainActivity2.class);
            startActivity(i);
            /*finish();
        }

        OnBoardingAdapter adapter = new OnBoardingAdapter(this);
        viewPager.setAdapter(adapter);
        nextCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                viewPager.setCurrentItem(currentPotion+2, true);
            }
        });
        viewPager.setOnPageChangeListener(onPageChangeListener);

    }

    private void dotsFountion(int pos){
        dots = new TextView[3];
        dotsLayout.removeAllViews();

        for(int i = 0 ; i<dots.length ; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("."));
            dots[i].setTextColor(ContextCompat.getColor(this,R.color.white));
            dots[i].setTextSize(30);

            dotsLayout.addView(dots[i]);

        }

        if(dots.length > 0){
            dots[pos].setTextColor(ContextCompat.getColor(this,R.color.orange));
            dots[pos].setTextSize(40);
        }

    }

    ViewPager.OnPageChangeListener  onPageChangeListener = new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageScrolled(int position, float positonOffset, int positonOffsetPixels){

        }

        @Override
        public void onPageSelected(int position){
            dotsFountion(position);
            currentPotion = position;
            if (currentPotion <= 2){
                nextCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        viewPager.setCurrentItem(currentPotion+1);
                    }
                });
            }else {
                nextCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        saveState.setState(1);
                        Intent i = new Intent(Activity_slide1.this, MainActivity2.class);
                        startActivity(i);
                        /*finish();
                    }
                });
            }
        }

        @Override
        public void onPageScrollStateChanged(int state){

        }

    };

} */
