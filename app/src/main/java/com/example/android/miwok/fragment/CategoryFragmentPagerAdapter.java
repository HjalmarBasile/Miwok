package com.example.android.miwok.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.miwok.R;

/**
 * Created by hjalmar
 * On 24/12/2017.
 */
public class CategoryFragmentPagerAdapter extends FragmentPagerAdapter {

    private final static int FRAGMENTS_COUNT = 4;
    private final Context mContext;
    private final String[] mTabTitles;

    public CategoryFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
        this.mTabTitles = buildTabTitles();
    }

    private String[] buildTabTitles() {
        String[] tabTitles = new String[FRAGMENTS_COUNT];
        tabTitles[0] = mContext.getString(R.string.category_numbers);
        tabTitles[1] = mContext.getString(R.string.category_family);
        tabTitles[2] = mContext.getString(R.string.category_colors);
        tabTitles[3] = mContext.getString(R.string.category_phrases);
        return tabTitles;
    }

    @Override
    public int getCount() {
        return FRAGMENTS_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NumbersFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColorsFragment();
            case 3:
                return new PhrasesFragment();
            default:
                throw new IllegalArgumentException("Invalid position as input: must be less than " + FRAGMENTS_COUNT);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles[position];
    }

}
