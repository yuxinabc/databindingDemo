package com.cass.livedataviewmodeldatabinding.bean;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.cass.livedataviewmodeldatabinding.BR;

/**
 * @Description:可观察对象  可观察字段 ObservableBoolean  可观察集合 ObservableArrayMap、ObservableArrayList
 * @Author: SYX
 * @Copyright: cassInfo
 * @CreateDate: 2020/6/28 10:44 PM
 * @Version: 1.0.0
 */
public class Student extends BaseObservable{
    private String name;
    private int age;
    private String url;
    private boolean showName;
    private int type;
    private boolean circle=true;
   @Bindable
    public boolean isCircle() {
        return circle;
    }

    public void setCircle(boolean circle) {
        this.circle = circle;
        notifyPropertyChanged(BR.circle);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    @Bindable
    public boolean isShowName() {
        return showName;
    }

    public void setShowName(boolean showName) {
        this.showName = showName;
        notifyPropertyChanged(BR.showName);
    }
    @Bindable
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
        System.out.println("姓名"+this.name);
    }
    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
}
