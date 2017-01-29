package com.fedor.pavel.greendaoexample;

import android.app.Application;
import com.fedor.pavel.greendaoexample.data.db.DataBaseManager;




public class App extends Application {

    public static final String LOG_TAG = "app";

    @Override
    public void onCreate() {
        super.onCreate();
        DataBaseManager.init(this);
    }

}
