package com.ws.loadingview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * Created by Administrator on 6/28 0028.
 */
public class WSCircleRotate extends View {

    private Context mContext;
    private Paint mPaint;

    private float centerX;
    private float centerY;
    private float storeRadius;

    private float ballX;
    private float ballY;
    private float ballRadius;
    private float ballSweepAngle;

    private float mValueAnimator;

    private final static float RADIUS_RATIO = 2 / 3f;

    private static final int DEGREE_360 = 360;

    private static final int DEGREE_180 = 180;

    private static final int ALPHA_255 = 255;

    private static final int STORE_CIRCLE_ALPHA = (int) (0.5f * ALPHA_255);

    private static final int DEFAULT_STORE_WIDTH = 1;

    private static final int DEFAULT_BALL_RADIUS = 4;

    private static final float DEFAULT_BALL_START_ANGLE = -0.25f * DEGREE_360;

    public WSCircleRotate(Context context) {
        this(context, null);
    }

    public WSCircleRotate(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WSCircleRotate(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Color.WHITE);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        //处理 wrap_content问题
        int defaultDimension = dip2px(100);

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(defaultDimension, defaultDimension);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(defaultDimension, heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, defaultDimension);
        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        centerX = w / 2;
        centerY = h / 2;

        //处理padding情况
        storeRadius = (int) (Math.min(centerX - getPaddingLeft(), centerX - getPaddingRight()) * RADIUS_RATIO);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画外圆
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(dip2px(DEFAULT_STORE_WIDTH));
        mPaint.setAlpha(STORE_CIRCLE_ALPHA);
        canvas.drawCircle(centerX, centerY, storeRadius, mPaint);

        mPaint.setAlpha(ALPHA_255);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        ballX = centerX + storeRadius * (float) Math.cos(Math.toRadians(DEFAULT_BALL_START_ANGLE + mValueAnimator * DEGREE_360));
        ballY = centerY + storeRadius * (float) Math.sin(Math.toRadians(DEFAULT_BALL_START_ANGLE + mValueAnimator * DEGREE_360));

        canvas.drawCircle(ballX,ballY,dip2px(DEFAULT_BALL_RADIUS),mPaint);
    }


    //开始动画
    public void startAnimator() {
        post(new Runnable() {
            @Override
            public void run() {
                ValueAnimator animator = ValueAnimator.ofFloat(0f, 1.0f);
                animator.setDuration(1000);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.setRepeatMode(ValueAnimator.RESTART);
                animator.setRepeatCount(ValueAnimator.INFINITE);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        mValueAnimator = (float) animation.getAnimatedValue();

                        postInvalidate();
                    }
                });
                animator.start();
            }
        });
    }

    public void setPaintColor(int color) {
        mPaint.setColor(color);
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dip2px(float dpValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
