package com.example.exe3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;
import pl.droidsonroids.gif.GifTextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView tvSo, tvLoading;
    ImageView imgLoadingBar, imgSnow, imgSnow2, imgSnow3;
    AnimationDrawable anim;
    GifImageView gifXe;
    ObjectAnimator oa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();

    }

    private void setEvent() {
        //TUYẾT RƠI
        effectFallingSnow();
        //Xe chay
        xeChay();
        //Loading
        loadingImage();
        //progressBar
        progressBar();


    }

    private void setControl() {
        tvLoading = findViewById(R.id.tvLoading);
        imgLoadingBar = findViewById(R.id.imgLoading);

        tvSo = findViewById(R.id.tvSo);
        progressBar = findViewById(R.id.progressBar);
        gifXe = findViewById(R.id.gifXe);

        imgSnow = findViewById(R.id.imgSnow);
        imgSnow2 = findViewById(R.id.imgSnow2);
        imgSnow3 = findViewById(R.id.imgSnow3);

    }
    public void effectFallingSnow(){
        Animation animSnow = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rain);
        imgSnow.startAnimation(animSnow);

        Animation animSnow2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rain2);
        imgSnow2.startAnimation(animSnow2);

        Animation animSnow3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rain3);
        imgSnow3.startAnimation(animSnow3);
    }
    public void progressBar()
    {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        progressBar.setMax(100);
        progressBar.setScaleY(3f);
        progressAnimation();
    }
    public void loadingImage()
    {
        imgLoadingBar.setColorFilter(0xFFE65100);
        anim = (AnimationDrawable)imgLoadingBar.getDrawable();
        anim.start();
    }

    public void xeChay()
    {
        oa = ObjectAnimator.ofFloat(gifXe,"translationX",1000f);
        oa.setDuration(11600);
        oa.start();
    }

    public void progressAnimation()
    {

        ProgressBarAnimation anim = new ProgressBarAnimation(this, progressBar,tvSo, tvLoading,0f,100f);
        anim.setDuration(8000);
        progressBar.setAnimation(anim);


    }


}