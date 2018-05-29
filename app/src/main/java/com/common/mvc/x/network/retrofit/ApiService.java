package com.common.mvc.x.network.retrofit;

import com.common.mvc.x.model.BaseModel;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * @author xiao
 * @date 2018/5/23
 */
public interface ApiService {


    @POST("")
    Observable<BaseModel> deviceList();
}
