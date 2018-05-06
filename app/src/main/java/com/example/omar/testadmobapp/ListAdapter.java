package com.example.omar.testadmobapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by omar on 5/5/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.RecyclerViewHolder>{

    ArrayList<ListModel> listModels;
    Context context;

    private int lastPosition = -1;

    public ListAdapter(Context context,ArrayList<ListModel> listModels){
        this.listModels=listModels;
        this.context=context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_items,parent,false);
        RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.imgList.setImageResource(listModels.get(position).getListImage());

        // Here you apply the animation when the view is bound
        setAnimation(holder.itemView, position);

    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        ImageView imgList;
        public RecyclerViewHolder(View view){
            super(view);
            imgList=view.findViewById(R.id.image_list);
        }
    }


    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.item_animation_slide_from_bottom);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

}
