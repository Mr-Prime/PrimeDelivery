package com.omega.primebasket.ui.fraghome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.omega.primebasket.R;
import com.omega.primebasket.data.model.HomeItem;
import com.omega.primebasket.ui.main.MainViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {

    @BindView(R.id.recyclerview_oofer)
    RecyclerView recyclerviewOffer;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
        private MainViewModel mMainActivityViewModel;
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    private View view;
    private ItemAdapter mAdapter;
    private OfferAdapter oAdapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.home_fragment, container, false);

        ButterKnife.bind(this,view);


        return view;


    }

    private void setRecyclerItems() {
        mAdapter = new ItemAdapter(getContext(),  mMainActivityViewModel.getHomeItems().getValue());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerview.setLayoutManager(mLayoutManager);
     //   recyclerview.addItemDecoration(new MyDividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL, 36));
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(mAdapter);
    //    recyclerview.setNestedScrollingEnabled(false);


        oAdapter = new OfferAdapter(getContext(),  mMainActivityViewModel.getOfferItems().getValue());
        RecyclerView.LayoutManager oLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerviewOffer.setLayoutManager(oLayoutManager);
        //   recyclerview.addItemDecoration(new MyDividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL, 36));
        recyclerviewOffer.setItemAnimator(new DefaultItemAnimator());
        recyclerviewOffer.setAdapter(oAdapter);
     //   recyclerviewOffer.setNestedScrollingEnabled(false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
              mMainActivityViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mMainActivityViewModel.initHome();

        mMainActivityViewModel.getHomeItems().observe(this, new Observer<List<HomeItem>>() {
            @Override
            public void onChanged(@Nullable List<HomeItem> items) {
                mAdapter.notifyDataSetChanged();


            }
        });

        mMainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(aBoolean){
                    //   showProgressBar();
                }
                else{
                    //  hideProgressBar();
                    recyclerview.smoothScrollToPosition(mMainActivityViewModel.getHomeItems().getValue().size()-1);
                }
            }
        });
        setRecyclerItems();
        // TODO: Use the ViewModel
    }

}
