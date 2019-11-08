package com.omega.primebasket.ui.fragsearch;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.omega.primebasket.R;
import com.omega.primebasket.data.model.SearchItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {

    private List<SearchItem> mList = new ArrayList<>();
    private Context mContext;

    public SearchAdapter(Context context, List<SearchItem> item) {
        mList = item;
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_search_item, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        SearchItem row = mList.get(position);
        // Set the name of the 'NicePlace'
        // ((ViewHolder) viewHolder).mName.setText(mNicePlaces.get(i).getTitle());

        // Set the image
        Uri uri = Uri.parse(row.getImage());
        Log.e("PD", "link " + uri);
        Glide.with(mContext)
                .load(uri)
                .centerCrop()
                .encodeQuality(25)
                // .apply(RequestOptions.circleCropTransform())
                .transition(DrawableTransitionOptions.withCrossFade())
                //   .placeholder(R.drawable.loading_spinner)
                .into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.chinesses_img)
        ImageView image;
        @BindView(R.id.best_Saller)
        FrameLayout bestSaller;
        @BindView(R.id.lunchbox_txt)
        TextView lunchboxTxt;
        @BindView(R.id.side_txt)
        TextView sideTxt;
        @BindView(R.id.area_txt)
        TextView areaTxt;
        @BindView(R.id.discount_txt)
        TextView discountTxt;
        @BindView(R.id.rating_txt)
        TextView ratingTxt;
        @BindView(R.id.time_txt)
        TextView timeTxt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
