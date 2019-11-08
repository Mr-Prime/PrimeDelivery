package com.omega.primebasket.ui.fragcuisines;

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
import androidx.recyclerview.widget.RecyclerView;

import com.omega.primebasket.R;
import com.omega.primebasket.data.model.CuisineItem;
import com.omega.primebasket.ui.main.MainViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CuisineFragment extends Fragment {


    @BindView(R.id.cuisines_recycle)
    RecyclerView cuisinesRecycle;
    private MainViewModel mMainActivityViewModel;

    public static CuisineFragment newInstance() {
        return new CuisineFragment();
    }

    private View view;
    private CuisineItemAdapter mAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_cuisines, container, false);

        ButterKnife.bind(this, view);


        return view;


    }

    private void setRecyclerItems() {
        mAdapter = new CuisineItemAdapter(getContext(), mMainActivityViewModel.getCuisineItems().getValue());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        cuisinesRecycle.setLayoutManager(mLayoutManager);
        //   recyclerview.addItemDecoration(new MyDividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL, 36));
        cuisinesRecycle.setItemAnimator(new DefaultItemAnimator());
        cuisinesRecycle.setAdapter(mAdapter);
        //    recyclerview.setNestedScrollingEnabled(false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMainActivityViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mMainActivityViewModel.initCuisine();

        mMainActivityViewModel.getCuisineItems().observe(this, new Observer<List<CuisineItem>>() {
            @Override
            public void onChanged(@Nullable List<CuisineItem> items) {
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
                    cuisinesRecycle.smoothScrollToPosition(mMainActivityViewModel.getCuisineItems().getValue().size() - 1);
                }
            }
        });
        setRecyclerItems();
        // TODO: Use the ViewModel
    }

}
