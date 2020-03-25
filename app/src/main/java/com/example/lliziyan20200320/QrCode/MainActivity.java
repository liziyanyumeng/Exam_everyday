package com.example.lliziyan20200320.QrCode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lliziyan20200320.R;
import com.uuzuche.lib_zxing.activity.CodeUtils;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;
    private Button btnSc;
    private EditText etText;
    private ImageView image;
    private Bitmap mBitmap;
    private TableLayout tablayout;
    private FragmentAdapter fragmentAdapter;
    private LinearLayout linear;
    private String textContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnSc = (Button) findViewById(R.id.btn_sc);
        etText = (EditText) findViewById(R.id.et_text);
        image = (ImageView) findViewById(R.id.image);
        dianji();
        tablayout = (TableLayout) findViewById(R.id.tablayout);
    }

    //设置点击事件
    public void dianji() {
        btnSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textContent = etText.getText().toString();
                if (TextUtils.isEmpty(textContent)) {
                    Toast.makeText(MainActivity.this, "您的输入为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                etText.setText(textContent);
                mBitmap = CodeUtils.createImage(textContent, 400, 400, null);
                image.setImageBitmap(mBitmap);
            }
        });
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        //点击图片进行吐司
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "二维码的信息是"+textContent, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
