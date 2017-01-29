package com.fedor.pavel.greendaoexample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PriceModel {

    @Expose
    @SerializedName(PriceResponseKeys.PRODUCT_ID)
    private int mFoodId;

    @Expose
    @SerializedName(PriceResponseKeys.CITY_ID)
    private int mCityId;

    @Expose
    @SerializedName(PriceResponseKeys.VALUE)
    private int mValue;

    public PriceModel() {
    }

    public PriceModel(int foodId, int cityId, int value) {
        mFoodId = foodId;
        mCityId = cityId;
        mValue = value;
    }

    public int getFoodId() {
        return mFoodId;
    }

    public int getCityId() {
        return mCityId;
    }

    public int getValue() {
        return mValue;
    }

    @Override
    public String toString() {
        return "foodId: " + mFoodId + ", cityId: " + mCityId + ", value: " + mValue;
    }

    public static PriceModel createFromString(String priceModel) {
        String[] str = priceModel.split(",");

        return new PriceModel(Integer.parseInt(str[0])
                , Integer.parseInt(str[1])
                , Integer.parseInt(str[0]));
    }

    interface PriceResponseKeys {
        String TITLE = "prices";
        String PRODUCT_ID = "PRODUCT_ID";
        String CITY_ID = "CITY_ID";
        String VALUE = "VALUE";
    }
}
