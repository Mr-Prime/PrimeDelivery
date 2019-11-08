package com.omega.primebasket.ui.fragoffer;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.omega.primebasket.R;
import com.omega.primebasket.data.model.OfferItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.Prime on 06-10-2019.
 */
public class MyViewPagerAdapter extends PagerAdapter {
    private String[] mList;
    private Context mContext;
    public MyViewPagerAdapter(Context context, String[] items) {
        mList=null;
        mList = items;
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.list_pager_item, container, false);

        Uri uri = Uri.parse(mList[position]);
        Log.e("PD","link "+uri);
        ImageView imageView = view.findViewById(R.id.image);
        Glide.with(mContext)
                .load(uri)
                .centerCrop()
                .encodeQuality(25)
                // .apply(RequestOptions.circleCropTransform())
                .transition(DrawableTransitionOptions.withCrossFade())
                //   .placeholder(R.drawable.loading_spinner)
                .into(imageView);

    //    imageView.setImageResource(mList[position]);

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        Log.e("PD","mList.length "+mList.length);
        return mList.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
