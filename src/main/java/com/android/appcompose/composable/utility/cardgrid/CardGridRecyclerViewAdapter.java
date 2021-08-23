package com.android.appcompose.composable.utility.cardgrid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.appcompose.R;
import com.android.appcompose.composable.utility.cardgrid.model.ParentModel;

import java.util.ArrayList;

public class CardGridRecyclerViewAdapter extends RecyclerView.Adapter<CardGridRecyclerViewAdapter.MyViewHolder> {
    private ArrayList<ParentModel> parentModelArrayList;

    public Context cxt;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView category;
        public RecyclerView childRecyclerView;

        public MyViewHolder(View itemView) {
            super(itemView);

            category = itemView.findViewById(R.id.section);
            childRecyclerView = itemView.findViewById(R.id.items);
        }
    }

    public CardGridRecyclerViewAdapter(ArrayList<ParentModel> exampleList, Context context) {
        this.parentModelArrayList = exampleList;
        this.cxt = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardgrid_recyclerview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return parentModelArrayList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ParentModel currentItem = parentModelArrayList.get(position);
        GridLayoutManager manager = new GridLayoutManager(holder.childRecyclerView.getContext(), 2, GridLayoutManager.VERTICAL, false);

        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(cxt, LinearLayoutManager.HORIZONTAL, false);
        holder.childRecyclerView.setLayoutManager(manager);
        holder.childRecyclerView.setHasFixedSize(true);

        holder.category.setText(currentItem.getItemCategory());


        ArrayList<Object>  arrayList  = currentItem.getData();
        CardRecyclerViewAdapter cardRecyclerViewAdapter = new CardRecyclerViewAdapter(holder.childRecyclerView.getContext(),arrayList,currentItem.getType());
        holder.childRecyclerView.setAdapter(cardRecyclerViewAdapter);
//        SpacesItemDecoration spacesDecoration = new SpacesItemDecoration(8) ;
//        holder.childRecyclerView.addItemDecoration(spacesDecoration);
        cardRecyclerViewAdapter.notifyDataSetChanged();



    }
}