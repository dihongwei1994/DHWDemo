package com.sily.dhwdemo.decorationmode;

import android.util.Log;

public class LanuchActivity {
    public static void main(){
        Person person=new Person("邸宏伟");
        Log.i("dhw", "第一次装扮");
        TShirts tShirts=new TShirts();
        BIgTrouser bIgTrouser=new BIgTrouser();
        tShirts.decorate(person);
        bIgTrouser.decorate(tShirts);
        bIgTrouser.show();
    }
    public static void main1(){
        Person person=new Person("邸宏伟");
        Log.i("dhw", "第二次装扮");
        TShirts tShirts=new TShirts();
        BIgTrouser bIgTrouser=new BIgTrouser();

        bIgTrouser.decorate(person);
        tShirts.decorate(bIgTrouser);
        tShirts.show();
    }
}
