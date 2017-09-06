package com.twenty57.uidevshare;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
{
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.navigation_linear_layout:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.navigation_relative_layout:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.navigation_constraint_layout:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.navigation_list_view:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){}

            @Override
            public void onPageSelected(int position)
            {
                if (prevMenuItem != null)
                {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: " + position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state){}
        });

        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        RelativeLayoutFragment relativeLayoutFragment = new RelativeLayoutFragment();
        LinearLayoutFragment linearLayoutFragment = new LinearLayoutFragment();
        ConstraintLayoutFragment constraintLayoutFragment = new ConstraintLayoutFragment();
        ListViewFragment listViewFragment = new ListViewFragment();

        adapter.addFragment(linearLayoutFragment);
        adapter.addFragment(relativeLayoutFragment);
        adapter.addFragment(constraintLayoutFragment);
        adapter.addFragment(listViewFragment);
        viewPager.setAdapter(adapter);
    }
}
