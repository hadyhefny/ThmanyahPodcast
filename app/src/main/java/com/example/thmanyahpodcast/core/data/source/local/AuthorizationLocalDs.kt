package com.example.thmanyahpodcast.core.data.source.local

import android.content.SharedPreferences
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthorizationLocalDs @Inject constructor(
    private val sharedPref: SharedPreferences,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun saveAccessToken(token: String) {
        withContext(ioDispatcher) {
            sharedPref.edit().putString(ACCESS_TOKEN, token).commit()
        }
    }

    suspend fun getAccessToken(): String? {
        return withContext(ioDispatcher) {
            sharedPref.getString(ACCESS_TOKEN, null)
        }
    }

    companion object {
        private const val ACCESS_TOKEN = "access_token"
    }
}