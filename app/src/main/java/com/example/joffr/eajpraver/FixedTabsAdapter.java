package com.example.joffr.eajpraver;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by joffr on 18/10/2017.
 */

public class FixedTabsAdapter extends FragmentPagerAdapter {

    public FixedTabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
//        chama os fragments aba
        switch (position) {
            case 0:
                return new PontoInteresse();
            case 1:
                return new InformacaoPonto();
            case 2:
                return new Mapa();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Ponto de interesse";
            case 1:
                return "Mais informação";
            case 2:
                return "No mapa";
            default:
                return null;
        }
    }
}
