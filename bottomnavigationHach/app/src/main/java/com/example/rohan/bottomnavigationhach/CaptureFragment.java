package com.example.rohan.bottomnavigationhach;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CaptureFragment extends Fragment {


    public static final String PAGE_TITLE = "Tab1";

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    public CaptureFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment
     * @return A new instance of fragment ViewPagerFragment.
     */
    public static CaptureFragment newInstance() {
        CaptureFragment fragment = new CaptureFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_capture, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        return view;
    }


    public static class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private static final int NUM_ITEMS = 3;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {


            switch (position)
            {
                case 0:   return AllDocFragment.newInstance();
                case 1:return SpeDocFragment.newInstance();
                case 2:return FavDocFragment.newInstance();
                default:return AllDocFragment.newInstance();
            }



        }

        @Override
        public CharSequence getPageTitle(int position) {


            switch (position)
            {
                case 0:   return AllDocFragment.PAGE_TITLE;
                case 1:return SpeDocFragment.PAGE_TITLE;
                case 2:return FavDocFragment.PAGE_TITLE;
                default:return AllDocFragment.PAGE_TITLE;
            }

        }
    }





}