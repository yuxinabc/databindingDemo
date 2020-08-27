package com.cass.livedataviewmodeldatabinding.kotlin.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR


class Student : BaseObservable() {
    var name: String? = null
        @Bindable
        get() {
            return field
        }
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    var age: String =""
        @Bindable
        get() {
            return field
        }
        set(value) {
            field = value
            notifyPropertyChanged(BR.age)
        }
}