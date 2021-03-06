package com.example.joffr.eajpraver;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager vp;
    public static GoogleMap mGoogleMap;

    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tab);

        vp = (ViewPager) findViewById(R.id.pager);
        PagerAdapter pa = new FixedTabsAdapter(getSupportFragmentManager());

        vp.setAdapter(pa);

        tabLayout.setupWithViewPager(vp);

        //TODO: TRATAR EVENTOS UTEIS UM DIA
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        int aba = vp.getCurrentItem();
        if (aba == 0) {
            super.onBackPressed();
        } else {
            tabLayout.getTabAt(aba - 1).select();
        }
    }
}
