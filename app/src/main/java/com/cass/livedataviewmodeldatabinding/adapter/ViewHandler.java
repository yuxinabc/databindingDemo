package com.cass.livedataviewmodeldatabinding.adapter;

import androidx.databinding.Bindable;

import com.cass.livedataviewmodeldatabinding.bean.Student;

/**
 * @Description:
 * @Author: SYX
 * @Copyright: cassInfo
 * @CreateDate: 2020/7/19 5:58 PM
 * @Version: 1.0.0
 */
public class ViewHandler {
    public static String show(Student student){
        return "姓名： "+student.getName()+"  年龄： "+student.getAge();
    }
}
