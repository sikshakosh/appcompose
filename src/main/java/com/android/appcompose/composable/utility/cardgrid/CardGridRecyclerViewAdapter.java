package com.android.appcompose.composable.utility.cardgrid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.appcompose.BR;
import com.android.appcompose.R;
import com.android.appcompose.composable.utility.cardgrid.model.CardDataModel;
import com.android.appcompose.composable.utility.cardgrid.model.ParentModel;
import com.android.appcompose.database.model.ClassroomModel;
import com.android.appcompose.database.model.MentorModel;
import com.android.appcompose.databinding.CardgridItemBinding;
import com.android.appcompose.databinding.CardgridRecyclerviewBinding;
import com.android.appcompose.utils.DataType;

import java.util.ArrayList;

public class CardGridRecyclerViewAdapter extends RecyclerView.Adapter<CardGridRecyclerViewAdapter.MyViewHolder> implements OnCardGridItemClickListener {
    public ArrayList<ParentModel> parentModelArrayList;

    public Context cxt;
    private int spanCount;
    public CardGridListener listener;
    @Override
    public void onItemCategoryClicked(ParentModel model) {
        Log.d("CardGridRecyclerViewAdapter","item clicked");
        this.listener.onMoreClicked(model);
    }

    @Override
    public void onItemClicked(CardDataModel item) {

    }



    public CardGridRecyclerViewAdapter(ArrayList<ParentModel> exampleList,int noOfSpan, Context context, CardGridListener listener  ) {
        this.parentModelArrayList = exampleList;
        this.cxt = context;
        this.listener = listener;
        this.spanCount = noOfSpan;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CardgridRecyclerviewBinding  binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.cardgrid_recyclerview, parent, false);

        CardGridRecyclerViewAdapter.MyViewHolder viewHolder = new CardGridRecyclerViewAdapter.MyViewHolder(binding);

        return viewHolder;

    }

    @Override
    public int getItemCount() {
        return parentModelArrayList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ParentModel currentItem = parentModelArrayList.get(position);


        GridLayoutManager manager = new GridLayoutManager(holder.itemBinding.items.getContext(), this.spanCount, GridLayoutManager.HORIZONTAL, false);
        holder.itemBinding.items.setLayoutManager(manager);
        holder.itemBinding.items.setHasFixedSize(true);
        holder.itemBinding.setItemClickListener(this);
        holder.bind(currentItem);
        ArrayList<Object>  arrayList  = currentItem.getData();
        CardRecyclerViewAdapter cardRecyclerViewAdapter = new CardRecyclerViewAdapter(holder.itemBinding.items.getContext(),arrayList,currentItem.getType(), LinearLayout.HORIZONTAL,listener);
        holder.itemBinding.items.setAdapter(cardRecyclerViewAdapter);
//        SpacesItemDecoration spacesDecoration = new SpacesItemDecoration(8) ;
//        holder.childRecyclerView.addItemDecoration(spacesDecoration);
        cardRecyclerViewAdapter.notifyDataSetChanged();



    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {



        public CardgridRecyclerviewBinding itemBinding;

        public MyViewHolder(View itemView) {
            super(itemView);

        }
        public MyViewHolder(CardgridRecyclerviewBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
        public void bind(ParentModel model) {
            itemBinding.setVariable(BR.model, model);

            itemBinding.executePendingBindings();
        }

    }
}

