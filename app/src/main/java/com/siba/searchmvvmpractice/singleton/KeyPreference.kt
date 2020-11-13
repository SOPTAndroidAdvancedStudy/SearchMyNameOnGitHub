package com.siba.searchmvvmpractice.singleton

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

object KeyPreference {
    private val INTERPARK_APP_KEY = "interpark_app_key"
    private val PREF_KEY = "hashkey"
    private val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
    private val masterKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)
    private lateinit var sharedPref: SharedPreferences

    fun init(context: Context) {
        sharedPref = EncryptedSharedPreferences.create(
            PREF_KEY,
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        sharedPref
            .edit()
            .putString(INTERPARK_APP_KEY, "2034AC9E39C0CEACE7052132C0928CEA3D5B5FEC9AE9ABD8385599668CEEBB5C")
            .apply()
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    fun getKey(): String = sharedPref.getString(INTERPARK_APP_KEY, "")!!

}