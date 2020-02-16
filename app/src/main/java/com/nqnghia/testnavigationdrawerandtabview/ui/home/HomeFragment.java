package com.nqnghia.testnavigationdrawerandtabview.ui.home;

import android.graphics.Color;
import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.nqnghia.testnavigationdrawerandtabview.PageAdapter;
import com.nqnghia.testnavigationdrawerandtabview.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter pagerAdapter;
    TabItem home;
    TabItem content;

    Button home_btb;
    Button content_btn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        toolbar = root.findViewById(R.id.toolbar);
        toolbar.setTitle("Tab Layout");

        tabLayout = root.findViewById(R.id.tab_layout);
        home = root.findViewById(R.id.tab_home);
        content = root.findViewById(R.id.tab_content);
        viewPager = root.findViewById(R.id.view_pager);

        pagerAdapter = new PageAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 1) {
                    content_btn = root.findViewById(R.id.content_btn);
                    content_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            viewPager.setCurrentItem(1);
                            tabLayout.setBackgroundColor(Color.rgb(0, 0, 255));
                        }
                    });

//                    toolbar.setBackgroundColor(Color.rgb(0, 0, 255));
                    tabLayout.setBackgroundColor(Color.rgb(0, 0, 255));
                } else {
                    home_btb = root.findViewById(R.id.home_btn);
                    home_btb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            viewPager.setCurrentItem(0);
                            tabLayout.setBackgroundColor(Color.rgb(0, 255, 0));
                        }
                    });

//                    toolbar.setBackgroundColor(Color.rgb(0, 255, 0));
                    tabLayout.setBackgroundColor(Color.rgb(0, 255, 0));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        return root;
    }
}