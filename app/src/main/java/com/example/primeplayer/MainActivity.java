package com.example.primeplayer;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.primeplayer.adapter.BannerMoviesPageAdapter;
import com.example.primeplayer.adapter.MainRecyclerAdapter;
import com.example.primeplayer.model.AllCategory;
import com.example.primeplayer.model.BannerMovies;
import com.example.primeplayer.model.CategoryItem;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    BannerMoviesPageAdapter bannerMoviesPageAdapter;
    TabLayout indicatorTab, categoryTab;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> homeBannerList;
    List<BannerMovies> tvshowBannerList;
    List<BannerMovies> movieBannerList;
    List<BannerMovies> kidsBannerList;
    Timer sliderTimer;

    NestedScrollView nestedScrollView;
    AppBarLayout appBarLayout;

    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;
    List<AllCategory> allCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indicatorTab = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tabLayout);
        nestedScrollView = findViewById(R.id.nested_scroll);
        appBarLayout = findViewById(R.id.appbar);


        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1, "test1", "https://cdn.pixabay.com/photo/2018/01/21/01/19/tree-3095683_960_720.jpg", "/D://ANMOL//MOVIE,SERIES//Hollywood//Interstellar 2014.mp4/"));
        homeBannerList.add(new BannerMovies(2, "test2", "https://cdn.pixabay.com/photo/2016/11/14/03/26/cliff-1822484_960_720.jpg", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"));
//         homeBannerList.add(new BannerMovies(3,"test3","",""));
//         homeBannerList.add(new BannerMovies(4,"test4","",""));
//         homeBannerList.add(new BannerMovies(5,"test5","",""));

        tvshowBannerList = new ArrayList<>();
        tvshowBannerList.add(new BannerMovies(1, "test3", "https://cdn.pixabay.com/photo/2017/01/11/14/56/ireland-1971997_960_720.jpg", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"));
        tvshowBannerList.add(new BannerMovies(2, "test4", "https://cdn.pixabay.com/photo/2015/01/28/23/35/hills-615429_960_720.jpg", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"));
//         tvshowBannerList.add(new BannerMovies(3,"test1","",""));
//         tvshowBannerList.add(new BannerMovies(4,"test1","",""));
//         tvshowBannerList.add(new BannerMovies(5,"test1","",""));

        movieBannerList = new ArrayList<>();
        movieBannerList.add(new BannerMovies(1, "test1", "https://cdn.pixabay.com/photo/2015/01/28/23/34/mountains-615428_960_720.jpg", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));
        movieBannerList.add(new BannerMovies(2, "test1", "https://cdn.pixabay.com/photo/2015/05/30/10/11/trees-790220_960_720.jpg", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4"));
//        movieBannerList.add(new BannerMovies(3,"test1","",""));
//        movieBannerList.add(new BannerMovies(4,"test1","",""));
//        movieBannerList.add(new BannerMovies(5,"test1","",""));

        kidsBannerList = new ArrayList<>();
        kidsBannerList.add(new BannerMovies(1, "test1", "https://cdn.pixabay.com/photo/2015/02/18/11/50/mountain-range-640617_960_720.jpg", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4"));
        kidsBannerList.add(new BannerMovies(2, "test1", "https://cdn.pixabay.com/photo/2018/04/16/16/16/sunset-3325080_960_720.jpg", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4"));
//        kidsBannerList.add(new BannerMovies(3,"test1","",""));
//        kidsBannerList.add(new BannerMovies(4,"test1","",""));
//        kidsBannerList.add(new BannerMovies(5,"test1","",""));


        setBannerMoviesPageAdapter(homeBannerList);
        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 1:
                        setScrollDefaultState();
                        setBannerMoviesPageAdapter(tvshowBannerList);
                        return;
                    case 2:
                        setScrollDefaultState();
                        setBannerMoviesPageAdapter(movieBannerList);
                        return;
                    case 3:
                        setScrollDefaultState();
                        setBannerMoviesPageAdapter(kidsBannerList);
                        return;
                    default:
                        setScrollDefaultState();
                        setBannerMoviesPageAdapter(homeBannerList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }


        });

        List<CategoryItem> homeCatListItem1 = new ArrayList<>();
        homeCatListItem1.add(new CategoryItem(1, "", "", ""));
        homeCatListItem1.add(new CategoryItem(2, "", "", ""));
        homeCatListItem1.add(new CategoryItem(3, "", "", ""));
        homeCatListItem1.add(new CategoryItem(4, "", "", ""));
        homeCatListItem1.add(new CategoryItem(5, "", "", ""));

        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1, "Bollywood", homeCatListItem1));
        allCategoryList.add(new AllCategory(2, "Hollywood", homeCatListItem1));
        allCategoryList.add(new AllCategory(3, "Kids", homeCatListItem1));

        setMainRecycler(allCategoryList);
    }

    private void setBannerMoviesPageAdapter(List<BannerMovies> bannerMoviesList) {

        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesPageAdapter = new BannerMoviesPageAdapter(this, bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPageAdapter);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager);


        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 4000, 6000);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager, true);
    }

    class AutoSlider extends TimerTask {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (bannerMoviesViewPager.getCurrentItem() < homeBannerList.size() - 1) {
                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem() + 1);
                    } else {
                        bannerMoviesViewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }


    public void setMainRecycler(List<AllCategory> allCategoryList) {
        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allCategoryList);
        mainRecycler.setAdapter(mainRecyclerAdapter);
    }

    private void setScrollDefaultState(){
        nestedScrollView.fullScroll(View.FOCUS_UP);
        nestedScrollView.scrollTo(0,0);
        appBarLayout.setExpanded(true);
    }
}
