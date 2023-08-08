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

import com.example.chuongdkph26546_asm.DAO.KhoanChiDAO;
import com.example.chuongdkph26546_asm.DTO.KhoanChiDTO;
import com.example.chuongdkph26546_asm.R;

import java.util.ArrayList;

public class KhoanChiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    ArrayList<KhoanChiDTO> list;
    OnclickKhoanChi onclickKhoanChi;
    KhoanChiDAO dao;
    Context context;

    public KhoanChiAdapter(Context context,ArrayList<KhoanChiDTO> list, OnclickKhoanChi onclickKhoanChi){
        this.context = context;
        this.list = list;
        this.onclickKhoanChi = onclickKhoanChi;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_khoanchi,parent,false);


        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        KhoanChiDTO obj = list.get(position);
        KhoanChiAdapter.ItemViewHolder viewHolder = (KhoanChiAdapter.ItemViewHolder) holder;

        viewHolder.tv_tenkhoanchi.setText("Khoản Chi:"+obj.getTenKhoanChi());
        viewHolder.tv_ngaychi.setText("Ngày: "+obj.getNgayChi());
        viewHolder.tv_nguoichi.setText("Người Chi: "+obj.getHoTenNguoiChi());
        viewHolder.tv_ghichuchi.setText("Ghi Chú: "+obj.getGhiChu());
        viewHolder.tv_sotienchi.setText("Số Tiền: "+obj.getSoTien());




        viewHolder.img_xoakhoanchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickKhoanChi.xoa(obj);
            }
        });
        viewHolder.img_suakhoanchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickKhoanChi.capnhat(obj);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tenkhoanchi,tv_ngaychi,tv_sotienchi,tv_ghichuchi,tv_nguoichi;

        ImageView img_xoakhoanchi,img_suakhoanchi;

        public ItemViewHolder(View view) {
            super(view);

            tv_tenkhoanchi = view.findViewById(R.id.tv_tenkhoanchi);
            tv_ngaychi = view.findViewById(R.id.tv_ngaychi);
            tv_sotienchi = view.findViewById(R.id.tv_sotienchi);
            tv_nguoichi = view.findViewById(R.id.tv_nguoichi);
            tv_ghichuchi = view.findViewById(R.id.tv_ghichuchi);

            img_xoakhoanchi = view.findViewById(R.id.img_xoakhoanchi);
            img_suakhoanchi = view.findViewById(R.id.img_suakhoanchi);

        }

    }
    public  interface  OnclickKhoanChi{
        void xoa(KhoanChiDTO khoanChiDTO);

        void capnhat(KhoanChiDTO khoanChiDTO);
    }
}
