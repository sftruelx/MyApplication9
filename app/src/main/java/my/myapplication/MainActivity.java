package my.myapplication;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import my.myapplication.my.myapplication.list.PullToRefreshExpandableListActivity;
import my.myapplication.my.myapplication.list.PullToRefreshHorizontalScrollViewActivity;
import my.myapplication.my.myapplication.list.PullToRefreshListActivity;
import my.myapplication.my.myapplication.list.PullToRefreshListFragmentActivity;
import my.myapplication.my.myapplication.list.PullToRefreshListInViewPagerActivity;
import my.myapplication.my.myapplication.list.PullToRefreshScrollViewActivity;
import my.myapplication.my.myapplication.list.PullToRefreshViewPagerActivity;
import my.myapplication.my.myapplication.list.PullToRefreshWebView2Activity;
import my.myapplication.my.myapplication.list.PullToRefreshWebViewActivity;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private int tabWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int widthPixels = dm.widthPixels;
        tabWidth = widthPixels/3;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.logo);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        RequestQueue mQueue = Volley.newRequestQueue(getBaseContext());

        mQueue.add(stringRequest);

    }

    StringRequest stringRequest = new StringRequest("http://www.baidu.com",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("TAG", response);
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("TAG", error.getMessage(), error);
        }
    });
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
            Intent intent;
            intent = new Intent(this, PullToRefreshListActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView;

            int i = getArguments().getInt(ARG_SECTION_NUMBER);
            if(i==1){
                rootView = inflater.inflate(R.layout.item_main, container, false);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.section_title1,ItemTitleFragment.newInstance("频道3"));
                transaction.replace(R.id.section_one,new PhotoListFragment() );
                transaction.replace(R.id.section_two, ItemTitleFragment.newInstance("频道2"));
                transaction.replace(R.id.section_three,new ImgListFragment() );
                transaction.add(R.id.item_one,ItemTitleFragment.newInstance("频道4") );
                transaction.add(R.id.item_one,new PhotoListFragment() );
                transaction.add(R.id.item_one,ItemTitleFragment.newInstance("频道4") );


                transaction.commit();

            }else {
                rootView = inflater.inflate(R.layout.fragment_main, container, false);
                //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
                //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            }
            return rootView;
        }
    }


    public void MoreOnClick(View view){
//        mImageLoader.get(url, listener);
//        ImageLoader.ImageListener listener = ImageLoader.getImageListener(imag/**/eView, android.R.drawable.ic_menu_rotate, android.R.drawable.ic_delete);

    }
    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "推荐";
                case 1:
                    return "分类";
                case 2:
                    return "直播";
                case 3:
                    return "榜单";
                case 4:
                    return "主播";
            }
            return null;
        }
    }
}
