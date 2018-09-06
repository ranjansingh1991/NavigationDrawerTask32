package com.semicolonindia.navigationdrawertask3.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.semicolonindia.navigationdrawertask3.R;
import com.semicolonindia.navigationdrawertask3.adapters.RecyclerAdapter;
import com.semicolonindia.navigationdrawertask3.adapters.MainPagerViewAdapter;
import com.semicolonindia.navigationdrawertask3.drawer.FragmentDrawer;
import com.semicolonindia.navigationdrawertask3.fragments.FriendsFragment;
import com.semicolonindia.navigationdrawertask3.fragments.HomeFragment;
import com.semicolonindia.navigationdrawertask3.fragments.MessagesFragment;
import com.semicolonindia.navigationdrawertask3.model.ItemObject;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private static String TAG = MainActivity.class.getSimpleName();

    // Sliding viewPager
    ViewPager viewPager;
    MainPagerViewAdapter vPadapter;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    GridLayoutManager gridLayoutManager;

     Toolbar mToolbar;
    private FragmentDrawer drawerFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sliding ViewPager
        // ViewPager Initalizing
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        vPadapter = new MainPagerViewAdapter(getApplicationContext());
        viewPager.setAdapter(vPadapter);
        //
        List<ItemObject> listItem = getAllItems();
        // Set your Grid Layout
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        // RecyclerView
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        // size argesment
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerAdapter = new RecyclerAdapter(getApplicationContext(), listItem);
        recyclerView.setAdapter(recyclerAdapter);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        //  Enable the toolbar by calling setSupportActionBar() by passing the toolbar object.
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);
    }


    private List<ItemObject> getAllItems(){
        List<ItemObject> list = new ArrayList<>();
        list.add(new ItemObject(R.drawable.sample_0, "First"));
        list.add(new ItemObject(R.drawable.sample_1, "Second"));
        list.add(new ItemObject(R.drawable.sample_2, "Third"));
        list.add(new ItemObject(R.drawable.sample_3, "Fourth"));
        list.add(new ItemObject(R.drawable.sample_4, "Fifth"));
        list.add(new ItemObject(R.drawable.sample_5, "Sixth"));
        list.add(new ItemObject(R.drawable.sample_6, "Seventh"));
        list.add(new ItemObject(R.drawable.sample_0, "Eighth"));

        return list;
    }

/* Override onCreateOptionsMenu() and onOptionsItemSelected() methods to enable toolbar action items.

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

       */
/* if(id == R.id.action_search){
            Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();
            return true;
        }*//*


        return super.onOptionsItemSelected(item);
    }
*/

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                break;
            case 1:
                fragment = new FriendsFragment();
                title = getString(R.string.title_friends);
                break;
            case 2:
                fragment = new MessagesFragment();
                title = getString(R.string.title_messages);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }
}