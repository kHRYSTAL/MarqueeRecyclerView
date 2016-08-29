package me.khrystal.marqueerecyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import me.khrystal.marqueerecyclerview.MarqueeRecyclerView;
import me.khrystal.marqueerecyclerviewdemo.adapter.SimpleAdapter;

public class MainActivity extends AppCompatActivity {

    Integer[] mDatas = {
            R.mipmap.girl1, R.mipmap.girl2, R.mipmap.girl3, R.mipmap.girl4,
            R.mipmap.girl5, R.mipmap.girl6, R.mipmap.girl7, R.mipmap.girl8,
            R.mipmap.girl9
    };
    private MarqueeRecyclerView marquee1;
    private MarqueeRecyclerView marquee2;

    private SimpleAdapter mAdapter1;
    private SimpleAdapter mAdapter2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        marquee1 = (MarqueeRecyclerView) findViewById(R.id.marquee_1);
        marquee2 = (MarqueeRecyclerView) findViewById(R.id.marquee_2);

        marquee1.setScrollSpeed(-1, 100);
        marquee2.setScrollSpeed(1, 100);

        initDisplay();
    }

    private void initDisplay() {

        List<Integer> list1 = Arrays.asList(mDatas);
        Collections.shuffle(list1);

        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < mDatas.length; i++) {
            list2.add(new Integer(mDatas[i]));
        }
        Collections.shuffle(list2);

        mAdapter1 = new SimpleAdapter(this, list1);
        mAdapter2 = new SimpleAdapter(this, list2);

        marquee1.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, true));
        marquee2.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));

        marquee1.setAdapter(mAdapter1);
        marquee2.setAdapter(mAdapter2);

        makeWindowDark();
    }

    public void makeWindowDark() {
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = 0.5f;
        window.setAttributes(lp);
    }
}
