package com.android.appcompose.composable.utility.cardgrid;

import com.android.appcompose.composable.utility.cardgrid.model.CardDataModel;
import com.android.appcompose.composable.utility.cardgrid.model.ParentModel;
import com.android.appcompose.utils.DataType;

public interface OnCardGridItemClickListener{
    void onItemCategoryClicked(ParentModel type);
    void onItemClicked(CardDataModel item);
}