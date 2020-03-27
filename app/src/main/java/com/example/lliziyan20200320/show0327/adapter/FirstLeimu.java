package com.example.lliziyan20200320.show0327.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lliziyan20200320.R;
import com.example.lliziyan20200320.show0327.bean.LeiResult;
import com.example.lliziyan20200320.show0327.bean.SecondCategoryVo;

import java.util.ArrayList;

public class FirstLeimu extends RecyclerView.Adapter<FirstLeimu.MyViewHolder> {
    public Context context;
    public ArrayList<LeiResult> result;

    public FirstLeimu(Context context, ArrayList<LeiResult> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.leimu_left, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final TextView textName = holder.textName;
        final RecyclerView secondRecycler = holder.secondRecycler;
        final LeiResult leiResult = result.get(position);
        final String name = leiResult.name;
        textName.setText(name);
        final ArrayList<SecondCategoryVo> secondCategoryVo = leiResult.secondCategoryVo;
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        secondRecycler.setLayoutManager(linearLayoutManager);
        final RightAdapter rightAdapter = new RightAdapter(context,secondCategoryVo);
        secondRecycler.setAdapter(rightAdapter);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textName;
        private RecyclerView secondRecycler;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = (TextView) itemView.findViewById(R.id.text_name);
            secondRecycler = (RecyclerView) itemView.findViewById(R.id.second_recycler);
        }
    }
}
