package br.com.zup.frasesaleatorias.domain.model

import android.content.Context
import android.content.SharedPreferences
import br.com.zup.frasesaleatorias.constants.NAME

class SecurityPreferences(context: Context) {
    private val security: SharedPreferences =
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE)

    //        val shared: SharedPreferences = this.getSharedPreferences(NAME, 1)
//    val shared: SharedPreferences = applicationContext.getSharedPreferences(NAME, Context.MODE_PRIVATE)

    fun storeString(key: String, str: String) {
        security.edit().putString(key, str).apply()
    }

    fun getString(key: String): String {
        return security.getString(key, "") ?: ""
    }
}