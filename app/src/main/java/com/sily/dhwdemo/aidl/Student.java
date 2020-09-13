package com.sily.dhwdemo.aidl;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Locale;

public class Student implements Parcelable {
    public String name;

    Student(Parcel in) {
        readFromParcel(in);
    }

    public Student() {
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    public void readFromParcel(Parcel in) {
        name = in.readString();
    }

    @NonNull
    @Override
    public String toString() {
        return String.format(Locale.ENGLISH,"Student[%s]",name);
    }
}
