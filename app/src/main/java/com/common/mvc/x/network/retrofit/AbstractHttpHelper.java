package com.common.mvc.x.network.retrofit;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * @author xiao
 * @date 2018/5/28
 */
public interface AbstractHttpHelper<T> {

    Observable<T> onRequest(ApiService apiService);

    Observer<T> onResponse();
}
