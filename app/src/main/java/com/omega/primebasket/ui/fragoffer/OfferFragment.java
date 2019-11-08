package com.omega.primebasket.ui.fragoffer;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.omega.primebasket.R;
import com.omega.primebasket.data.model.HomeItem;
import com.omega.primebasket.ui.main.MainViewModel;
import com.omega.primebasket.utils.AutoScrollViewPager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class OfferFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.view_pager)
    AutoScrollViewPager viewPager;
    @BindView(R.id.layoutDots)
    LinearLayout layoutDots;
    private TextView[] dots;
    private String[] layouts;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private MyViewPagerAdapter myViewPagerAdapter;
    public OfferFragment() {
        // Required empty public constructor
    }
    private MainViewModel mMainActivityViewModel;
    // TODO: Rename and change types and number of parameters
    public static OfferFragment newInstance(String param1, String param2) {
        OfferFragment fragment = new OfferFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
 private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view= inflater.inflate(R.layout.fragment_offer, container, false);
        // adding bottom dots

        ButterKnife.bind(this,view);
        return view;

    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
//                btnNext.setText(getString(R.string.start));
//                btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
//                btnNext.setText(getString(R.string.next));
//                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMainActivityViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mMainActivityViewModel.initHome();
        mMainActivityViewModel.getHomeItems().observe(this, new Observer<List<HomeItem>>() {
            @Override
            public void onChanged(@Nullable List<HomeItem> items) {
                myViewPagerAdapter.notifyDataSetChanged();
                addBottomDots(0);
            }
        });

      //  addBottomDots(0);

        // making notification bar transparent
        changeStatusBarColor();
        layouts=new String[mMainActivityViewModel.getOfferItems().getValue().size()];
        for(int i= 0;i<mMainActivityViewModel.getOfferItems().getValue().size();i++){
            layouts[i]=mMainActivityViewModel.getOfferItems().getValue().get(i).getImage();
        }

        myViewPagerAdapter = new MyViewPagerAdapter(getContext(),layouts);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        viewPager.startAutoScroll();
        viewPager.setInterval(4000);

        // TODO: Use the ViewModel
    }
    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        layoutDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getActivity());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorWhite));
            layoutDots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(getResources().getColor(R.color.colorBlack));
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }
    }

}
