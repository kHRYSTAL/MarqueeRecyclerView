package me.khrystal.marqueerecyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import me.khrystal.marqueerecyclerviewdemo.R;

/**
 * usage:
 * author: kHRYSTAL
 * create time: 16/8/29
 * update time:
 * email: 723526676@qq.com
 */
public class SimpleViewHolder extends RecyclerView.ViewHolder {

    private int mImageRes;
    private ImageView mImageView;
    private Context mContext;

    public SimpleViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        // TODO: 16/8/29 add itemAction in here
        mImageView = (ImageView) itemView.findViewById(R.id.item_img);
    }

    public void bind(int imageRes) {
        mImageRes = imageRes;
        if (imageRes != 0x0) {
            Glide.with(mContext).load(imageRes).into(mImageView);
        }
    }
}
