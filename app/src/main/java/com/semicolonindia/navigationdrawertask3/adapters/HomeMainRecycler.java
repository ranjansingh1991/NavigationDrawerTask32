package com.semicolonindia.navigationdrawertask3.adapters;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.semicolonindia.navigationdrawertask3.R;
import com.semicolonindia.navigationdrawertask3.model.ItemObject;

import java.util.List;

/**
 * Created by RANJAN SINGH on 8/19/2017.
 */

public class HomeMainRecycler extends RecyclerView.Adapter<HomeMainRecycler.ViewHolder> {

    private Context context;
    private List<ItemObject> itemList;


    public HomeMainRecycler(Context context, List<ItemObject> itemList){
        this.context = context;
        this.itemList = itemList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_items, null);
        return new ViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_cardText.setText(itemList.get(position).getName());
        holder.iv_cardImage.setImageResource(itemList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_cardText;
        ImageView iv_cardImage;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_cardText = itemView.findViewById(R.id.tv_cardText);
            iv_cardImage = itemView.findViewById(R.id.iv_cardImage);
        }
    }
}
