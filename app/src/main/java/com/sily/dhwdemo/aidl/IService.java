package com.sily.dhwdemo.aidl;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.sily.dhwdemo.aidl.IMyService;
import com.sily.dhwdemo.aidl.Student;

import java.util.ArrayList;
import java.util.List;

public class IService extends Service {
    private List<Student> mStudents;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }

    IMyService.Stub stub = new IMyService.Stub() {
        @Override
        public List<Student> getStudent() throws RemoteException {
            Log.d("Myservice","设置数据");
            mStudents = new ArrayList<>();
            Student student = new Student();
            student.name="haha";
            mStudents.add(student);
            return mStudents;
        }

        @Override
        public void addStudent(Student student) throws RemoteException {

        }
    };
}


