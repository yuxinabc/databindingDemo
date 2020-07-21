package com.cass.livedataviewmodeldatabinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.cass.livedataviewmodeldatabinding.adapter.MyAdapter;
import com.cass.livedataviewmodeldatabinding.adapter.UserAdapter;
import com.cass.livedataviewmodeldatabinding.bean.User;
import com.cass.livedataviewmodeldatabinding.databinding.ActivityLiveDataViewModelBinding;
import com.cass.livedataviewmodeldatabinding.model.UserViewModel;

public class LiveDataViewModelActivity extends AppCompatActivity {
   private ActivityLiveDataViewModelBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserViewModel userModel = new ViewModelProvider(this).get(UserViewModel.class);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_live_data_view_model);
        binding.setLifecycleOwner(this);
        binding.setModel(userModel);
        UserAdapter userAdapter=new UserAdapter(userModel.getListMutableLiveData().getValue());
        binding.rlv.setAdapter(userAdapter);
    }
}