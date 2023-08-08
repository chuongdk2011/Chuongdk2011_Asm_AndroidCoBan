package com.example.chuongdkph26546_asm.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.chuongdkph26546_asm.ui.thongke.ThongKeChiFrag;
import com.example.chuongdkph26546_asm.ui.thongke.ThongKeThuFrag;
import com.example.chuongdkph26546_asm.ui.thu.KhoanThuFrag;
import com.example.chuongdkph26546_asm.ui.thu.LoaiThuFrag;

public class PagerThongKeApdater extends FragmentStateAdapter {

    int soluongPage = 2;
    public PagerThongKeApdater(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ThongKeChiFrag();
            case 1:
                return new ThongKeThuFrag();
            default:
                return new ThongKeChiFrag();
        }
    }

    @Override
    public int getItemCount() {
        return soluongPage;
    }
}
