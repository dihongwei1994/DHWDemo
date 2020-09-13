package com.sily.dhwdemo.glide.request;

import com.sily.dhwdemo.glide.BitmapDispater;

import java.util.concurrent.LinkedBlockingDeque;

public class RequestManager {
    private LinkedBlockingDeque<BitmapRequest> requests = new LinkedBlockingDeque<>();

    public void addBitmapRequest(BitmapRequest request) {
        if (!requests.contains(request)) {
            requests.add(request);
        }
    }

    public static RequestManager getInstance() {
        return Singleton.instance;
    }


    private static class Singleton {
        private static final RequestManager instance = new RequestManager();
    }
    private RequestManager() {
        stop();
        createAndStartDispatchers();
    }

    private BitmapDispater[] dispathers;

    private void createAndStartDispatchers() {
        //核心线程数
        int threadCount = Runtime.getRuntime().availableProcessors();
        dispathers = new BitmapDispater[threadCount];
        for (int i = 0; i < dispathers.length; i++) {
            BitmapDispater bitmapDispather = new BitmapDispater(requests);
            bitmapDispather.start();
            dispathers[i] = bitmapDispather;
        }
    }
    private void stop(){
        if(dispathers==null||dispathers.length<1){
            return;
        }
        for (int i = 0; i < dispathers.length; i++) {
            BitmapDispater bitmapDispather=dispathers[i];
            if(!bitmapDispather.isInterrupted()){
                bitmapDispather.interrupt();
            }
        }
    }
}
