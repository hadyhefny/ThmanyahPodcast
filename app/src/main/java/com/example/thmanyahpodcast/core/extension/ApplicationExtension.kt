package com.example.thmanyahpodcast.core.extension

import android.content.Context
import android.content.res.Configuration
import java.util.Locale

fun Context.changeLanguage(languageIdentifier: String = "ar"): Context {
    val locale = Locale(languageIdentifier)
    Locale.setDefault(locale)
    val config = Configuration(resources.configuration)
    config.setLocale(locale)
    return this.createConfigurationContext(config)
}