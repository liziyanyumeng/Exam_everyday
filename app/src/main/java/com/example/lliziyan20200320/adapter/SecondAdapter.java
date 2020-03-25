package com.example.lliziyan20200320.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lliziyan20200320.R;
import com.example.lliziyan20200320.bean.CommodityListBean;
import com.example.lliziyan20200320.bean.PzshBean;
import com.example.lliziyan20200320.bean.ResultBean;
import com.example.lliziyan20200320.util.ImageUtil;

import java.util.ArrayList;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.MyViewHolder> {
    public Context context;
    public ArrayList<ResultBean> result;

    public SecondAdapter(Context context, ArrayList<ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.pingzhi_adapter, parent, true);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ResultBean resultBean = result.get(position);
        final ArrayList<PzshBean> pzsh = resultBean.pzsh;
        final PzshBean pzshBean = pzsh.get(position);
        final ArrayList<CommodityListBean> commodityList = pzshBean.commodityList;
        final CommodityListBean commodityListBean = commodityList.get(position);
        final String commodityName = commodityListBean.commodityName;
        final String masterPic = commodityListBean.masterPic;
        final double price = commodityListBean.price;
        final TextView textName = holder.textName;
        final ImageView imagePic = holder.imagePic;
        final TextView textPrice = holder.textPrice;
        textName.setText(commodityName);
        textPrice.setText("￥"+price);
        final ImageUtil instance = ImageUtil.getInstance();
        instance.getImage(masterPic,imagePic);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagePic;
        private TextView textName;
        private TextView textPrice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePic = (ImageView) itemView.findViewById(R.id.image_pic);
            textName = (TextView) itemView.findViewById(R.id.text_name);
            textPrice = (TextView) itemView.findViewById(R.id.text_price);
        }
    }
}
