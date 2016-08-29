package me.khrystal.marqueerecyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import me.khrystal.marqueerecyclerviewdemo.R;

/**
 * usage:
 * author: kHRYSTAL
 * create time: 16/8/29
 * update time:
 * email: 723526676@qq.com
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder>{

    private Context mContext;
    private List<Integer> mDataList;
    private int mSize;

    public SimpleAdapter(Context context, List<Integer> dataList) {
        mContext = context;
        mDataList = dataList;
        mSize = mDataList.size();
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SimpleViewHolder holder = new SimpleViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        int imageRes = mDataList.get(position % mSize);
        if (imageRes != 0x0) {
            holder.bind(imageRes);
        }
    }

    /**
     * infinite loop
     * @return
     */
    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
}
