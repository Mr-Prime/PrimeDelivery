package com.omega.primebasket.ui.fraghome;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.omega.primebasket.R;
import com.omega.primebasket.data.model.OfferItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.MyViewHolder> {

    private List<OfferItem> mList = new ArrayList<>();
    private Context mContext;

    public OfferAdapter(Context context, List<OfferItem> items) {
        mList = items;
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_homeoffer_item, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        OfferItem row = mList.get(position);
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

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.offert)
        TextView offert;
        @BindView(R.id.text1)
        TextView text1;
        @BindView(R.id.text2)
        TextView text2;
        @BindView(R.id.cardview)
        CardView cardview;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
