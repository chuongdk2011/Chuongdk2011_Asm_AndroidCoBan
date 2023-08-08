package com.example.chuongdkph26546_asm.ui.thongke;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chuongdkph26546_asm.Adapter.ThongKeAdapter;
import com.example.chuongdkph26546_asm.DAO.KhoanChiDAO;
import com.example.chuongdkph26546_asm.DbHelper.MyDbHelper;
import com.example.chuongdkph26546_asm.R;

import java.util.Calendar;

public class ThongKeChiFrag extends Fragment {

    TextView tv_ngaybatdauchi,tv_ngayketthucchi;
    RecyclerView rcv;
    KhoanChiDAO dao;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thongke_chi,container,false);

        ImageView img_ngaybatdauchi = view.findViewById(R.id.img_ngaybatdauchi);
        ImageView img_ngayketthucchi = view.findViewById(R.id.img_ngaykethucchi);
        Button btn_thongkechi = view.findViewById(R.id.btn_thongkechi);
        TextView tv_tongtienchi = view.findViewById(R.id.tv_tongtienchi);
        TextView slbanghichi = view.findViewById(R.id.tv_slbanghichi);

        rcv = view.findViewById(R.id.rcv_thongkechi);


        tv_ngaybatdauchi = view.findViewById(R.id.tv_ngaybatdauchi);
        tv_ngayketthucchi = view.findViewById(R.id.tv_ngayketthucchi);

        img_ngaybatdauchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogDatePickerStart();
            }
        });

        img_ngayketthucchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogDatePickerEnd();
            }
        });
         dao = new KhoanChiDAO(getContext());



        btn_thongkechi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ngaybatdau = tv_ngaybatdauchi.getText().toString();
                String ngayketthuc = tv_ngayketthucchi.getText().toString();
                Log.i("hhahaaa", "onClick: "+ngaybatdau+"||"+ngayketthuc);

                int count = dao.selectCount(ngaybatdau,ngayketthuc);
                slbanghichi.setText("Số lượng bản ghi: "+count );

                Double sum = dao.selectSum(ngaybatdau,ngayketthuc);
                tv_tongtienchi.setText("Tổng tiền chi: "+sum);

                showdata(ngaybatdau,ngayketthuc);
            }
        });


        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public void showdata(String ngaybatdau, String ngayketthuc){
        ThongKeAdapter adapter = new ThongKeAdapter(getContext(),dao.selectformdate(ngaybatdau,ngayketthuc));
        rcv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    void showDialogDatePickerStart(){
        // viết lệnh hiển thị dialog
        // sử dụng đối tượng lịch để cài đặt
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis( System.currentTimeMillis() );

        // nguyên mẫu hàm khởi tạo DatePickerDialgo như sau:
        //DatePickerDialog(@NonNull Context context, @Nullable DatePickerDialog.OnDateSetListener listener, int year, int month, int dayOfMonth)
        DatePickerDialog dialog;
        dialog = new DatePickerDialog(
                getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        // xử lý sự kiện
                        int nam = i;
                        int thang = i1;
                        int ngay = i2;

                        tv_ngaybatdauchi.setText(nam + "-" + (thang + 1) + "-" + ngay);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE)
        );

        dialog.show();
    }
    void showDialogDatePickerEnd(){
        // viết lệnh hiển thị dialog
        // sử dụng đối tượng lịch để cài đặt
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis( System.currentTimeMillis() );

        // nguyên mẫu hàm khởi tạo DatePickerDialgo như sau:
        //DatePickerDialog(@NonNull Context context, @Nullable DatePickerDialog.OnDateSetListener listener, int year, int month, int dayOfMonth)
        DatePickerDialog dialog;
        dialog = new DatePickerDialog(
                getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        // xử lý sự kiện
                        int nam = i;
                        int thang = i1;
                        int ngay = i2;

                        tv_ngayketthucchi.setText( nam + "-" + (thang + 1) + "-" + ngay);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE)
        );

        dialog.show();
    }
}
