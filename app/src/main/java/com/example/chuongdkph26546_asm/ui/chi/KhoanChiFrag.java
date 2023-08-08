package com.example.chuongdkph26546_asm.ui.chi;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chuongdkph26546_asm.Adapter.KhoanChiAdapter;
import com.example.chuongdkph26546_asm.DAO.KhoanChiDAO;

import com.example.chuongdkph26546_asm.DTO.KhoanChiDTO;
import com.example.chuongdkph26546_asm.DTO.LoaiChiDTO;
import com.example.chuongdkph26546_asm.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class KhoanChiFrag extends Fragment implements KhoanChiAdapter.OnclickKhoanChi {

    KhoanChiAdapter adapter;
    KhoanChiDAO dao;
    RecyclerView rcv;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_khoan_chi, container, false);

        rcv = view.findViewById(R.id.rcv_khoanchi);
        dao = new KhoanChiDAO(getActivity().getApplicationContext());
        dao.open();

        showdata();

        Log.i("hahahaha", "onCreateView: "+dao.selectAll().size());


        FloatingActionButton fab = view.findViewById(R.id.fab_khoanchi);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialogAdd();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void showdata(){
        adapter = new KhoanChiAdapter(getContext().getApplicationContext(), dao.selectAll(),this);
        rcv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    public void showdialogAdd(){
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_add_khoanchi);

        dialog.setCancelable(false);

        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        }

        EditText ed_idloaichi = dialog.findViewById(R.id.ed_themidloaichi);
        EditText ed_tenkhoanchi = dialog.findViewById(R.id.ed_themkhoanchi);
        EditText ed_ngaychi  = dialog.findViewById(R.id.ed_themngaychi);
        EditText ed_sotienchi = dialog.findViewById(R.id.ed_themsotienchi);
        EditText ed_nguoichi = dialog.findViewById(R.id.ed_themnguoichi);
        EditText ed_ghichuchi = dialog.findViewById(R.id.ed_themghichuchi);


        Button btn_them = dialog.findViewById(R.id.btn_themkhoanchi);
        Button btn_cancel = dialog.findViewById(R.id.btn_themcancel3);


        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                KhoanChiDTO khoanChiDTO = new KhoanChiDTO();

                khoanChiDTO.setTenKhoanChi(ed_tenkhoanchi.getText().toString());
                khoanChiDTO.setNgayChi(ed_ngaychi.getText().toString());
                khoanChiDTO.setSoTien(Double.parseDouble(ed_sotienchi.getText().toString()));
                khoanChiDTO.setHoTenNguoiChi(ed_nguoichi.getText().toString());
                khoanChiDTO.setGhiChu(ed_ghichuchi.getText().toString());

                KhoanChiDAO dao = new KhoanChiDAO(getContext());
                dao.open();

                long kq = dao.insert(khoanChiDTO);
                if(kq>0){
                    Toast.makeText(getContext(), "thêm mới thành công", Toast.LENGTH_SHORT).show();
                    showdata();
                }else{
                    Toast.makeText(getContext(), "thêm mới thất bại", Toast.LENGTH_SHORT).show();
                }
                dialog.cancel();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }


    @Override
    public void xoa(KhoanChiDTO khoanChiDTO) {
        dao.delete(khoanChiDTO.getId());
        Toast.makeText(getContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
        showdata();
    }

    @Override
    public void capnhat(KhoanChiDTO khoanChiDTO) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_udapte_khoanchi);

        dialog.setCancelable(false);

        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        }


        EditText ed_tenkhoanchi = dialog.findViewById(R.id.ed_suakhoanchi);
        EditText ed_ngaychi  = dialog.findViewById(R.id.ed_suangaychi);
        EditText ed_sotienchi = dialog.findViewById(R.id.ed_suasotienchi);
        EditText ed_nguoichi = dialog.findViewById(R.id.ed_suanguoichi);
        EditText ed_ghichuchi = dialog.findViewById(R.id.ed_suaghichuchi);
        EditText ed_idloaichi = dialog.findViewById(R.id.ed_suaidloaichi);

        Button btn_sua= dialog.findViewById(R.id.btn_suakhoanchi);
        Button btn_cancel = dialog.findViewById(R.id.btn_suacancel3);

        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed_tenkhoanchi.getText().toString();

                String id = ed_idloaichi.getText().toString();
                String ngaychi = ed_ngaychi.getText().toString();
                String sotienchi = ed_sotienchi.getText().toString();
                String nguoichi = ed_nguoichi.getText().toString();
                String ghichuchi = ed_ghichuchi.getText().toString();

                KhoanChiDTO khoanChiDTO1 = new KhoanChiDTO(khoanChiDTO.getId(),Integer.parseInt(id),name,ngaychi,Double.parseDouble(sotienchi),ghichuchi,nguoichi);

                if(dao.update(khoanChiDTO1)==true){
                    Toast.makeText(getActivity().getApplicationContext(), "update thành công", Toast.LENGTH_SHORT).show();
                    showdata();
                    dialog.cancel();
                }else {
                    Toast.makeText(getActivity().getApplicationContext(), "update k thành công", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }
            }

        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
