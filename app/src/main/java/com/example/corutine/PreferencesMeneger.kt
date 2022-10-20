package com.example.corutine

import android.content.Context
import android.content.SharedPreferences
import android.media.MediaCodec.MetricsConstants.MODE

class PreferencesMeneger(contex:Context) {
    private var sharedPreferences:SharedPreferences = contex.getSharedPreferences("acc",Context.MODE_PRIVATE)

    fun putString(key:String,value:String){
        var editor = sharedPreferences.edit()
        editor.putString(key,value)
        editor.apply()
    }

    fun getString(key:String):String?{
        return sharedPreferences.getString(key,null)

    }

}