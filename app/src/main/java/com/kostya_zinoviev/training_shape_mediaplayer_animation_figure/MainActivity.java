package com.kostya_zinoviev.training_shape_mediaplayer_animation_figure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView myFigure;
    private ImageView myFigure2;
    private ImageView myFigure3;
    private MyFragment1 f1;
    private MyFragment2 f2;
    private ViewPager vp;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myFigure = findViewById(R.id.myFigure2);
        myFigure2 = findViewById(R.id.myFigure4);
        myFigure3 = findViewById(R.id.myFigure6);
        f1 = new MyFragment1();
        f2 = new MyFragment2();
        adapter = new MyAdapter(getSupportFragmentManager());
        vp =findViewById(R.id.vp);
        /*vp.setCurrentItem(1);*/
        vp.setAdapter(adapter);

        final MediaPlayer md = MediaPlayer.create(this,R.raw.stuff);
        findViewById(R.id.myFigure2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                myFigure.animate().alpha(0.0f).setDuration(1000);
            }
        });
         myFigure2.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
                myFigure2.animate().rotation(180.0f).setDuration(3000);
           }
       });
         myFigure3.setOnClickListener(new OnClickListener() {
             @Override
             public void onClick(View v) {
                 myFigure3.animate().translationXBy(100.0f);
             }
         });
        findViewById(R.id.myButton2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView myView =   findViewById(R.id.myButton2);
                if(md.isPlaying()){
                    md.pause();
                 myView.setImageResource(R.drawable.ic_volume_off_black_24dp);
                }else{
                    md.start();
                    myView.setImageResource(R.drawable.ic_add_circle_black_24dp);
                }
            }
        });
    }
    public class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm){
        super(fm);
    }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 1:
                    return new MyFragment1();
                case 2:
                    return new MyFragment2();
            };
            return new MyFragment1();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
