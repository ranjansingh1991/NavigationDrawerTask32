package com.semicolonindia.navigationdrawertask3.drawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.semicolonindia.navigationdrawertask3.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by RANJAN SINGH on 8/19/2017.
 */

public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.ViewHolder> {

    List<NavDrawerPojo> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    // Constructer
    public NavigationDrawerAdapter(Context context, List<NavDrawerPojo> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }
    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_row, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NavDrawerPojo current = data.get(position);
        holder.title.setText(current.getTitle());
    }



    @Override
    public int getItemCount() {
        return data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
