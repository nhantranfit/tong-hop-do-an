package com.example.exe3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarAnimation extends Animation {
    private Context context;
    private ProgressBar progressBar;
    private TextView textView, tvLoading;
    private float from;
    private float to;

    public ProgressBarAnimation(Context context, ProgressBar progressBar, TextView textView, TextView tvLoading, float from, float to){
        this.context = context;
        this.progressBar = progressBar;
        this.textView = textView;
        this.tvLoading = tvLoading;
        this.from = from;
        this.to = to;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;
        progressBar.setProgress((int) value);
        textView.setText((int) value + "%");

        if(value == to){
            tvLoading.setText("Successfully!!!");
            tvLoading.setTextColor(Color.MAGENTA);
            context.startActivity(new Intent(context,ManHinhChinh.class));
        }
    }
}
