package com.codeavengers.lottieanimationview;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

public class MainActivity extends AppCompatActivity
{
    private static final int ANIMATION_REPEAT_COUNT = 1;

    /*
    * Instance of LottieAnimationView
    * */
    private LottieAnimationView lottieAnimationView;

    /*
    * Instance of RelativeLayout
    * */
    private RelativeLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * Init the Instance of RelativeLayout
        * */
        parent = findViewById(R.id.relative_activity_main);

        /*
        * Init the Instance of LottieAnimationView
        * */
        lottieAnimationView = findViewById(R.id.lottie_anim_activity_main);
        lottieAnimationView.setRepeatCount(ANIMATION_REPEAT_COUNT);
        lottieAnimationView.playAnimation();

        /*
        * Interface (Listener) which will trigger us when the
        * Animation Ends
        * */
        lottieAnimationView.addAnimatorListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                /*
                * As the Animation finishes, tell LottieAnimationView
                * to change the Animation
                * */
                lottieAnimationView.cancelAnimation();
                lottieAnimationView.clearAnimation();
                lottieAnimationView.setAnimationFromUrl("https://assets2.lottiefiles.com/packages/lf20_20l3E1.json");
                lottieAnimationView.playAnimation();

                /*
                * Turn Parent Black
                * */
                int blackColor = Color.BLACK;
                parent.setBackgroundColor(blackColor);
            }
        });
    }
}
