package com.info.brandbuzz.activity;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.info.brandbuzz.R;
import com.info.brandbuzz.Utill_Gagan.ContentFragment;
import com.info.brandbuzz.Utill_Gagan.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;


public class DashBoard extends Fragment {




    public DashBoard() {
    }





//    static class SamplePagerItem {
//        private final CharSequence mTitle;
//        private final int mIndicatorColor;
//        private final int mDividerColor;
//
//        SamplePagerItem(CharSequence title, int indicatorColor, int dividerColor) {
//            mTitle = title;
//            mIndicatorColor = indicatorColor;
//            mDividerColor = dividerColor;
//        }
//
//        /**
//         * @return A new {@link Fragment} to be displayed by a {@link ViewPager}
//         */
//        Fragment createFragment() {
//            return ContentFragment.newInstance(mTitle, mIndicatorColor, mDividerColor);
//        }
//
//        /**
//         * @return the title which represents this tab. In this sample this is used directly by
//         * {@link android.support.v4.view.PagerAdapter#getPageTitle(int)}
//         */
//        CharSequence getTitle() {
//            return mTitle;
//        }
//
//
//        int getIndicatorColor() {
//            return mIndicatorColor;
//        }
//
//
//        int getDividerColor() {
//            return mDividerColor;
//        }
//    }

    static final String LOG_TAG = "SlidingTabsColorsFragment";

    /**
     * A custom {@link ViewPager} title strip which looks much like Tabs present in Android v4.0 and
     * above, but is designed to give continuous feedback to the user when scrolling.
     */
    private SlidingTabLayout mSlidingTabLayout;

    /**
     * A {@link ViewPager} which will be used in conjunction with the {@link SlidingTabLayout} above.
     */
    private ViewPager mViewPager;

//    /**
//     * List of {@link SamplePagerItem} which represent this sample's tabs.
//     */
//    private List<SamplePagerItem> mTabs = new ArrayList<>();


    private List<Fragment> FragmentList_;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        FragmentList_=new ArrayList<>();
        FragmentList_.add(new MyEvents());
        FragmentList_.add(new MyPictures());
        FragmentList_.add(new MyEvents());
        FragmentList_.add(new MyPictures());
    }

    /**
     * Inflates the {@link View} which will be displayed by this {@link Fragment}, from the app's
     * resources.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    // BEGIN_INCLUDE (fragment_onviewcreated)
    /**
     * This is called after the {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)} has finished.
     * Here we can pick out the {@link View}s we need to configure from the content view.
     *
     * We set the {@link ViewPager}'s adapter to be an instance of
     * {@link SampleFragmentPagerAdapter}. The {@link SlidingTabLayout} is then given the
     * {@link ViewPager} so that it can populate itself.
     *
     * @param view View created in {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // BEGIN_INCLUDE (setup_viewpager)
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SampleFragmentPagerAdapter(getChildFragmentManager()));
        // END_INCLUDE (setup_viewpager)

        // BEGIN_INCLUDE (setup_slidingtablayout)
        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
        // it's PagerAdapter set.
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);

        // BEGIN_INCLUDE (tab_colorizer)
        // Set a TabColorizer to customize the indicator and divider colors. Here we just retrieve
        // the tab at the position, and return it's set color
        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {

            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.Green_appTheme);
            }

            @Override
            public int getDividerColor(int position) {
                return Color.GRAY;
            }

        });
        // END_INCLUDE (tab_colorizer)
        // END_INCLUDE (setup_slidingtablayout)
    }
    // END_INCLUDE (fragment_onviewcreated)


    class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

        SampleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int i) {
//            return mTabs.get(i).createFragment();
            return  FragmentList_.get(i);
        }


        @Override
        public int getCount() {
            return FragmentList_.size();
        }

        // BEGIN_INCLUDE (pageradapter_getpagetitle)

        @Override
        public CharSequence getPageTitle(int position) {
            return "TabG->"+position;
        }
        // END_INCLUDE (pageradapter_getpagetitle)

    }

}