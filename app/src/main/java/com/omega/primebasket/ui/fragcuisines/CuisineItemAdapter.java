package com.omega.primebasket.ui.fragcuisines;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.omega.primebasket.R;
import com.omega.primebasket.data.model.CuisineItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CuisineItemAdapter extends RecyclerView.Adapter<CuisineItemAdapter.MyViewHolder> {


    private List<CuisineItem> mList = new ArrayList<>();
    private Context mContext;

    public CuisineItemAdapter(Context context, List<CuisineItem> item) {
        mList = item;
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_cuisines_item, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        CuisineItem row = mList.get(position);
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

        viewHolder.title.setText(row.getTitle());
        viewHolder.outlets.setText(row.getOutlets());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.chinesses_txt)
        TextView title;
        @BindView(R.id.layout)
        LinearLayout layout;
        @BindView(R.id.outlets)
        TextView outlets;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
