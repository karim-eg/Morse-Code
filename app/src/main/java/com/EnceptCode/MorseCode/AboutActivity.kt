package com.EnceptCode.MorseCode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.EnceptCode.MorseCode.Consts.openUrl
import com.EnceptCode.MorseCode.databinding.AboutBinding
import com.google.android.gms.ads.AdRequest

class AboutActivity : AppCompatActivity() {
    private lateinit var bind: AboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        bind = AboutBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        bind.apply {
            adView1.loadAd(AdRequest.Builder().build())

            textWebsite.setOnClickListener {
                openUrl("https://kotect.com", this@AboutActivity)
            }

            cardCoApp.setOnClickListener {
                openUrl("https://play.google.com/store/apps/details?id=com.EnceptCode.CodingOasis", this@AboutActivity)
            }
        }

    }
}
