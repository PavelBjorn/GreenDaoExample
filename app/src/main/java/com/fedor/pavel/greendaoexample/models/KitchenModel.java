package com.fedor.pavel.greendaoexample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = KitchenModel.RowName.DB_TABLE_NAME)
public class KitchenModel {

    @Id(autoincrement = true)
    private Long mID;

    @Expose
    @SerializedName("ID")
    @Property(nameInDb = RowName.SERVE_ID)
    @Index(unique = true)
    private long mServerId;

    @Expose
    @SerializedName(RowName.NAME)
    @Property(nameInDb = RowName.NAME)
    private String mName;

    @Generated(hash = 1959925628)
    public KitchenModel(Long mID, long mServerId, String mName) {
        this.mID = mID;
        this.mServerId = mServerId;
        this.mName = mName;
    }

    @Generated(hash = 505461186)
    public KitchenModel() {
    }

    public Long getMID() {
        return this.mID;
    }

    public void setMID(Long mID) {
        this.mID = mID;
    }

    public long getMServerId() {
        return this.mServerId;
    }

    public void setMServerId(long mServerId) {
        this.mServerId = mServerId;
    }

    public String getMName() {
        return this.mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public interface RowName {
        String SERVE_ID = "server_id";
        String NAME = "NAME";
        String DB_TABLE_NAME = "kitchen";
    }
}
