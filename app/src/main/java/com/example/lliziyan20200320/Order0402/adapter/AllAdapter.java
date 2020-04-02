package com.example.lliziyan20200320.Order0402.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lliziyan20200320.Order0402.bean.DetailListBean;
import com.example.lliziyan20200320.Order0402.bean.OrderListBean;
import com.example.lliziyan20200320.R;

import java.util.ArrayList;
//外层显示的适配器
public class AllAdapter extends RecyclerView.Adapter<AllAdapter.OrderViewHolder> {
    public Context context;
    public ArrayList<OrderListBean> orderList;

    public AllAdapter(Context context, ArrayList<OrderListBean> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.all_adapter, parent, false);
        return new OrderViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        final TextView textName = holder.textName;
        final TextView textOrderId = holder.textOrderId;
        final RecyclerView lirecycler = holder.lirecycler;
        final OrderListBean orderListBean = orderList.get(position);
        final String expressCompName = orderListBean.expressCompName;
        final String orderId = orderListBean.orderId;
        final ArrayList<DetailListBean> detailList = orderListBean.detailList;
        textName.setText(expressCompName);
        textOrderId.setText(orderId);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        lirecycler.setLayoutManager(linearLayoutManager);
        final LiAdapter liAdapter = new LiAdapter(context,detailList);
        lirecycler.setAdapter(liAdapter);
    }


    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        private TextView textName;
        private TextView textOrderId;
        private RecyclerView lirecycler;
        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = (TextView) itemView.findViewById(R.id.text_name);
            textOrderId = (TextView) itemView.findViewById(R.id.text_orderId);
            lirecycler = (RecyclerView) itemView.findViewById(R.id.lirecycler);
        }
    }
}
