package com.example.lliziyan20200320.Show0326.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lliziyan20200320.R;
import com.example.lliziyan20200320.Show0326.bean.ResultShop;
import com.example.lliziyan20200320.Show0326.bean.ShoppingCartList;
import com.example.lliziyan20200320.Show0326.net.ImageUtil;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder> {
    public Context context;
    public ArrayList<ResultShop> result;

    public ShopAdapter(Context context, ArrayList<ResultShop> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.shopadapter, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ResultShop resultShop = result.get(position);
        final ArrayList<ShoppingCartList> shoppingCartList = resultShop.shoppingCartList;
        final ShoppingCartList shoppingCartList1 = shoppingCartList.get(0);
        final String commodityName = shoppingCartList1.commodityName;
        final String pic = shoppingCartList1.pic;
        final double price = shoppingCartList1.price;
        final ImageView imageShop = holder.imageShop;
        final TextView tvNamePrice = holder.tvNamePrice;
        final TextView tvNameShop = holder.tvNameShop;
        final CheckBox checkShop = holder.checkShop;
        tvNameShop.setText(commodityName);
        tvNamePrice.setText("￥"+price);
        final ImageUtil instance = ImageUtil.getInstance();
        instance.getImage(pic,imageShop);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkShop;
        private ImageView imageShop;
        private TextView tvNameShop;
        private TextView tvNamePrice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            checkShop = (CheckBox) itemView.findViewById(R.id.check_shop);
            imageShop = (ImageView) itemView.findViewById(R.id.image_shop);
            tvNameShop = (TextView) itemView.findViewById(R.id.tv_name_shop);
            tvNamePrice = (TextView) itemView.findViewById(R.id.tv_name_price);
        }
    }
}
