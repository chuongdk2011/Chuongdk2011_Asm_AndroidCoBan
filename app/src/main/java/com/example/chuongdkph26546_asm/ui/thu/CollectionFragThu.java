package com.example.chuongdkph26546_asm.ui.thu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;


import com.example.chuongdkph26546_asm.Adapter.PagerThuAdapter;
import com.example.chuongdkph26546_asm.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CollectionFragThu extends Fragment {

    PagerThuAdapter adapter;
    ViewPager2 viewPager2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_thu,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager2 = view.findViewById(R.id.viewPagerThu);
        adapter = new PagerThuAdapter(this);

        viewPager2.setAdapter(adapter);
        TabLayout tab = view.findViewById(R.id.tabLayoutThu);

        TabLayoutMediator mediator = new TabLayoutMediator(tab, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        if(position==0){
                            tab.setText("Khoản Thu");
                        }else{
                            tab.setText("Loại Thu");
                        }
                    }
                });
        mediator.attach();

    }
}
