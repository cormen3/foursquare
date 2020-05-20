package com.example.common.preferences

import android.content.SharedPreferences
import javax.inject.Inject

class AppPreferences @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : PreferencesHelper {
}