package com.EnceptCode.MorseCode

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

object Consts {
    const val AD_ID = "ca-app-pub-6910652682395372/8818939855"

    fun openUrl(url: String, c: Context) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(c, Uri.parse(url))
    }
}