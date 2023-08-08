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

import com.example.chuongdkph26546_asm.Adapter.LoaiChiAdapter;
import com.example.chuongdkph26546_asm.DAO.LoaiChiDAO;
import com.example.chuongdkph26546_asm.DTO.LoaiChiDTO;
import com.example.chuongdkph26546_asm.DTO.LoaiThuDTO;
import com.example.chuongdkph26546_asm.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LoaiChiFrag extends Fragment implements LoaiChiAdapter.OnclickChi {

    LoaiChiAdapter adapter;
    LoaiChiDAO dao;
    RecyclerView rcv;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loai_chi, container, false);

        rcv = view.findViewById(R.id.rcv_loaichi);
        dao = new LoaiChiDAO(getActivity().getApplicationContext());
        dao.open();

//            adapter = new LoaiThuAdapter(getActivity().getApplicationContext(), dao.selectAll(),getContext().getApplicationContext(),new );
//
//            rcv.setAdapter(adapter);
//            adapter.notifyDataSetChanged();
        showdata();

        Log.i("hahahaha", "onCreateView: "+dao.selectAll().size());


        FloatingActionButton fab = view.findViewById(R.id.fab_loaichi);
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
        adapter = new LoaiChiAdapter(getContext().getApplicationContext(), dao.selectAll(),this);
        rcv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    public void showdialogAdd(){
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_add_loaichi);

        dialog.setCancelable(false);

        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        }
        EditText ed_ten = dialog.findViewById(R.id.ed_themchi);
        Button btn_them = dialog.findViewById(R.id.btn_themchi);
        Button btn_cancel = dialog.findViewById(R.id.btn_themcancel2);

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoaiChiDTO loaiChiDTO = new LoaiChiDTO();

                String tenloaichi = ed_ten.getText().toString();
                loaiChiDTO.setTenLoaiChi(tenloaichi);
                LoaiChiDAO dao = new LoaiChiDAO(getContext());
                dao.open();

                long kq = dao.insert(loaiChiDTO);
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
    public void xoa(LoaiChiDTO loaiChiDTO) {
        dao.delete(loaiChiDTO.getId());
        Toast.makeText(getContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
        showdata();
    }

    @Override
    public void capnhat(LoaiChiDTO loaiChiDTO) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_update_loaichi);

        dialog.setCancelable(false);

        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        }
        EditText ed_ten = dialog.findViewById(R.id.ed_suachi);
        Button btn_sua= dialog.findViewById(R.id.btn_suachi);
        Button btn_cancel = dialog.findViewById(R.id.btn_suacancel2);
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed_ten.getText().toString();

                LoaiChiDTO loaiChiDTO1 = new LoaiChiDTO(loaiChiDTO.getId(),name);

                if(dao.update(loaiChiDTO1)==true){
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
