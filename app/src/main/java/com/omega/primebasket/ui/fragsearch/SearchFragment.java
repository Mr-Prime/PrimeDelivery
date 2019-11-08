package com.omega.primebasket.ui.fragsearch;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.omega.primebasket.R;
import com.omega.primebasket.data.model.CuisineItem;
import com.omega.primebasket.data.model.SearchItem;
import com.omega.primebasket.ui.fragcuisines.CuisineItemAdapter;
import com.omega.primebasket.ui.main.MainViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchFragment extends Fragment {


    @BindView(R.id.restaurants_recycle)
    RecyclerView searchRecycle;
    private MainViewModel mMainActivityViewModel;

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    private View view;
    private SearchAdapter mAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_search, container, false);

        ButterKnife.bind(this, view);


        return view;


    }

    private void setRecyclerItems() {
        mAdapter = new SearchAdapter(getContext(), mMainActivityViewModel.getSearchItem().getValue());
        RecyclerView.LayoutManager mLayoutManager =  new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        searchRecycle.setLayoutManager(mLayoutManager);
        //   recyclerview.addItemDecoration(new MyDividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL, 36));
        searchRecycle.setItemAnimator(new DefaultItemAnimator());
        searchRecycle.setAdapter(mAdapter);
        //    recyclerview.setNestedScrollingEnabled(false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMainActivityViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mMainActivityViewModel.initSearch();

        mMainActivityViewModel.getSearchItem().observe(this, new Observer<List<SearchItem>>() {
            @Override
            public void onChanged(@Nullable List<SearchItem> items) {
                mAdapter.notifyDataSetChanged();
            }
        });

        mMainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean) {
                    //   showProgressBar();
                } else {
                    //  hideProgressBar();
                    searchRecycle.smoothScrollToPosition(mMainActivityViewModel.getSearchItem().getValue().size() - 1);
                }
            }
        });
        setRecyclerItems();
        // TODO: Use the ViewModel
    }

}
