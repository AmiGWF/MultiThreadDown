package com.wudu.muldown.listener;

import android.view.View;

/**
 * author : wudu
 * time : 2016/10/19
 */
public interface OnItemClickListener<T> {
    void onItemClick(View v, int position, T t);
}
