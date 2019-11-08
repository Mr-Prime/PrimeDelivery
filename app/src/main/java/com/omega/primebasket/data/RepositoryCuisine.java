package com.omega.primebasket.data;



import androidx.lifecycle.MutableLiveData;

import com.omega.primebasket.data.model.CuisineItem;
import com.omega.primebasket.data.model.HomeItem;

import java.util.ArrayList;
import java.util.List;


/**
 * Singleton pattern
 */
public class RepositoryCuisine {

    private static RepositoryCuisine instance;
    private ArrayList<CuisineItem> dataSet = new ArrayList<>();

    public static RepositoryCuisine getInstance(){
        if(instance == null){
            instance = new RepositoryCuisine();
        }
        return instance;
    }


    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<CuisineItem>> getCuisineItems(){
        setItems();
        MutableLiveData<List<CuisineItem>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setItems(){
        dataSet.clear();
        dataSet.add(
                new CuisineItem("Chicken",
                        0,
                        "https://static.pexels.com/photos/372882/pexels-photo-372882.jpeg",
                        "3 Outlets"
                        )
        );

        dataSet.add(
                new CuisineItem("Fish",
                        0,
                        "https://static.pexels.com/photos/916925/pexels-photo-916925.jpeg",
                        "7 Outlets"
                )
        );

        dataSet.add(
                new CuisineItem("Pickles",
                        0,
                        "https://static.pexels.com/photos/842571/pexels-photo-842571.jpeg",
                        "2 Outlets"
                )
        );

        dataSet.add(
                new CuisineItem("Marinates",
                      0,
                        "https://static.pexels.com/photos/2525682/pexels-photo-2525682.png",
                        "5 Outlets"
                )
        );

    }
}











