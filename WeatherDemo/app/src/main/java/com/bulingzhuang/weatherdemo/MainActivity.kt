package com.bulingzhuang.weatherdemo

import android.os.Bundle
import android.widget.Toast
import com.bulingzhuang.weatherdemo.base.BaseActivity
import com.bulingzhuang.weatherdemo.bean.WeatherModel
import com.bulingzhuang.weatherdemo.utils.ApiCallback
import com.bulingzhuang.weatherdemo.utils.ApiClient

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addSubscription(ApiClient.retrofit().loadData("101020100"), object : ApiCallback<WeatherModel>() {

            override fun onSuccess(module: WeatherModel) {
                tv.text = module.toString()
            }

            override fun onFailure(msg: String?) {
                Toast.makeText(applicationContext, "错误信息：$msg", Toast.LENGTH_SHORT).show()
            }

            override fun onFinish() {
                //恢复初始状态
            }
        })
    }
}
