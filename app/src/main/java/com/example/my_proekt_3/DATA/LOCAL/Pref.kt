package com.example.my_proekt_3.DATA.LOCAL

import android.content.Context

class Pref(context: Context) {
    private val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun isShow(): Boolean {
        return pref.getBoolean(SHOWED_KEY, false)
    }


    fun onShowed() {
        pref.edit().putBoolean(SHOWED_KEY, true).apply()
    }

    fun setName(name: String) {
        pref.edit().putString(PREF_NAME, name).apply()
    }

    fun getName(): String? {
        return pref.getString(PREF_NAME, null)
    }

    fun saveImg(img: String) {
        pref.edit().putString(IMG_KEY, img).apply()
    }

    fun getImg(): String? {
        return pref.getString(IMG_KEY, null)
    }

    companion object {
        const val PREF_NAME = "pref_name"
        const val SHOWED_KEY = "showed_key"
        const val IMG_KEY = "img.ld"
    }
}