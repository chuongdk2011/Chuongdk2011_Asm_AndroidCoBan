package com.example.chuongdkph26546_asm.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.chuongdkph26546_asm.ui.chi.KhoanChiFrag;
import com.example.chuongdkph26546_asm.ui.chi.LoaiChiFrag;

public class PagerChiAdapter extends FragmentStateAdapter {

    int soluongPage = 2;
    public PagerChiAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new KhoanChiFrag();
            case 1:
                return new LoaiChiFrag();
            default:
                return new KhoanChiFrag();
        }

    }

    @Override
    public int getItemCount() {
        return soluongPage;
    }
}
