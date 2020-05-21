package com.example.common.preferences

import android.content.SharedPreferences
import android.location.Location
import androidx.core.content.edit
import com.example.common.extensions.safeLet
import javax.inject.Inject

class AppPreferences @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : PreferencesHelper {
    override var lastLocation: Location?
        get() {
            val lat = sharedPreferences.getString(LATITUDE, null)?.toDouble()
            val lon = sharedPreferences.getString(LONGITUDE, null)?.toDouble()

            return safeLet(lat, lon) { _latitude, _longitude ->
                Location("").apply {
                    latitude = _latitude
                    longitude = _longitude
                }
            }
        }
        set(value) {
            sharedPreferences.edit {
                putString(LATITUDE, value?.latitude.toString())
                putString(LONGITUDE, value?.longitude.toString())
            }
        }

    companion object {
        const val LATITUDE = "LATITUDE"
        const val LONGITUDE = "LONGITUDE"
    }
}