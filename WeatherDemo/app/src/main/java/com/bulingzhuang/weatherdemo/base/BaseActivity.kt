package com.bulingzhuang.weatherdemo.base

import android.support.v7.app.AppCompatActivity
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by bulingzhuang
 * on 2017/6/5
 * E-mail:bulingzhuang@foxmail.com
 */
open class BaseActivity : AppCompatActivity() {
    val mCompositeSubscription: CompositeSubscription = CompositeSubscription()

    override fun onDestroy() {
        if (mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe()
        }
        super.onDestroy()
    }

    open fun <T> addSubscription(observable: Observable<T>, subscriber: Subscriber<T>) {
        mCompositeSubscription.add(
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(subscriber))
    }

}