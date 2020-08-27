package com.cass.livedataviewmodeldatabinding.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.cass.livedataviewmodeldatabinding.BR;


public class User extends BaseObservable {
    private String name;
    private String passWord;
    private int type;
    private int age;
    private String url;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
