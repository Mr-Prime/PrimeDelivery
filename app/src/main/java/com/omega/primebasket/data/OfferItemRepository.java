package com.omega.primebasket.data;



import androidx.lifecycle.MutableLiveData;

import com.omega.primebasket.data.model.HomeItem;
import com.omega.primebasket.data.model.OfferItem;

import java.util.ArrayList;
import java.util.List;


/**
 * Singleton pattern
 */
public class OfferItemRepository {

    private static OfferItemRepository instance;
    private ArrayList<OfferItem> dataSet = new ArrayList<>();

    public static OfferItemRepository getInstance(){
        if(instance == null){
            instance = new OfferItemRepository();
        }
        return instance;
    }


    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<OfferItem>> getOfferItems(){
        setItems();
        MutableLiveData<List<OfferItem>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setItems(){
        dataSet.clear();
        dataSet.add(
                new OfferItem("",
                        "",
                        "",
                        "",
                        "https://static.pexels.com/photos/372882/pexels-photo-372882.jpeg"
                        )
        );

        dataSet.add(
                new OfferItem("",
                        "",
                        "",
                        "",
                        "https://static.pexels.com/photos/916925/pexels-photo-916925.jpeg"
                )
        );

        dataSet.add(
                new OfferItem("",
                        "",
                        "",
                        "",
                        "https://static.pexels.com/photos/842571/pexels-photo-842571.jpeg"
                )
        );

        dataSet.add(
                new OfferItem("",
                        "",
                        "",
                        "",
                        "https://static.pexels.com/photos/2525682/pexels-photo-2525682.png"
                )
        );

    }
}











