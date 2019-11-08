package com.omega.primebasket.ui.main;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.omega.primebasket.data.HomeFragItemRepository;
import com.omega.primebasket.data.OfferItemRepository;
import com.omega.primebasket.data.RepositoryCuisine;
import com.omega.primebasket.data.RepositorySearch;
import com.omega.primebasket.data.model.CuisineItem;
import com.omega.primebasket.data.model.HomeItem;
import com.omega.primebasket.data.model.OfferItem;
import com.omega.primebasket.data.model.SearchItem;

import java.util.List;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<HomeItem>> mListItem;
    private MutableLiveData<List<OfferItem>> mListOfferItem;
    private MutableLiveData<List<CuisineItem>> mListCuisineItem;
    private MutableLiveData<List<SearchItem>> mListSearchItem;
    private HomeFragItemRepository mRepoitem;
    private OfferItemRepository mRepoitemOffer;
    private RepositoryCuisine mRepoitemCuisine;
    private RepositorySearch mRepoitemSearch;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void initHome(){
        if(mListItem != null){
            return;
        }
        mRepoitem = HomeFragItemRepository.getInstance();
        mListItem = mRepoitem.getHomeItems();

        if(mListOfferItem != null){
            return;
        }
        mRepoitemOffer = OfferItemRepository.getInstance();
        mListOfferItem = mRepoitemOffer.getOfferItems();

    }


    public void initCuisine(){
        if(mListCuisineItem != null){
            return;
        }
        mRepoitemCuisine = RepositoryCuisine.getInstance();
        mListCuisineItem = mRepoitemCuisine.getCuisineItems();
    }

    public void initSearch(){
        if(mListSearchItem != null){
            return;
        }
        mRepoitemSearch = RepositorySearch.getInstance();
        mListSearchItem = mRepoitemSearch.getCuisineItems();
    }


    public void addNewValue(final HomeItem nicePlace){
        mIsUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<HomeItem> currentPlaces = mListItem.getValue();
                currentPlaces.add(nicePlace);
                mListItem.postValue(currentPlaces);
                mIsUpdating.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<List<HomeItem>> getHomeItems(){
        return mListItem;
    }
    public LiveData<List<SearchItem>> getSearchItem(){
        return mListSearchItem;
    }

    public LiveData<List<OfferItem>> getOfferItems(){
        return mListOfferItem;
    }
    public LiveData<List<CuisineItem>> getCuisineItems(){
        return mListCuisineItem;
    }
    public LiveData<Boolean> getIsUpdating(){
        return mIsUpdating;
    }
}
