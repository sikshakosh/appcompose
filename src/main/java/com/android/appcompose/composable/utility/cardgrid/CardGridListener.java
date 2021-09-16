package com.android.appcompose.composable.utility.cardgrid;

import com.android.appcompose.composable.utility.cardgrid.model.CardDataModel;
import com.android.appcompose.composable.utility.cardgrid.model.ParentModel;

public interface CardGridListener {
    public void onCardClicked(CardDataModel card);
    public void onMoreClicked(ParentModel category);
}
