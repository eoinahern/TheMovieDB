package ie.eoinahern.imdbapp.util

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import ie.eoinahern.imdbapp.R


class LoadingView : FrameLayout {

    private lateinit var loading: LinearLayout
    private lateinit var loadingText: LinearLayout
    private lateinit var errorTxt: TextView

    constructor(con: Context) : super(con) {
        init(con)
    }

    constructor(con: Context, attrsSet: AttributeSet) : super(con, attrsSet) {
        init(con)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    fun setErrorText(outputStr: String) {
        errorTxt.text = outputStr
    }

    private fun init(con: Context) {
        val view = inflate(con, R.layout.loading_view_layout, this)
        loading = view.findViewById(R.id.pb_layout)
        loadingText = view.findViewById(R.id.warning_layout)
        errorTxt = view.findViewById(R.id.error_txt)
    }

    fun updateLoadingState(currentState: State) {

        when (currentState) {
            State.LOADING -> {
                loading.visibility = View.VISIBLE
                loadingText.visibility = View.GONE
            }
            State.ERROR -> {
                loading.visibility = View.GONE
                loadingText.visibility = View.VISIBLE

            }
            State.GONE -> this.visibility = View.GONE
        }
    }

    enum class State {
        LOADING,
        ERROR,
        GONE
    }
}