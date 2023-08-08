package com.example.chuongdkph26546_asm.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chuongdkph26546_asm.DAO.LoaiChiDAO;
import com.example.chuongdkph26546_asm.DAO.LoaiThuDAO;
import com.example.chuongdkph26546_asm.DTO.LoaiThuDTO;
import com.example.chuongdkph26546_asm.R;

import java.util.ArrayList;

public class LoaiThuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<LoaiThuDTO> list;
    Context context;

    OnclickThu onclickThu;


    public LoaiThuAdapter(Context context,ArrayList<LoaiThuDTO> list, OnclickThu onclickThu){
        this.context = context;
        this.list = list;
        this.onclickThu = onclickThu;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loaithu, parent, false);


        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,  int position) {
        LoaiThuDTO obj = list.get(position);
        ItemViewHolder viewHolder = (ItemViewHolder) holder;

        viewHolder.tv_tenthu.setText(obj.getId()+"."+obj.getTenLoaiThu());

        Log.i("hahaha", "onBindViewHolder: "+viewHolder.tv_tenthu);



        viewHolder.img_xoathu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickThu.xoa(obj);
            }
        });
        viewHolder.img_suathu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickThu.capnhat(obj);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tenthu;
        ImageView img_xoathu,img_suathu;

        public ItemViewHolder(View view) {
            super(view);
            tv_tenthu = view.findViewById(R.id.tv_tenthu);
            img_xoathu = view.findViewById(R.id.img_xoathu);
            img_suathu = view.findViewById(R.id.img_suathu);

        }

    }


    public  interface OnclickThu{
        void xoa(LoaiThuDTO loaiThuDTO);

        void capnhat(LoaiThuDTO loaiThuDTO);
    }
}
