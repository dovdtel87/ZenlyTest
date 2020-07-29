package com.dmgdavid2109.zenlytest

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val ANIMATION_DURATION_MS = 2000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setAnimation()
    }

    private fun setAnimation() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        val animDrawable = root_layout.background as AnimationDrawable
        animDrawable.setExitFadeDuration(ANIMATION_DURATION_MS)
        animDrawable.isOneShot = true
        animDrawable.start()
    }
}
