package ie.eoinahern.imdbapp.util

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView

class LoadingView(
    con: Context, attrsSet: AttributeSet? = null, style: Int = -1
) : LinearLayout(con, attrsSet, style) {

    private lateinit var loading: LinearLayout
    private lateinit var loadingText: TextView

    private fun init() {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

    }


    fun updateLoadingState() {

    }

    enum class State {
        LOADING,
        ERROR,
        GONE
    }
}