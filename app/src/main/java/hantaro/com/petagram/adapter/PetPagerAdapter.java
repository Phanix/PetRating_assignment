package hantaro.com.petagram.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import hantaro.com.petagram.vista.fragment.PerfilFragment;
import hantaro.com.petagram.vista.fragment.PetListFragment;

public class PetPagerAdapter extends FragmentPagerAdapter {
    public PetPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if(i == 0)
            return new PetListFragment();
        return new PerfilFragment();

    }

    @Override
    public int getCount() {
        return 2;
    }




}
