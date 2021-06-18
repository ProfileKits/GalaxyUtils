package com.predictor.galaxyutils;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.predictor.galaxyutilslibrary.utils.GalaxyLogUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //打印日志
//        GalaxyLogUtil.i("galaxy");
    }
}