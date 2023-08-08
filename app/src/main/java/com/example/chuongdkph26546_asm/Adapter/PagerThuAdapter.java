package com.example.chuongdkph26546_asm.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import com.example.chuongdkph26546_asm.ui.thu.KhoanThuFrag;
import com.example.chuongdkph26546_asm.ui.thu.LoaiThuFrag;

public class PagerThuAdapter extends FragmentStateAdapter {

    int soluongPage = 2;
    public PagerThuAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new KhoanThuFrag();
            case 1:
                return new LoaiThuFrag();
            default:
                return new KhoanThuFrag();
        }

    }

    @Override
    public int getItemCount() {
        return soluongPage;
    }

}
