package com.example.chuongdkph26546_asm.ui.thu;

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
import com.example.chuongdkph26546_asm.Adapter.KhoanThuAdapter;
import com.example.chuongdkph26546_asm.DAO.KhoanChiDAO;
import com.example.chuongdkph26546_asm.DAO.KhoanThuDAO;
import com.example.chuongdkph26546_asm.DTO.KhoanChiDTO;
import com.example.chuongdkph26546_asm.DTO.KhoanThuDTO;
import com.example.chuongdkph26546_asm.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class KhoanThuFrag extends Fragment implements KhoanThuAdapter.OnclickKhoanThu {

    KhoanThuAdapter adapter;
    KhoanThuDAO dao;
    RecyclerView rcv;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_khoan_thu, container, false);

        rcv = view.findViewById(R.id.rcv_khoanthu);
        dao = new KhoanThuDAO(getActivity().getApplicationContext());
        dao.open();

        showdata();

        Log.i("hahahaha", "onCreateView: "+dao.selectAll().size());


        FloatingActionButton fab = view.findViewById(R.id.fab_khoanthu);
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
        adapter = new KhoanThuAdapter(getContext().getApplicationContext(), dao.selectAll(),this);
        rcv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    public void showdialogAdd(){
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_add_khoanthu);

        dialog.setCancelable(false);

        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        }


        EditText ed_tenkhoanthu = dialog.findViewById(R.id.ed_themkhoanthu);
        EditText ed_ngaythu  = dialog.findViewById(R.id.ed_themngaythu);
        EditText ed_sotienthu = dialog.findViewById(R.id.ed_themsotienthu);
        EditText ed_nguoithu = dialog.findViewById(R.id.ed_themnguoithu);
        EditText ed_ghichuthu = dialog.findViewById(R.id.ed_themghichuthu);


        Button btn_them = dialog.findViewById(R.id.btn_themkhoanthu);
        Button btn_cancel = dialog.findViewById(R.id.btn_themcancel4);


        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                KhoanThuDTO khoanThuDTO= new KhoanThuDTO();

                khoanThuDTO.setTenKhoanThu(ed_tenkhoanthu.getText().toString());
                khoanThuDTO.setNgayThu(ed_ngaythu.getText().toString());
                khoanThuDTO.setSoTien(Double.parseDouble(ed_sotienthu.getText().toString()));
                khoanThuDTO.setHoTenNguoiThu(ed_nguoithu.getText().toString());
                khoanThuDTO.setGhiChu(ed_ghichuthu.getText().toString());

                KhoanThuDAO dao = new KhoanThuDAO(getContext());
                dao.open();

                long kq = dao.insert(khoanThuDTO);
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
    public void xoa(KhoanThuDTO khoanThuDTO) {
        dao.delete(khoanThuDTO.getId());
        Toast.makeText(getContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
        showdata();
    }

    @Override
    public void capnhat(KhoanThuDTO khoanThuDTO) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_update_khoanthu);

        dialog.setCancelable(false);

        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        }


        EditText ed_tenkhoanthu = dialog.findViewById(R.id.ed_suakhoanthu);
        EditText ed_ngaythu  = dialog.findViewById(R.id.ed_suangaythu);
        EditText ed_sotienthu = dialog.findViewById(R.id.ed_suasotienthu);
        EditText ed_nguoithu = dialog.findViewById(R.id.ed_suanguoithu);
        EditText ed_ghichuthu = dialog.findViewById(R.id.ed_suaghichuthu);
        EditText ed_idloaithu = dialog.findViewById(R.id.ed_suaidloaithu);

        Button btn_sua= dialog.findViewById(R.id.btn_suakhoanthu);
        Button btn_cancel = dialog.findViewById(R.id.btn_suacancel4);

        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed_tenkhoanthu.getText().toString();

                String id = ed_idloaithu.getText().toString();
                String ngaychi = ed_ngaythu.getText().toString();
                String sotienchi = ed_sotienthu.getText().toString();
                String nguoichi = ed_nguoithu.getText().toString();
                String ghichuchi = ed_ghichuthu.getText().toString();

                KhoanThuDTO khoanThuDTO1 = new KhoanThuDTO(khoanThuDTO.getId(),Integer.parseInt(id),name,ngaychi,Double.parseDouble(sotienchi),ghichuchi,nguoichi);

                if(dao.update(khoanThuDTO1)==true){
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
