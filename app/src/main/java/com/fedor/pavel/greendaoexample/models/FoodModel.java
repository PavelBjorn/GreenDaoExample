package com.fedor.pavel.greendaoexample.models;

import com.fedor.pavel.greendaoexample.utils.IntegerList;
import com.fedor.pavel.greendaoexample.utils.PriceList;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.converter.PropertyConverter;

import static com.fedor.pavel.greendaoexample.models.FoodModel.RowName.CATEGORIES_ID;
import static com.fedor.pavel.greendaoexample.models.FoodModel.RowName.CITIES_ID;
import static com.fedor.pavel.greendaoexample.models.FoodModel.RowName.DESCRIPTION;
import static com.fedor.pavel.greendaoexample.models.FoodModel.RowName.DETAIL_ICON;
import static com.fedor.pavel.greendaoexample.models.FoodModel.RowName.IS_SPICY;
import static com.fedor.pavel.greendaoexample.models.FoodModel.RowName.NAME;
import static com.fedor.pavel.greendaoexample.models.FoodModel.RowName.PRICES;
import static com.fedor.pavel.greendaoexample.models.FoodModel.RowName.SERVER_ID;
import static com.fedor.pavel.greendaoexample.models.FoodModel.RowName.TABLE_NAME;
import static com.fedor.pavel.greendaoexample.models.FoodModel.RowName.THUMB_ICON;
import static com.fedor.pavel.greendaoexample.models.FoodModel.RowName.WEIGHT;

import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Pavel on 26.11.2016.
 */
@Entity(nameInDb = TABLE_NAME)
public class FoodModel {

    @Id(autoincrement = true)
    private Long mId;

    @Expose
    @SerializedName(SERVER_ID)
    @Index(unique = true)
    private int serverId;

    @Expose
    @SerializedName(NAME)
    private String foodName;

    @Expose
    @SerializedName(DESCRIPTION)
    private String mDescription;

    @Expose
    @SerializedName(WEIGHT)
    private String weight;

    @Expose
    @SerializedName(THUMB_ICON)
    private String urlThumb;

    @Expose
    @SerializedName(DETAIL_ICON)
    private String urlDetail;

    @Expose
    @SerializedName(IS_SPICY)
    private String mSpicyFood = "";

    @Expose
    @SerializedName(CITIES_ID)
    @Convert(converter = IntegerListConverter.class, columnType = String.class)
    private IntegerList mCityId = new IntegerList();

    @Expose
    @SerializedName(CATEGORIES_ID)
    @Convert(converter = IntegerListConverter.class, columnType = String.class)
    private IntegerList mCategoryId = new IntegerList();

    @Expose
    @SerializedName(PRICES)
    @Convert(converter = PriceListConverter.class, columnType = String.class)
    private PriceList mPrices = new PriceList();

    @Generated(hash = 1188309608)
    public FoodModel() {
    }

    @Generated(hash = 509372840)
    public FoodModel(Long mId, int serverId, String foodName, String mDescription, String weight,
            String urlThumb, String urlDetail, String mSpicyFood, IntegerList mCityId,
            IntegerList mCategoryId, PriceList mPrices) {
        this.mId = mId;
        this.serverId = serverId;
        this.foodName = foodName;
        this.mDescription = mDescription;
        this.weight = weight;
        this.urlThumb = urlThumb;
        this.urlDetail = urlDetail;
        this.mSpicyFood = mSpicyFood;
        this.mCityId = mCityId;
        this.mCategoryId = mCategoryId;
        this.mPrices = mPrices;
    }

    public Long getMId() {
        return this.mId;
    }

    public void setMId(Long mId) {
        this.mId = mId;
    }

    public int getServerId() {
        return this.serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public String getFoodName() {
        return this.foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getMDescription() {
        return this.mDescription;
    }

    public void setMDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getUrlThumb() {
        return this.urlThumb;
    }

    public void setUrlThumb(String urlThumb) {
        this.urlThumb = urlThumb;
    }

    public String getUrlDetail() {
        return this.urlDetail;
    }

    public void setUrlDetail(String urlDetail) {
        this.urlDetail = urlDetail;
    }

    public String getMSpicyFood() {
        return this.mSpicyFood;
    }

    public void setMSpicyFood(String mSpicyFood) {
        this.mSpicyFood = mSpicyFood;
    }

    public IntegerList getMCityId() {
        return this.mCityId;
    }

    public void setMCityId(IntegerList mCityId) {
        this.mCityId = mCityId;
    }

    public IntegerList getMCategoryId() {
        return this.mCategoryId;
    }

    public void setMCategoryId(IntegerList mCategoryId) {
        this.mCategoryId = mCategoryId;
    }

    public PriceList getMPrices() {
        return this.mPrices;
    }

    public void setMPrices(PriceList mPrices) {
        this.mPrices = mPrices;
    }

    @Override
    public String toString() {
        return foodName;
    }

    public interface RowName {
        String TABLE_NAME = "foods";
        String SERVER_ID = "id";
        String DESCRIPTION = "description";
        String NAME = "name";
        String WEIGHT = "weight";
        String THUMB_ICON = "previewPicture";
        String DETAIL_ICON = "detailPicture";
        String IS_SPICY = "spicy";
        String CITIES_ID = "city_active";
        String CATEGORIES_ID = "sections";
        String PRICES = "prices";
    }

    public static class IntegerListConverter implements PropertyConverter<IntegerList, String> {

        @Override
        public IntegerList convertToEntityProperty(String databaseValue) {
            return new Gson()
                    .fromJson(databaseValue.replace("[id: ", "[")
                    .replace("id:", ","), IntegerList.class);
        }

        @Override
        public String convertToDatabaseValue(IntegerList entityProperty) {
            return new Gson().toJson(entityProperty).replace("[", "[id:").replace(",", " id:");
        }

    }

    public static class PriceListConverter implements PropertyConverter<PriceList, String> {

        @Override
        public PriceList convertToEntityProperty(String databaseValue) {

            return new Gson().fromJson(databaseValue, PriceList.class);
        }

        @Override
        public String convertToDatabaseValue(PriceList entityProperty) {
            return new Gson().toJson(entityProperty);
        }
    }
}
