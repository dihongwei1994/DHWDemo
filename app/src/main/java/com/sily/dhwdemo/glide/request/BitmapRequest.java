package com.sily.dhwdemo.glide.request;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.sily.dhwdemo.glide.MD5Util;
import com.sily.dhwdemo.glide.listener.RequestListener;

import java.lang.ref.SoftReference;

public class BitmapRequest {
    private String url;
    private SoftReference<ImageView> softReference;
    private String uriMD5;
    private int loadingResId;
    private Context context;
    private RequestListener requestListener;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageView getImage() {
        return softReference.get();
    }

    public void setSoftReference(SoftReference<ImageView> softReference) {
        this.softReference = softReference;
    }

    public String getUriMD5() {
        return uriMD5;
    }

    public void setUriMD5(String uriMD5) {
        this.uriMD5 = uriMD5;
    }

    public int getLoadingResId() {
        return loadingResId;
    }

    public void setLoadingResId(int loadingResId) {
        this.loadingResId = loadingResId;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public RequestListener getRequestListener() {
        return requestListener;
    }

    public void setRequestListener(RequestListener requestListener) {
        this.requestListener = requestListener;
    }

    public BitmapRequest(Context context) {
        this.context=context;
    }
    public BitmapRequest loading(int loadingResId){
        this.loadingResId=loadingResId;
        return this;
    }
    public BitmapRequest listener(RequestListener requestListener){
        this.requestListener=requestListener;
        return this;
    }
    public BitmapRequest load(String url){
        this.url=url;
        setUriMD5(MD5Util.toMD5(url));
        return this;
    }
    public void into(ImageView imageView){
        this.softReference=new SoftReference<>(imageView);
        imageView.setTag(uriMD5);
        RequestManager.getInstance().addBitmapRequest(this);

    }
}
