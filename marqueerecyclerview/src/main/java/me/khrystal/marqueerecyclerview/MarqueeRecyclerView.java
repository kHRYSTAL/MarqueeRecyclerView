package me.khrystal.marqueerecyclerview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * usage:
 * author: kHRYSTAL
 * create time: 16/8/28
 * update time:
 * email: 723526676@qq.com
 */
public class MarqueeRecyclerView extends RecyclerView{

    private Thread mThread = null;
    private AtomicBoolean mAtomic = new AtomicBoolean(false);
    private Handler mHandler;
    private int mShift = 2;
    private long mTime = 100L;


    public MarqueeRecyclerView(Context context) {
        this(context, null);
    }

    public MarqueeRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MarqueeRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startMarquee();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopMarquee();
    }

    /**
     * set scroll speed
     * if shift > 0 direction is towards the left or upward
     * if shift < 0 direction is towards the right or downward
     * default value speed is 2px/100ms
     *
     * @param shift
     * @param time
     */
    public void setScrollSpeed(int shift, long time) {
        mShift = shift;
        mTime = time;
    }

    public void startMarquee() {
        mHandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
//              step by step
                scrollBy(mShift, mShift);
            }
        };

        if (mThread == null) {
            mThread = new Thread() {
                public void run() {
                    while (mAtomic.get()) {
                        try {
                            Thread.sleep(mTime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Message msg=mHandler.obtainMessage();
                        msg.sendToTarget();
                    }
                    mHandler=null;
                }
            };
        }

        if (mThread != null)
            mThread.start();
    }


    public void stopMarquee() {
        mAtomic.set(false);
        mThread = null;
        mShift = 2;
        mTime = 100L;
    }
}
