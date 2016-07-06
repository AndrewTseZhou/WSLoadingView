package com.ws.loadingview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ws.loadingview.view.WSCircleArc;
import com.ws.loadingview.view.WSCircleBar;
import com.ws.loadingview.view.WSCircleCD;
import com.ws.loadingview.view.WSCircleFace;
import com.ws.loadingview.view.WSCircleJump;
import com.ws.loadingview.view.WSCircleRing;
import com.ws.loadingview.view.WSCircleRipple;
import com.ws.loadingview.view.WSCircleRise;
import com.ws.loadingview.view.WSCircleRotate;
import com.ws.loadingview.view.WSCircleSun;
import com.ws.loadingview.view.WSCubes;
import com.ws.loadingview.view.WSEatBeans;
import com.ws.loadingview.view.WSFiveStar;
import com.ws.loadingview.view.WSGearLoading;
import com.ws.loadingview.view.WSGears;
import com.ws.loadingview.view.WSJump;
import com.ws.loadingview.view.WSLineProgress;
import com.ws.loadingview.view.WSMaterialLoading;
import com.ws.loadingview.view.WSSwapLoading;

public class MainActivity extends AppCompatActivity {

    private WSCircleCD mWSCircleCD;
    private WSCircleSun mWSCircleSun;
    private WSCircleRing mWSCircleRing;
    private WSCircleFace mWSCircleFace;
    private WSCircleJump  mWSCircleJump;
    private WSGears  mWSGears;
    private WSJump mWSJump;
    private WSLineProgress mWSLineProgress;
    private WSEatBeans mWSEatBeans;
    private WSCubes mWSCubes;
    private WSFiveStar mWSFiveStarView;
    private WSCircleRise mWSCircleRise;
    private WSCircleBar mWSCircleBar;
    private WSCircleArc mWSCircleArc;
    private WSMaterialLoading mWSMaterialLoading;
    private WSGearLoading mWSGearLoading;
    private WSSwapLoading  mWSSwapLoading;
    private WSCircleRotate mWSCircleRotate;
    private WSCircleRipple mWSCircleRipple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWSCircleCD = (WSCircleCD) findViewById(R.id.load_cd);
        mWSCircleCD.startAnimator();


        mWSCircleSun = (WSCircleSun) findViewById(R.id.load_sun);
        mWSCircleSun.startAnimator();

        mWSCircleRing= (WSCircleRing) findViewById(R.id.load_ring);
        mWSCircleRing.startAnimator();

        mWSCircleFace= (WSCircleFace) findViewById(R.id.load_face);
        mWSCircleFace.startAnimator();

        mWSCircleJump= (WSCircleJump) findViewById(R.id.load_jump);
        mWSCircleJump.startAnimator();

        mWSGears= (WSGears) findViewById(R.id.load_gear);
        mWSGears.startAnimator();

        mWSJump= (WSJump) findViewById(R.id.load_mjump);
        mWSJump.startAnimator();

        mWSLineProgress= (WSLineProgress) findViewById(R.id.load_line_progress);
        mWSLineProgress.startAnimator();

        mWSEatBeans= (WSEatBeans) findViewById(R.id.load_eat);
        mWSEatBeans.startAnimator();

        mWSCubes= (WSCubes) findViewById(R.id.load_cube);
        mWSCubes.startAnimator();

        mWSFiveStarView= (WSFiveStar) findViewById(R.id.load_mfive);
        mWSFiveStarView.setRegularPolygon(5);
        mWSFiveStarView.startAnimator();

        mWSCircleRise= (WSCircleRise) findViewById(R.id.load_rise);
        mWSCircleRise.startAnimator();

        mWSCircleBar= (WSCircleBar) findViewById(R.id.load_bar);
        mWSCircleBar.startAnimator();

        mWSCircleArc= (WSCircleArc) findViewById(R.id.load_arc);
        mWSCircleArc.startAnimator();


        mWSMaterialLoading= (WSMaterialLoading) findViewById(R.id.load_material);
        mWSMaterialLoading.startAnimator();

        mWSGearLoading= (WSGearLoading) findViewById(R.id.load_gear_loading);
        mWSGearLoading.startAnimator();

        mWSSwapLoading= (WSSwapLoading) findViewById(R.id.load_swap);
        mWSSwapLoading.startAnimator();

        mWSCircleRotate= (WSCircleRotate) findViewById(R.id.load_rotate);
        mWSCircleRotate.startAnimator();

        mWSCircleRipple= (WSCircleRipple) findViewById(R.id.load_ripple);
        mWSCircleRipple.startAnimator();
    }
}
