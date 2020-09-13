package com.sily.dhwdemo.glide.listener;

import android.graphics.Bitmap;

public interface RequestListener {
    public boolean onException();
    boolean onResourceReady(Bitmap resource);
}
