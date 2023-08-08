package com.example.chuongdkph26546_asm.ui.thongke;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.chuongdkph26546_asm.Adapter.PagerThongKeApdater;
import com.example.chuongdkph26546_asm.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CollectionFragThongKe extends Fragment {

    ViewPager2 viewPager2;
    PagerThongKeApdater apdater;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.collection_frag_thongke,container,false);



        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager2 = view.findViewById(R.id.viewPagerThongKe);

        apdater = new PagerThongKeApdater(this);

        viewPager2.setAdapter(apdater);

        TabLayout tab = view.findViewById(R.id.tabLayoutThongKe);

        TabLayoutMediator mediator = new TabLayoutMediator(tab, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position==1){
                    tab.setText("Thống Kê Thu");
                }else{
                    tab.setText("Thống Kê Chi");
                }
            }

        });
        mediator.attach();


    }
}
