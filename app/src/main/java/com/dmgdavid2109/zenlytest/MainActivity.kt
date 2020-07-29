package com.dmgdavid2109.zenlytest

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dmgdavid2109.zenlytest.RollingNumbersTextView.Companion.ANIMATION_DURATION
import com.robinhood.ticker.TickerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val BACKGROUND_ANIMATION_DURATION_MS = 2000
        const val INITIAL_VALUE = 256
        const val FINAL_VALUE = 294
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setBackgroundAnimation()

        number.setPreferredScrollingDirection(TickerView.ScrollingDirection.DOWN);
        number.setOnClickListener {
            GlobalScope.launch(context = Dispatchers.Main) {
                for (digit in INITIAL_VALUE..FINAL_VALUE) {
                    number.text = digit.toString()
                    delay(ANIMATION_DURATION)
                }
            }
        }
    }

    private fun setBackgroundAnimation() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        val animDrawable = root_layout.background as AnimationDrawable
        animDrawable.setExitFadeDuration(BACKGROUND_ANIMATION_DURATION_MS)
        animDrawable.isOneShot = true
        animDrawable.start()
    }
}
