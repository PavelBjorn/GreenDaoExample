package com.fedor.pavel.greendaoexample.view.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.fedor.pavel.greendaoexample.R;
import com.fedor.pavel.greendaoexample.data.api.SensuyakiTestService;
import com.fedor.pavel.greendaoexample.data.db.DataBaseManager;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DataBaseManager.getInstance().open();
        SensuyakiTestService.newInstance()
                .getApi()
                .getData()
                .subscribeOn(Schedulers.newThread())
                .flatMap(model -> {
                    DataBaseManager.getInstance().insertData(model);
                    return Observable.just(DataBaseManager.getInstance().getFood(57));
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(model ->
                                Log.d("MainActivity", model.toString())
                        , throwable -> Log.d("MainActivity", throwable.getMessage()), () -> {});
    }

    @Override
    protected void onDestroy() {
        DataBaseManager.getInstance().close();
        super.onDestroy();
    }
}
