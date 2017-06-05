package com.bulingzhuang.weatherdemo.utils

import com.bulingzhuang.weatherdemo.bean.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by bulingzhuang
 * on 2017/6/5
 * E-mail:bulingzhuang@foxmail.com
 */
interface ApiStores {
    companion object {
        val API_SERVER_URL = "http://www.weather.com.cn/"
    }

    @GET("data/sk/{cityId}.html")
    fun loadData(@Path("cityId") cityId: String): Observable<WeatherModel>
}