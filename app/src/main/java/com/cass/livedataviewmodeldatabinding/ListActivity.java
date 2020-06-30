package com.cass.livedataviewmodeldatabinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.cass.livedataviewmodeldatabinding.adapter.MyAdapter;
import com.cass.livedataviewmodeldatabinding.bean.Student;
import com.cass.livedataviewmodeldatabinding.databinding.ActivityListBinding;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ActivityListBinding binding;
    private String[] strings=new String[]{"http://a.hiphotos.baidu.com/zhidao/wh=450,600/sign=bbba1da0d60735fa91a546bdab612385/9825bc315c6034a84e7d073ac9134954082376e9.jpg",
            "http://gss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/267f9e2f07082838685c484ab999a9014c08f11f.jpg"
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_list);
        List<Student> students=new ArrayList<>();
        for(int i=0;i<60;i++){
            Student student=new Student("aaa"+i,i*2);
            student.setType((int) Math.floor(Math.random() * 2));
            student.setUrl(strings[(int) Math.floor(Math.random() * 2)]);
            students.add(student);
        }
        MyAdapter adapter=new MyAdapter(students);
        binding.list.setAdapter(adapter);
        binding.setLifecycleOwner(this);
    }
}
