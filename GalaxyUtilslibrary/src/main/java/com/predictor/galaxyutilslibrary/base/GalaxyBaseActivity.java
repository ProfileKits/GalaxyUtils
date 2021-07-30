package com.predictor.galaxyutilslibrary.base;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public abstract class GalaxyBaseActivity extends AppCompatActivity {
    protected Context mContext;
    public Typeface typeface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initView();
        initData();
        initListener();
    }

    protected abstract void initView();
    protected abstract void initData();
    protected abstract void initListener();


    /**
     * View的动画效果
     *
     * @param hideView
     * @param showView
     */
    public void ViewAnimation(final View hideView, final View showView) {
        ObjectAnimator mShowAction = ObjectAnimator.ofFloat(hideView, "alpha", 1f, 0.1f, 0f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(mShowAction);
        animSet.setDuration(200);
        animSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(hideView!=null){
                    hideView.setVisibility(View.GONE);
                }
                if(showView!=null){
                    showView.setVisibility(View.VISIBLE);
                }
                ObjectAnimator mHiddenAction = ObjectAnimator.ofFloat(showView, "alpha", 0.1f, 1f, 1f);
                AnimatorSet animSetHide = new AnimatorSet();
                animSetHide.play(mHiddenAction);
                animSetHide.setDuration(200);
                animSetHide.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        animSet.start();

    }

    /**
     * 不传数据 不传返回值
     *
     * @param targetActivityClass
     */
    protected void startActivity(Class<?> targetActivityClass) {
        startActivity(targetActivityClass, null, false);
    }

    /**
     * 传是否finish数据 不传返回值
     *
     * @param targetActivityClass
     */
    protected void startActivity(Class<?> targetActivityClass, boolean isFinish) {
        startActivity(targetActivityClass, null, isFinish);
    }

    /**
     * 传数据 不传返回值
     *
     * @param targetActivityClass
     * @param bundle
     */
    protected void startActivity(Class<?> targetActivityClass, Bundle bundle, boolean isFinish) {
        startActivity(targetActivityClass, bundle, 0, isFinish);
    }

    /**
     * 不传数据 传返回值 activity 不能finish
     *
     * @param targetActiviyClass
     * @param requestCode
     */
    protected void startToActivity(Class<?> targetActiviyClass, int requestCode) {
        startActivity(targetActiviyClass, null, requestCode, false);
    }

    /**
     * 传数据 传返回值 Activity 不能finish
     *
     * @param targetActiviyClass
     * @param bundle
     * @param requestCode
     */
    protected void startActivity(Class<?> targetActiviyClass, Bundle bundle, int requestCode, boolean isFinish) {
        Intent startIntent = new Intent(mContext, targetActiviyClass);
        startActivity(startIntent, bundle, requestCode, isFinish);
    }

    /**
     * 控制Activity的跳转方法
     *
     * @param startIntent
     *         intent
     * @param bundle
     *         bundle数据
     * @param requestCode
     *         请求码
     */
    private void startActivity(Intent startIntent, Bundle bundle, int requestCode, boolean isFinish) {
        if (startIntent != null) {
            if (bundle != null) {
                startIntent.putExtras(bundle);
            }
            if (requestCode != -1) {
                startActivity(startIntent);
                if (isFinish) {
                    finish();
                }
            } else {
                startActivityForResult(startIntent, requestCode);
            }
        }
    }
}
