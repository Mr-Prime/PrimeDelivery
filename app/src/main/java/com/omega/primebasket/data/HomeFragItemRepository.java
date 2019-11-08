package com.omega.primebasket.data;



import androidx.lifecycle.MutableLiveData;

import com.omega.primebasket.data.model.HomeItem;

import java.util.ArrayList;
import java.util.List;


/**
 * Singleton pattern
 */
public class HomeFragItemRepository {

    private static HomeFragItemRepository instance;
    private ArrayList<HomeItem> dataSet = new ArrayList<>();

    public static HomeFragItemRepository getInstance(){
        if(instance == null){
            instance = new HomeFragItemRepository();
        }
        return instance;
    }


    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<HomeItem>> getHomeItems(){
        setItems();
        MutableLiveData<List<HomeItem>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setItems(){
        dataSet.clear();
        dataSet.add(
                new HomeItem("",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "https://static.pexels.com/photos/372882/pexels-photo-372882.jpeg"
                        )
        );

        dataSet.add(
                new HomeItem("",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "https://static.pexels.com/photos/916925/pexels-photo-916925.jpeg"
                )
        );

        dataSet.add(
                new HomeItem("",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "https://static.pexels.com/photos/842571/pexels-photo-842571.jpeg"
                )
        );

        dataSet.add(
                new HomeItem("",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "https://static.pexels.com/photos/2525682/pexels-photo-2525682.png"
                )
        );

    }
}











