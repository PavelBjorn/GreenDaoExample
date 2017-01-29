package com.fedor.pavel.greendaoexample.data.db;

import android.content.Context;

import com.fedor.pavel.greendaoexample.models.DaoMaster;
import com.fedor.pavel.greendaoexample.models.DaoSession;
import com.fedor.pavel.greendaoexample.models.FoodModel;
import com.fedor.pavel.greendaoexample.models.FoodModelDao;
import com.fedor.pavel.greendaoexample.models.KitchenModel;
import com.fedor.pavel.greendaoexample.models.SensuyakiResponseModel;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class DataBaseManager {

    private DaoMaster.DevOpenHelper mDevOpenHelper;
    private DaoSession mDaoSession;
    private DaoMaster mDaoMaster;
    private static DataBaseManager mInstance;
    private static final String DB_NAME = "green_dao_example";

    private DataBaseManager(Context mContext) {
        mDevOpenHelper = new DaoMaster.DevOpenHelper(mContext, DB_NAME);
    }

    public static void init(Context context) {
        if (mInstance == null) {
            mInstance = new DataBaseManager(context);
        }
    }

    public static DataBaseManager getInstance() {
        return mInstance;
    }

    public void open() {
        if (!isOpen()) {
            mDaoMaster = new DaoMaster(mDevOpenHelper.getWritableDatabase());
            mDaoSession = mDaoMaster.newSession();
        }
    }

    public void close() {
        if (isOpen()) {
            mDaoMaster.getDatabase().close();
            mDaoMaster = null;
            mDaoSession.clear();
            mDaoSession = null;
        }
    }

    private boolean isOpen() {
        return (mDaoSession != null)
                && (mDaoMaster != null)
                && (mDevOpenHelper != null);
    }

    public void insertData(SensuyakiResponseModel model) {
        mDaoSession.getKitchenModelDao().insertOrReplaceInTx(model.getKitchenModels());
        mDaoSession.getCategoryModelDao().insertOrReplaceInTx(model.getCategoryModels());
        mDaoSession.getFoodModelDao().insertInTx(model.getFoodModels());
    }

    public List<KitchenModel> getKitchens() {
        List<KitchenModel> kitchenModels = new ArrayList<>();
        QueryBuilder qb = mDaoSession.getKitchenModelDao().queryBuilder();
        kitchenModels.addAll(qb.list());
        return kitchenModels;
    }

    public List<FoodModel> getFood(int parentID) {
        return mDaoSession.getFoodModelDao()
                .queryBuilder()
                .where(FoodModelDao.Properties.MCategoryId.like("%id:" + parentID + "%"))
                .list();
    }

}
