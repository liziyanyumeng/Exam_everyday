package com.example.lliziyan20200320.Order0402.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lliziyan20200320.App;
import com.example.lliziyan20200320.R;

public class ImageUtil {
    private static ImageUtil instance;
    private ImageUtil() {}

    public static ImageUtil getInstance() {
        if (instance == null) {
            instance = new ImageUtil();
        }
        return instance;
    }
    public void ordershow(String path, ImageView imageView){
        Glide.with(App.context)
                .load(path)
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
