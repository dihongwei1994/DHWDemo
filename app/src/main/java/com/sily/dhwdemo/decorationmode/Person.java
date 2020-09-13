package com.sily.dhwdemo.decorationmode;

import android.util.Log;

/**
 * 装饰模式
 */
public class Person {
    private String name;
    public Person(){

    }
    public Person(String name){
        this.name=name;
    }
    public void show(){
        Log.i("dhw", "装扮的 "+name);
    }
}
