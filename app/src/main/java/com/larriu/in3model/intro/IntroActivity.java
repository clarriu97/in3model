package com.larriu.in3model.intro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import com.larriu.in3model.R;
import com.larriu.in3model.main.normal.MainActivityNormal;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    private IntroViewPagerAdapter introViewPagerAdapter;
    private List<IntroScreenItem> list;
    private TabLayout tabLayout;
    private Button nextButton, getStartedbutton;
    private int position;
    private Animation buttonAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //make the activity on fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //hide the action bar
        getSupportActionBar().hide();

        setContentView(R.layout.activity_intro);

        //ini views
        tabLayout = findViewById(R.id.tabLayoutIntroActivity);
        nextButton = findViewById(R.id.nextButtonIntroActivity);
        getStartedbutton = findViewById(R.id.getStartedButton);
        buttonAnimation = AnimationUtils.loadAnimation(this, R.anim.button_animation);

        //Fill list screen
        list = new ArrayList();
        list.add(new IntroScreenItem("Fresh Food", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book"
                , R.drawable.facebook));
        list.add(new IntroScreenItem("Fast Delivery", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book"
                , R.drawable.firebase_logo));
        list.add(new IntroScreenItem("Fresh Food", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book"
                , R.drawable.google));

        //setup viewpager
        screenPager = findViewById(R.id.viewPager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, list);
        screenPager.setAdapter(introViewPagerAdapter);
        position = 0;

        //setup tablayout
        tabLayout.setupWithViewPager(screenPager);

        //setup button listener
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = screenPager.getCurrentItem();
                if (position < list.size()){
                    position++;
                    screenPager.setCurrentItem(position);
                }

                if (position == list.size()-1){
                    //when we reach to the last screen
                    loadLastScreen();

                }
            }
        });

        //tablayout add change listener
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == list.size()-1){
                    loadLastScreen();
                } else {
                    loadNonLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //setup getStartedButtonListener
        getStartedbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroActivity.this, MainActivityNormal.class);
                startActivity(intent);

                //save that the user has seen the intro so he won't see it again
                SharedPreferences preferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("seenIntro", true);
                editor.commit();
                finish();
            }
        });

    }

    private void loadLastScreen() {
        nextButton.setVisibility(View.INVISIBLE);
        tabLayout.setVisibility(View.INVISIBLE);
        getStartedbutton.setVisibility(View.VISIBLE);

        //setup getstartedbutton animation
        getStartedbutton.setAnimation(buttonAnimation);

    }

    private void loadNonLastScreen(){
        nextButton.setVisibility(View.VISIBLE);
        tabLayout.setVisibility(View.VISIBLE);
        getStartedbutton.setVisibility(View.INVISIBLE);
    }
}