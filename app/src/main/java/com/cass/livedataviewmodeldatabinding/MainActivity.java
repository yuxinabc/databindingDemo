package com.cass.livedataviewmodeldatabinding;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.cass.livedataviewmodeldatabinding.bean.Student;
import com.cass.livedataviewmodeldatabinding.databinding.ActivityMainBinding;
import com.cass.livedataviewmodeldatabinding.kotlin.KotlinMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding=DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        final Student student = new Student("BBB", 18);
        student.setUrl("http://ww4.sinaimg.cn/bmiddle/6910ab7bgw1egloghsfi3j20b40b40t6.jpg");
        binding.setVariable(BR.student,student);
        binding.setIsError(true);
        binding.btGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });
        binding.etText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.etText.setSelection(charSequence.length());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.btLiveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LiveDataViewModelActivity.class);
                startActivity(intent);
            }
        });
        binding.btKotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, KotlinMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
