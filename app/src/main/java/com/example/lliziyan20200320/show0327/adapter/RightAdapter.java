package com.example.lliziyan20200320.show0327.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lliziyan20200320.R;
import com.example.lliziyan20200320.show0327.bean.SecondCategoryVo;

import java.util.ArrayList;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.MyViewHolder> {
    public Context context;
    public ArrayList<SecondCategoryVo> secondCategoryVo;

    public RightAdapter(Context context, ArrayList<SecondCategoryVo> secondCategoryVo) {
        this.context = context;
        this.secondCategoryVo = secondCategoryVo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.leimu_right, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final TextView namem = holder.namem;
        final SecondCategoryVo secondCategoryVo = this.secondCategoryVo.get(position);
        final String name = secondCategoryVo.name;
        namem.setText(name);
    }

    @Override
    public int getItemCount() {
        return secondCategoryVo.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView namem;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            namem = (TextView) itemView.findViewById(R.id.namem);
        }
    }
}
