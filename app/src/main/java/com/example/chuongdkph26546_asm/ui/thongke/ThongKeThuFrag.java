package com.example.chuongdkph26546_asm.ui.thongke;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chuongdkph26546_asm.Adapter.ThongKeAdapter;
import com.example.chuongdkph26546_asm.DAO.KhoanChiDAO;
import com.example.chuongdkph26546_asm.DAO.KhoanThuDAO;
import com.example.chuongdkph26546_asm.R;

import java.util.Calendar;

public class ThongKeThuFrag extends Fragment {

    TextView tv_ngaybatdauthu,tv_ngayketthucthu;
    RecyclerView rcv;
    KhoanThuDAO dao;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thongke_thu,container,false);

        ImageView img_ngaybatdauthu = view.findViewById(R.id.img_ngaybatdauthu);
        ImageView img_ngayketthucthu = view.findViewById(R.id.img_ngaykethucthu);

        tv_ngaybatdauthu = view.findViewById(R.id.tv_ngaybatdauthu);
        tv_ngayketthucthu = view.findViewById(R.id.tv_ngayketthucthu);

        Button btn_thongkethu = view.findViewById(R.id.btn_thongkethu);
        TextView tv_tongtienthu = view.findViewById(R.id.tv_tongtienthu);
        TextView slbanghithu = view.findViewById(R.id.tv_slbanghithu);

        rcv = view.findViewById(R.id.rcv_thongkethu);

        img_ngaybatdauthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogDatePickerStart();
            }
        });

        img_ngayketthucthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogDatePickerEnd();
            }
        });
        dao = new KhoanThuDAO(getContext());

        btn_thongkethu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ngaybatdau = tv_ngaybatdauthu.getText().toString();
                String ngayketthuc = tv_ngayketthucthu.getText().toString();
                Log.i("hhahaaa", "onClick: "+ngaybatdau+"||"+ngayketthuc);

                int count = dao.selectCount(ngaybatdau,ngayketthuc);
                slbanghithu.setText("Số lượng bản ghi: "+count );

                Double sum = dao.selectSum(ngaybatdau,ngayketthuc);
                tv_tongtienthu.setText("Tổng tiền chi: "+sum);

                showdata(ngaybatdau,ngayketthuc);
            }
        });

        return view;
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

                        tv_ngaybatdauthu.setText(nam + "-" + (thang + 1) + "-" + ngay);
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

                        tv_ngayketthucthu.setText( nam + "-" + (thang + 1) + "-" + ngay);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE)
        );

        dialog.show();
    }
}
