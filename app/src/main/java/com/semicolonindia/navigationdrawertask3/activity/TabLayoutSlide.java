package com.semicolonindia.navigationdrawertask3.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.semicolonindia.navigationdrawertask3.R;
import com.semicolonindia.navigationdrawertask3.adapters.FragmentAdapter;

public class TabLayoutSlide extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    TabLayout tabLayout;
    //This is our viewPager
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_slide);
        // Initializing Tab
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab3"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab4"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab5"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab6"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab7"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab8"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);
        //Creating our pager vPadapter
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding vPadapter to pager
        viewPager.setAdapter(adapter);


        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
