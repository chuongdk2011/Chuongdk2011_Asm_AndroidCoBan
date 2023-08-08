package com.example.chuongdkph26546_asm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chuongdkph26546_asm.DAO.KhoanChiDAO;
import com.example.chuongdkph26546_asm.DAO.KhoanThuDAO;
import com.example.chuongdkph26546_asm.DTO.KhoanChiDTO;
import com.example.chuongdkph26546_asm.DTO.KhoanThuDTO;
import com.example.chuongdkph26546_asm.R;

import java.util.ArrayList;

public class KhoanThuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    ArrayList<KhoanThuDTO> list;
    OnclickKhoanThu onclickKhoanThu;

    Context context;

    public KhoanThuAdapter(Context context,ArrayList<KhoanThuDTO> list, OnclickKhoanThu onclickKhoanThu){
        this.context = context;
        this.list = list;
        this.onclickKhoanThu=onclickKhoanThu;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_khoanthu,parent,false);


        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        KhoanThuDTO obj = list.get(position);
        KhoanThuAdapter.ItemViewHolder viewHolder = (KhoanThuAdapter.ItemViewHolder) holder;

        viewHolder.tv_tenkhoanthu.setText("Khoản thu: "+obj.getTenKhoanThu());
        viewHolder.tv_ngaythu.setText("Ngày: "+obj.getNgayThu());
        viewHolder.tv_nguoithu.setText("Người thu:"+obj.getHoTenNguoiThu());
        viewHolder.tv_ghichuthu.setText("Ghi Chú:"+obj.getGhiChu());
        viewHolder.tv_sotienthu.setText("Số tiền: "+obj.getSoTien()+"");




        viewHolder.img_xoakhoanthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickKhoanThu.xoa(obj);
            }
        });
        viewHolder.img_suakhoanthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickKhoanThu.capnhat(obj);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tenkhoanthu,tv_ngaythu,tv_sotienthu,tv_ghichuthu,tv_nguoithu;

        ImageView img_xoakhoanthu,img_suakhoanthu;

        public ItemViewHolder(View view) {
            super(view);

            tv_tenkhoanthu = view.findViewById(R.id.tv_tenkhoanthu);
            tv_ngaythu = view.findViewById(R.id.tv_ngaythu);
            tv_sotienthu = view.findViewById(R.id.tv_sotienthu);
            tv_nguoithu = view.findViewById(R.id.tv_nguoithu);
            tv_ghichuthu = view.findViewById(R.id.tv_ghichuthu);

            img_xoakhoanthu= view.findViewById(R.id.img_xoakhoanthu);
            img_suakhoanthu = view.findViewById(R.id.img_suakhoanthu);

        }

    }
    public  interface  OnclickKhoanThu{
        void xoa(KhoanThuDTO khoanThuDTO);

        void capnhat(KhoanThuDTO khoanThuDTO);
    }
}
