package com.bulingzhuang.weatherdemo.bean

/**
 * Created by bulingzhuang
 * on 2017/6/5
 * E-mail:bulingzhuang@foxmail.com
 */
data class WeatherModel constructor(val weatherinfo: WeatherInfoBean) {
    data class WeatherInfoBean(
            val city: String,
            val cityid: String,
            val temp: String,
            val WD: String,
            val WS: String,
            val SD: String,
            val WSE: String,
            val time: String,
            val isRadar: String,
            val Radar: String,
            val njd: String,
            val qy: String,
            val rain: String

    ) {
        override fun toString(): String {
            return "WeatherInfoBean：\ncity='$city'\ncityId='$cityid'\ntemp='$temp'\nWD='$WD'\nWS='$WS'\nSD='$SD'\nWSE='$WSE'\ntime='$time'\nisRadar='$isRadar'\nRadar='$Radar'\nnjd='$njd'\nqy='$qy'\nrain='$rain'"
        }
    }

    override fun toString(): String {
        return "WeatherModel：\n$weatherinfo"
    }

}