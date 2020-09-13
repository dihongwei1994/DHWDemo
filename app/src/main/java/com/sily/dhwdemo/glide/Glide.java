package com.sily.dhwdemo.glide;

import android.app.Activity;
import android.content.Context;

import com.sily.dhwdemo.glide.request.BitmapRequest;

public class Glide {
    public static BitmapRequest with(Context context) {
        return new BitmapRequest(context);
    }

}
