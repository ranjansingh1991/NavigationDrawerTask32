package com.semicolonindia.navigationdrawertask3.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.semicolonindia.navigationdrawertask3.fragments.Tab1;
import com.semicolonindia.navigationdrawertask3.fragments.Tab2;
import com.semicolonindia.navigationdrawertask3.fragments.Tab3;
import com.semicolonindia.navigationdrawertask3.fragments.Tab4;
import com.semicolonindia.navigationdrawertask3.fragments.Tab5;
import com.semicolonindia.navigationdrawertask3.fragments.Tab6;
import com.semicolonindia.navigationdrawertask3.fragments.Tab7;
import com.semicolonindia.navigationdrawertask3.fragments.Tab8;

/**
 * Created by RANJAN SINGH on 8/20/2017.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {
    //integer to count number of tabs
    int tabCount;
    public FragmentAdapter(FragmentManager fm, int tabCount) {
        super(fm);

        //Initializing tab count
        this.tabCount= tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                Tab1 tab1 = new Tab1();
                return tab1;
            case 1:
                Tab2 tab2 = new Tab2();
                return tab2;
            case 2:
                Tab3 tab3 = new Tab3();
                return tab3;
            case 3:
                Tab4 tab4 = new Tab4();
                return tab4;
            case 4:
                Tab5 tab5 = new Tab5();
                return tab5;
            case 5:
                Tab6 tab6 = new Tab6();
                return tab6;
            case 6:
                Tab7 tab7 = new Tab7();
                return tab7;
            case 7:
                Tab8 tab8 = new Tab8();
                return tab8;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
