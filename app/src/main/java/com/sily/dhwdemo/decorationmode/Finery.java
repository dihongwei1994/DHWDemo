package com.sily.dhwdemo.decorationmode;

/**
 * 服饰类decorate
 */
public class Finery extends Person{
    protected Person person;
    //打扮
    public void decorate(Person person){
        this.person=person;
    }
    @Override
    public void show() {
        if(person!=null){
            person.show();
        }
    }
}
