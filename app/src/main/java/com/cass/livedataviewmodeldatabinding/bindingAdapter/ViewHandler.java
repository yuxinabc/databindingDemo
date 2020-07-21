package com.cass.livedataviewmodeldatabinding.bindingAdapter;
import android.os.Handler;
import android.os.Looper;
import androidx.databinding.ObservableField;
import com.cass.livedataviewmodeldatabinding.bean.Student;

/**
 * @Description:
 * @Author: SYX
 * @Copyright: cassInfo
 * @CreateDate: 2020/7/19 5:58 PM
 * @Version: 1.0.0
 */
public class ViewHandler {
    public static ObservableField<String> show(Student student){
        final ObservableField<String> stringObservableField = new ObservableField<>(("姓名： " + student.getName() + "  年龄： " + student.getAge()));
        notifyChange(stringObservableField);
        return stringObservableField ;
    }

    private static void notifyChange(final ObservableField<String> stringObservableField) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                stringObservableField.notifyChange();
            }
        });
    }
}
