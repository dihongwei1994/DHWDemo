package com.sily.dhwdemo.thread;

import android.app.Activity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadActivity extends Activity {
    Lock lock=new ReentrantLock();

}
