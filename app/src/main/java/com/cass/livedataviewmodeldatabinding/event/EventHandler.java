package com.cass.livedataviewmodeldatabinding.event;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.cass.livedataviewmodeldatabinding.bean.Student;
import com.cass.livedataviewmodeldatabinding.bean.User;
import com.cass.livedataviewmodeldatabinding.model.UserViewModel;


/**
 * @Description:
 * @Author: SYX
 * @Copyright: cassInfo
 * @CreateDate: 2020/6/29 11:47 AM
 * @Version: 1.0.0
 */
public class EventHandler{
    public static void change(View view,Student student){
        if(view!=null){
            student.setAge((int) (Math.random()*100+6));
            student.setName("aaaaaa"+(int) (Math.random()*100+6));
            student.setShowName(true);
        }
    }
    public static void changeUrl(View view,Student student){
        if(view!=null){
            student.setCircle(false);
            student.setUrl("https://image.baidu.com/search/down?tn=download&ipn=dwnl&word=download&ie=utf8&fr=result&url=http%3A%2F%2Fgss0.baidu.com%2F7Po3dSag_xI4khGko9WTAnF6hhy%2Fzhidao%2Fpic%2Fitem%2F267f9e2f07082838685c484ab999a9014c08f11f.jpg&thumburl=https%3A%2F%2Fss3.bdstatic.com%2F70cFv8Sh_Q1YnxGkpoWK1HF6hhy%2Fit%2Fu%3D1055388296%2C1425226147%26fm%3D26%26gp%3D0.jpg");
        }
    }
    public static void changeItem(Student student){
        student.setAge((int) (Math.random()*100+6));
        student.setName("aaaaaa"+(int) (Math.random()*100+6));
    }
    public static void changeUserName(UserViewModel model){
        MutableLiveData<User> userLiveData = model.getUserLiveData();
        User value = userLiveData.getValue();
        value.setName("changeUserName");
        userLiveData.postValue(value);

        model.getName().setValue("changeUserName");
    }
    public static void changeUserItem(User student){
        student.setAge((int) (Math.random()*100+6));
        student.setName("aaaaaa"+(int) (Math.random()*100+6));
    }
}
