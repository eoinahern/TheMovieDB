package ie.eoinahern.imdbapp.ui.main

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.android.AndroidInjection

import ie.eoinahern.imdbapp.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPrefs: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val boo = sharedPrefs.getBoolean("boo", true)
        } catch (e: Exception) {
            println("no prefs !!!")
        }

    }
}
