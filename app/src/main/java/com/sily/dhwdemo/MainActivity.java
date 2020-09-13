package com.sily.dhwdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.sily.dhwdemo.R;
import com.sily.dhwdemo.decorationmode.LanuchActivity;
import com.sily.dhwdemo.glide.Glide;
import com.sily.dhwdemo.glide.listener.RequestListener;
import com.sily.dhwdemo.stream.FileOperating;

import java.io.IOException;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LanuchActivity.main();
        LanuchActivity.main1();
//"https://yd-imgs.380star.com/upload/uploadfile/2020/7/10/159436449185535092481725167348.png"
        // https://yd-imgs.380star.com/upload/uploadfile/2020/7/10/159436451826035092508130326623.png
        Glide.with(this)
                .loading(R.mipmap.ic_launcher)
                .load("https://yd-imgs.380star.com/upload/uploadfile/2020/8/20/159790692042038634974651371175.png")
                .listener(new RequestListener() {
                    @Override
                    public boolean onException() {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource) {
                        return false;
                    }
                }).into((ImageView) findViewById(R.id.image));
        Glide.with(this)
                .loading(R.mipmap.ic_launcher)
                .load("https://yd-imgs.380star.com/upload/uploadfile/2020/7/10/159436449185535092481725167348.png")
                .listener(new RequestListener() {
                    @Override
                    public boolean onException() {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource) {
                        Log.i("dhwglide", resource.toString());
                        return false;
                    }
                }).into((ImageView) findViewById(R.id.image1));
        Glide.with(this)
                .loading(R.mipmap.ic_launcher)
                .load("6451826035092508130326623.png")
                .listener(new RequestListener() {
                    @Override
                    public boolean onException() {
                        Log.i("dhwglide", "onException: ");
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource) {
                        return false;
                    }
                }).into((ImageView) findViewById(R.id.image2));
    }
}
