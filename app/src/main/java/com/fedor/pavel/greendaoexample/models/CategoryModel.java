package com.fedor.pavel.greendaoexample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;


@Entity(nameInDb = CategoryModel.RowName.DB_TABLE_NAME)
public class CategoryModel {

    @Id(autoincrement = true)
    private Long mId;

    @Expose
    @SerializedName(RowName.SERVER_ID)
    @Property(nameInDb = RowName.SERVER_ID)
    private int serverId;

    @Expose
    @SerializedName(RowName.KITCHEN_ID)
    @Property(nameInDb = RowName.KITCHEN_ID)
    private int parentId;

    @Expose
    @SerializedName(RowName.TITLE)
    @Property(nameInDb = RowName.TITLE)
    private String mTitle;

    @Generated(hash = 1664337925)
    public CategoryModel(Long mId, int serverId, int parentId, String mTitle) {
        this.mId = mId;
        this.serverId = serverId;
        this.parentId = parentId;
        this.mTitle = mTitle;
    }

    @Generated(hash = 1421288718)
    public CategoryModel() {
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

    public int getParentId() {
        return this.parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getMTitle() {
        return this.mTitle;
    }

    public void setMTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    public interface RowName {
        String DB_TABLE_NAME = "food_category";
        String SERVER_ID ="ID";
        String KITCHEN_ID = "PARENT_ID";
        String TITLE = "NAME";
    }

}
