package com.example.lliziyan20200320.Order0402.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lliziyan20200320.Order0402.bean.DetailListBean;
import com.example.lliziyan20200320.Order0402.util.ImageUtil;
import com.example.lliziyan20200320.R;

import java.util.ArrayList;
//内层显示的适配器
public class LiAdapter extends RecyclerView.Adapter<LiAdapter.MyViewHolder> {
    public Context context;
    public ArrayList<DetailListBean> detailList;

    public LiAdapter(Context context, ArrayList<DetailListBean> detailList) {
        this.context = context;
        this.detailList = detailList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.li_adapter, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ImageView imageOrder = holder.imageOrder;
        final TextView textCount = holder.textCount;
        final TextView textOrdername = holder.textOrdername;
        final TextView textPrice = holder.textPrice;
        final DetailListBean detailListBean = detailList.get(position);
        final int commodityCount = detailListBean.commodityCount;
        final String commodityName = detailListBean.commodityName;
        final String commodityPic = detailListBean.commodityPic;
        final double commodityPrice = detailListBean.commodityPrice;
        textCount.setText("X"+commodityCount);
        textOrdername.setText(commodityName);
        textPrice.setText("￥"+commodityPrice);
        //进行分割字符串
        final String[] split = commodityPic.split(",");
        final ImageUtil instance = ImageUtil.getInstance();
        instance.ordershow(split[0],imageOrder);
    }

    @Override
    public int getItemCount() {
        return detailList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageOrder;
        private TextView textOrdername;
        private TextView textPrice;
        private TextView textCount;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageOrder = (ImageView) itemView.findViewById(R.id.image_order);
            textOrdername = (TextView) itemView.findViewById(R.id.text_ordername);
            textPrice = (TextView) itemView.findViewById(R.id.text_price);
            textCount = (TextView) itemView.findViewById(R.id.text_count);
        }
    }
}
