package com.fedor.pavel.greendaoexample.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 26.11.2016.
 */

public class SensuyakiResponseModel {

    @SerializedName("sections_parent")
    private List<KitchenModel> mKitchenModels = new ArrayList<>();

    @SerializedName("sections")
    private List<CategoryModel> mCategoryModels  = new ArrayList<>();

    @SerializedName("products")
    private List<FoodModel> mFoodModels  = new ArrayList<>();



    public List<KitchenModel> getKitchenModels() {
        return mKitchenModels;
    }

    public List<CategoryModel> getCategoryModels() {
        return mCategoryModels;
    }

    public List<FoodModel> getFoodModels() {
        return mFoodModels;
    }
}
