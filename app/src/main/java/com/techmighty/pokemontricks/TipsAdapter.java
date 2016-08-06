package com.techmighty.pokemontricks;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by ankitvaria on 14/07/16.
 */
public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.MyViewHolder> {

    private String TAG = TipsAdapter.class.getSimpleName();

    private Context mContext;
    private List<PokemonTips> albumList;
    private RecyclerView mRecyclerView;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }


    public TipsAdapter(Context mContext, List<PokemonTips> albumList, RecyclerView recyclerView) {
        this.mContext = mContext;
        this.albumList = albumList;
        this.mRecyclerView = recyclerView;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tips_card, parent, false);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = mRecyclerView.getChildAdapterPosition(v);
                Log.e(TAG, "onClick :-" + pos);

                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("POSITION", pos+1);
                mContext.startActivity(intent);
            }
        });

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        PokemonTips album = albumList.get(position);
        holder.title.setText(album.getName());

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

}