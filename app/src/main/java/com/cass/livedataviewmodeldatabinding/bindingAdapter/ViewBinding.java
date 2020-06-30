package com.cass.livedataviewmodeldatabinding.bindingAdapter;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.cass.livedataviewmodeldatabinding.PixUtils;
import com.cass.livedataviewmodeldatabinding.view.MyTextView;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * @Description:
 * @Author: SYX
 * @Copyright: cassInfo
 * @CreateDate: 2020/6/29 10:14 AM
 * @Version: 1.0.0
 */
@BindingMethods(
        value = {
            @BindingMethod(type = com.cass.livedataviewmodeldatabinding.view.MyTextView.class, attribute = "app:color", method = "setColorHH")
        }
)
public class ViewBinding {
    @BindingAdapter(value = {"imageUrl", "isCircle", "radius"}, requireAll = false)
    public static void setImage(ImageView view, String imageUrl, boolean isCircle, int radius) {
        RequestBuilder<Drawable> builder = Glide.with(view).load(imageUrl);
        if (isCircle) {
            builder.transform(new CircleCrop());
        } else if (radius > 0) {
            builder.transform(new RoundedCornersTransformation(PixUtils.dp2px(radius), 0));
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            builder.override(layoutParams.width, layoutParams.height);
        }
        builder.into(view);

    }
    @BindingAdapter("text")
    public static void setText(MyTextView view, String newValue) {
        // Important to break potential infinite loops.
        String text = view.getText();
        if(!newValue.equals(text)){
            view.setText(newValue);
        }
    }
    @InverseBindingAdapter(attribute = "text", event = "textAttrChanged")
    public static String getText(MyTextView view) {
        return view.getText();
    }
    @BindingAdapter("textAttrChanged")
    public static void bindListener(MyTextView view, final InverseBindingListener attrChange) {
        if (attrChange == null) {
            view.setListener(null);
        } else {
            view.setListener(attrChange);
        }
    }
}
