package ie.eoinahern.imdbapp.ui.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ie.eoinahern.imdbapp.R

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, DetailsActivity::class.java)
    }
}
