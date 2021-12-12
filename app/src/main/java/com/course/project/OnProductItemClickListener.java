package com.course.project;

import android.view.View;

public interface OnProductItemClickListener {
    public abstract void onItemClick(MyAdapter.ViewHolder holder, View view, int position);
}
