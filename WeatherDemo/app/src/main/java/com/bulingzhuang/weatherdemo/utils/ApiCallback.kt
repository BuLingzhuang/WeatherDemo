package com.bulingzhuang.weatherdemo.utils

import retrofit2.HttpException
import rx.Subscriber

/**
 * Created by bulingzhuang
 * on 2017/6/5
 * E-mail:bulingzhuang@foxmail.com
 */
abstract class ApiCallback<T> : Subscriber<T>() {

    abstract fun onSuccess(module: T)
    abstract fun onFailure(msg: String?)
    abstract fun onFinish()

    override fun onCompleted() {
        onFinish()
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable?) {
        if (e is HttpException) {
            val code = e.code()
            var msg = e.message
            when (code) {
                504 -> msg = "网络不给力"
                502, 404 -> msg = "服务器异常，请稍后再试"
            }
            onFailure(msg)
        } else {
            onFailure(e.toString())
        }
        onFinish()
    }

}