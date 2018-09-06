package com.semicolonindia.navigationdrawertask3.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.semicolonindia.navigationdrawertask3.R;
import com.semicolonindia.navigationdrawertask3.activity.TabLayoutSlide;
import com.semicolonindia.navigationdrawertask3.model.ItemObject;

import java.util.List;

/**
 * Created by RANJAN SINGH on 8/16/2017.
 */
@SuppressWarnings("ALL")
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<ItemObject> itemList;
    Context context;

    public RecyclerAdapter(Context context, List<ItemObject> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_items, null);
        return new ViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tv_cardText.setText(itemList.get(position).getName());
        holder.iv_cardImage.setImageResource(itemList.get(position).getImage());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               switch (position) {
                    case 0:
                context.startActivity(new Intent(context, TabLayoutSlide.class));
                        break;

                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_cardText;
        ImageView iv_cardImage;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_cardText = (TextView) itemView.findViewById(R.id.tv_cardText);
            iv_cardImage = (ImageView) itemView.findViewById(R.id.iv_cardImage);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
        }
    }
}
