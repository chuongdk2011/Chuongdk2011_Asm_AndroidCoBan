package com.example.chuongdkph26546_asm.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chuongdkph26546_asm.DAO.LoaiChiDAO;
import com.example.chuongdkph26546_asm.DAO.LoaiThuDAO;
import com.example.chuongdkph26546_asm.DTO.LoaiChiDTO;
import com.example.chuongdkph26546_asm.DTO.LoaiThuDTO;
import com.example.chuongdkph26546_asm.R;

import java.util.ArrayList;

public class LoaiChiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    ArrayList<LoaiChiDTO> list;
    OnclickChi onclickChi;

    Context context;

    public LoaiChiAdapter(Context context,ArrayList<LoaiChiDTO> list,OnclickChi onclickChi){
        this.context=context;
        this.list=list;
        this.onclickChi=onclickChi;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loaichi,parent,false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LoaiChiDTO obj = list.get(position);
        LoaiChiAdapter.ItemViewHolder viewHolder = (LoaiChiAdapter.ItemViewHolder) holder;

        viewHolder.tv_tenchi.setText(obj.getId()+"."+obj.getTenLoaiChi());

        Log.i("hahaha", "onBindViewHolder: "+viewHolder.tv_tenchi);


        viewHolder.img_xoachi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickChi.xoa(obj);
            }
        });
        viewHolder.img_suachi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickChi.capnhat(obj);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tenchi;
        ImageView img_xoachi,img_suachi;

        public ItemViewHolder(View view) {
            super(view);
            tv_tenchi = view.findViewById(R.id.tv_tenchi);
            img_xoachi = view.findViewById(R.id.img_xoachi);
            img_suachi = view.findViewById(R.id.img_suachi);

        }

    }
    public  interface OnclickChi{
        void xoa(LoaiChiDTO loaiChiDTODTO);

        void  capnhat(LoaiChiDTO loaiChiDTO);
    }
}
