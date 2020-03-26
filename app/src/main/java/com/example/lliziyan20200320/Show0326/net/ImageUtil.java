package com.example.lliziyan20200320.Show0326.net;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lliziyan20200320.App;

public class ImageUtil {
    private static ImageUtil instance;
    private ImageUtil() {}
    public static ImageUtil getInstance() {
        if (instance == null) {
            instance = new ImageUtil();
        }
        return instance;
    }
    public void getImage(String path, ImageView imageView){
        Glide.with(App.context).load(path).into(imageView);
    }
}
