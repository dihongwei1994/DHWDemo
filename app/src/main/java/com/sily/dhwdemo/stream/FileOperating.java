package com.sily.dhwdemo.stream;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

public class FileOperating  {
    public static void main(String[] args) {
        try {
            writeTxt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void onCreate() {

        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("/Users/hongweidi/Desktop/a.txt");
            fileWriter = new FileWriter("/Users/hongweidi/Desktop/b.txt");
            int len = -1;
            char[] chars = new char[1024];
            while ((len = fileReader.read(chars)) != -1) {
                fileWriter.write(chars, 0, len);
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void writeTxt() throws IOException {
        FileOutputStream fos=new FileOutputStream("app\\a.txt");
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fos);
        bufferedOutputStream.write("hfdshfksjfh".getBytes());
        bufferedOutputStream.flush();
       // InputStreamReader reader=new InputStreamReader();
       // ObjectOutputStream
    }
}
