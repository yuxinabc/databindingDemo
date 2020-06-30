package com.cass.livedataviewmodeldatabinding.model;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.cass.livedataviewmodeldatabinding.bean.Student;


/**
 * @Description:
 * @Author: SYX
 * @Copyright: cassInfo
 * @CreateDate: 2020/6/29 11:47 AM
 * @Version: 1.0.0
 */
public class StudentModel extends ViewModel {
    public static void change(View view,Student student){
        if(view!=null){
            student.setAge((int) (Math.random()*100+6));
            student.setName("aaaaaa"+(int) (Math.random()*100+6));
            student.setShowName(true);
        }
    }
    public static void changeItem(Student student){
        student.setAge((int) (Math.random()*100+6));
        student.setName("aaaaaa"+(int) (Math.random()*100+6));
    }
}
