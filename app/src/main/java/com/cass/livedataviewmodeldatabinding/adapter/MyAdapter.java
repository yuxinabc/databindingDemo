package com.cass.livedataviewmodeldatabinding.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.cass.livedataviewmodeldatabinding.BR;
import com.cass.livedataviewmodeldatabinding.R;
import com.cass.livedataviewmodeldatabinding.bean.Student;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
   private ViewDataBinding binding;
   private List<Student> list;
    public MyAdapter(List<Student> list) {
        this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),viewType,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(binding.getRoot(),binding);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        Student student = list.get(position);
        if(student.getType()==0){
            return R.layout.item_one;
        }else if(student.getType()==1){
            return R.layout.item_two;
        }
        return 0;
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder{
        private ViewDataBinding binding;
        public MyViewHolder(View root, ViewDataBinding binding) {
            super(root);
            this.binding=binding;
        }
        public void bind(Student student){
            binding.setVariable(BR.student,student);
            //即时绑定
            //当可变或可观察对象发生更改时，绑定会按照计划在下一帧之前发生更改。但有时必须立即执行绑定。要强制执行，请使用 executePendingBindings() 方法
            binding.executePendingBindings();

        }
    }
}
