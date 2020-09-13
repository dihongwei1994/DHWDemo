package com.sily.dhwdemo.glide;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import com.sily.dhwdemo.glide.request.BitmapRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.BlockingDeque;

public class BitmapDispater extends Thread {
    private BlockingDeque<BitmapRequest> requestDeque;
    private Handler handler = new Handler(Looper.getMainLooper());

    public BitmapDispater(BlockingDeque<BitmapRequest> requestBlockingDeque) {
        this.requestDeque = requestBlockingDeque;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                BitmapRequest request = requestDeque.take();
                //占位符
                showLoadingImage(request);
                //网络加载
                Bitmap bitmap = findBitmap(request);
                showImage(bitmap, request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void showImage(final Bitmap bitmap, final BitmapRequest request) {
        if (bitmap != null && request.getImage() != null && request.getImage().getTag().equals(request.getUriMD5())) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    try {
                        request.getImage().setImageBitmap(bitmap);
                        if(request.getRequestListener()!=null){
                            request.getRequestListener().onResourceReady(bitmap);
                        }
                    } catch (Exception e) {
                        if(request.getRequestListener()!=null){
                            request.getRequestListener().onException();
                        }
                    }
                }
            });
        }
    }

    private Bitmap findBitmap(BitmapRequest request) {
        Bitmap bitmap = downLoadingBitmap(request);
        return bitmap;
    }

    private Bitmap downLoadingBitmap(BitmapRequest request) {
        InputStream is = null;
        Bitmap bitmap = null;
        try {
            URL url = new URL(request.getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            is = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
        } catch (Exception e) {
            e.printStackTrace();
            if(request.getRequestListener()!=null){
                request.getRequestListener().onException();
            }
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bitmap;
    }

    private void showLoadingImage(BitmapRequest request) {
        if (request.getLoadingResId() > 0) {
            final ImageView imageView = request.getImage();
            final int loadingResId = request.getLoadingResId();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    imageView.setImageResource(loadingResId);
                }
            });
        }
    }
}
