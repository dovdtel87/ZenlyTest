package com.dmgdavid2109.zenlytest

import android.content.Context
import android.util.AttributeSet
import android.view.animation.LinearInterpolator
import androidx.core.content.res.ResourcesCompat
import com.robinhood.ticker.TickerUtils
import com.robinhood.ticker.TickerView

class RollingNumbersTextView @JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet? = null,
    defaultStyleAttributes: Int = 0
) : TickerView(context, attributes, defaultStyleAttributes) {

    companion object {
        const val ANIMATION_DURATION = 100L
        private const val INVALID_ID = 0
    }

    init {
        setCharacterLists(TickerUtils.provideNumberList())
        animationInterpolator = LinearInterpolator()
        animationDuration = ANIMATION_DURATION

        if (!isInEditMode) {
            setTextCustomFont(context, attributes, defaultStyleAttributes)
        }
    }

    private fun setTextCustomFont(context: Context, attrs: AttributeSet?, defaultStyleAttributes: Int) {
        val styledAttributes = context.obtainStyledAttributes(
                attrs,
                R.styleable.RollingNumbersTextView,
                defaultStyleAttributes,
                defaultStyleAttributes
        )

        try {
            val fontId =
                    styledAttributes
                            .getResourceId(R.styleable.RollingNumbersTextView_android_fontFamily, INVALID_ID)
            if (fontId != INVALID_ID) {
                textPaint.typeface = ResourcesCompat.getFont(context, fontId)
            }
        } finally {
            styledAttributes.recycle()
        }
    }
}
