package com.omega.primebasket.ui.fraghome;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.omega.primebasket.R;
import com.omega.primebasket.data.model.CuisineItem;
import com.omega.primebasket.data.model.HomeItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    private List<HomeItem> mList= new ArrayList<>();
    private Context mContext;

    public ItemAdapter(Context context, List<HomeItem> item) {
        mList = item;
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_home_item, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        HomeItem row = mList.get(position);
        // Set the name of the 'NicePlace'
       // ((ViewHolder) viewHolder).mName.setText(mNicePlaces.get(i).getTitle());

        // Set the image
        Uri uri = Uri.parse(row.getImage());
        Log.e("PD","link "+uri);
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
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.title_tv)
        TextView titleTv;
        @BindView(R.id.style_tv)
        TextView styleTv;
        @BindView(R.id.place_tv)
        TextView placeTv;
        @BindView(R.id.filters)
        ImageView filters;
        @BindView(R.id.ratings_tv)
        TextView ratingsTv;
        @BindView(R.id.time_tv)
        TextView timeTv;
        @BindView(R.id.layout_item)
        LinearLayout layoutItem;
        @BindView(R.id.cardview)
        RelativeLayout cardview;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
