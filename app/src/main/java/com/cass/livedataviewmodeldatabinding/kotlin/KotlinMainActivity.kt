package com.cass.livedataviewmodeldatabinding.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.cass.livedataviewmodeldatabinding.R
import com.cass.livedataviewmodeldatabinding.databinding.ActivityKotlinMainBinding
import com.cass.livedataviewmodeldatabinding.kotlin.bean.Student

class KotlinMainActivity : AppCompatActivity() {
    private  val binding by lazy {
        DataBindingUtil.setContentView<ActivityKotlinMainBinding>(this,R.layout.activity_kotlin_main)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val student= Student()
        student.name="dddd"
        binding.student=student
    }
}