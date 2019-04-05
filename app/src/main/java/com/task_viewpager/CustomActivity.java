package com.task_viewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomActivity extends AppCompatActivity {

    TabLayout tabLayout;

    //storing the images in an array
    private int[] tabIcons = {
            R.drawable.ic_favorite_border_black_24dp,
            R.drawable.ic_contacts_black_24dp,
            R.drawable.ic_call_black_24dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        ViewPager viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    /*
    setting up the icons above the tabs on runtime at the top of the text
     */

    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText(getString(R.string.one));
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_favorite_border_black_24dp, 0, 0);
        Objects.requireNonNull(tabLayout.getTabAt(0)).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText(R.string.two);
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_contacts_black_24dp, 0, 0);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText(R.string.three);
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_call_black_24dp, 0, 0);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setCustomView(tabThree);
    }

    /*
    setting up viewpage adapter
    */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "ONE");
        adapter.addFrag(new TwoFragment(), "TWO");
        adapter.addFrag(new ThreeFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }

    /*
    inner class of adapter
    */

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> FragmentList = new ArrayList<>();
        private final List<String> FragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

         /*
        returning the position where the fragment is to be inserted
         */

        @Override
        public Fragment getItem(int position) {
            return FragmentList.get(position);
        }

         /*
        getting the count of the number of fragments
         */

        @Override
        public int getCount() {
            return FragmentList.size();
        }

         /*
        adding the fragments and title to the list
         */

         void addFrag(Fragment fragment, String title) {
            FragmentList.add(fragment);
            FragmentTitleList.add(title);
        }

        /*
        returning the title list to be displayed on the tabs
         */

        @Override
        public CharSequence getPageTitle(int position) {
            return FragmentTitleList.get(position);
        }
    }


}

