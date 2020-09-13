package com.sily.dhwdemo.aidl;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.sily.dhwdemo.MainActivity;
import com.sily.dhwdemo.R;

import java.util.ArrayList;
import java.util.List;

public class MyService extends Service {
    private final static String TAG = "MyService";
    private final static String PACKAGE_SAYHI = "com.sily.dhwdemo.aidl";
    private NotificationManager manager;
    private boolean mCanRun = true;
    private List<Student> mStudents ;

    @Override
    public void onCreate() {
        super.onCreate();
        mStudents = new ArrayList<>();
    }

    //实现aidl抽象函数```
    private IMyService.Stub mBinder = new IMyService.Stub() {
        @Override
        public List<Student> getStudent() throws RemoteException {
//            synchronized (mStudents) {
            for(int i=1;i<6;i++){
                Student student=new Student();
                student.name="student"+i;
                mStudents.add(student);
            }
                return mStudents;
        }

        @Override
        public void addStudent(Student student) throws RemoteException {


        }
        //在这里可以做权限认证，return false意味着客户端的调用就会失败，比如下面，只允许包名为com.example.test的客户端通过，
        //其他apk将无法完成调用过程
//        public boolean onTransact(int code, Parcel data, Parcel reply, int flags)
//                throws RemoteException {
//
////            String packageName = null;
////            String[] packages = MyService.this.getPackageManager().
////                    getPackagesForUid(getCallingUid());
////            if (packages != null && packages.length > 0) {
////                packageName = packages[0];
////            }
//           // Log.d(TAG, "onTransact: " + packageName);
//        //    Log.d(TAG, "onTransact: " + PACKAGE_SAYHI);
//
////            if (!PACKAGE_SAYHI.equals(packageName)) {
////                return false;
////            }
//
//            return true;
//       }
    };

    @Override
    public IBinder onBind(Intent intent) {
//        Log.d(TAG, String.format("on bind ,intent =%s", intent.toString()));
//        try {
//            Log.i(TAG, "onBind: "+mBinder.getStudent().get(0));
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//        //displayNotificationMessage("服务以启动");
//        Log.i(TAG, "======"+mBinder.toString()+"==========");
        return mBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    private void displayNotificationMessage(String message) {
        Notification notification = new Notification(R.drawable.ic_launcher_background, message, System.currentTimeMillis());
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.DEFAULT_ALL;
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
        notification.contentIntent = pendingIntent;
        manager.notify(2, notification);
    }

    class Servicework implements Runnable {
        int counter = 0;

        @Override
        public void run() {
            while (mCanRun) {
                Log.d(TAG, " " + counter);
                counter++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onDestroy() {
        mCanRun = false;
        super.onDestroy();
    }
}
