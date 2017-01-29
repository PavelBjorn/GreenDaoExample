package com.fedor.pavel.greendaoexample.data.api;



import com.fedor.pavel.greendaoexample.models.SensuyakiResponseModel;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Pavel on 26.11.2016.
 */

 public interface SensuyakiTestApi {

    @GET("api_test.php")
    Observable<SensuyakiResponseModel> getData();

}
