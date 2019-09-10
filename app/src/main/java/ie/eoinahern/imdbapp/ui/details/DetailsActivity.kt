package ie.eoinahern.imdbapp.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import ie.eoinahern.imdbapp.R
import ie.eoinahern.imdbapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbarSetup()
    }

    private fun toolbarSetup() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun getLayout(): Int = R.layout.activity_details

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, DetailsActivity::class.java)
    }
}
