package com.cass.livedataviewmodeldatabinding.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.cass.livedataviewmodeldatabinding.bean.User;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: SYX
 * @Copyright: cassInfo
 * @CreateDate: 2020/7/21 10:32 AM
 * @Version: 1.0.0
 */
public class UserViewModel extends AndroidViewModel {
    private MutableLiveData<User> userLiveData;
    private MutableLiveData<String> name;
    private MutableLiveData<ArrayList<User>> listMutableLiveData;
    private String[] strings=new String[]{"http://a.hiphotos.baidu.com/zhidao/wh=450,600/sign=bbba1da0d60735fa91a546bdab612385/9825bc315c6034a84e7d073ac9134954082376e9.jpg",
            "http://gss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/267f9e2f07082838685c484ab999a9014c08f11f.jpg"
    };
    public UserViewModel(@NonNull Application application) {
        super(application);
        userLiveData=new MutableLiveData<>();
        User user=new User("origin",11);
        userLiveData.setValue(user);

        name=new MutableLiveData<>();
        name.setValue("origin");

        listMutableLiveData=new MutableLiveData<>();
        ArrayList<User> observableArrayList=new ArrayList<>();
        for(int i=0;i<10;i++){
            User student=new User("aaa"+i,i*2);
            student.setType((int) Math.floor(Math.random() * 2));
            student.setUrl(strings[(int) Math.floor(Math.random() * 2)]);
            observableArrayList.add(student);
        }
        listMutableLiveData.setValue(observableArrayList);
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<User> getUserLiveData() {
        return userLiveData;
    }

    public MutableLiveData<ArrayList<User>> getListMutableLiveData() {
        return listMutableLiveData;
    }
}
