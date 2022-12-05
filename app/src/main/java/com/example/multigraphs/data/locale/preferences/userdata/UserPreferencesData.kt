package com.example.multigraphs.data.locale.preferences.userdata

import com.example.multigraphs.data.locale.preferences.PreferencesConstants
import com.example.multigraphs.data.locale.preferences.PreferencesHelper

class UserPreferencesData(
    private val preferences: PreferencesHelper
) {
    var isAuthorized: Boolean
        get() = preferences().getBoolean(
            PreferencesConstants.USER_SING_IN, false
        )
        set(value) = preferences()
            .edit().putBoolean(
                PreferencesConstants.USER_SING_IN, value
            ).apply()
}