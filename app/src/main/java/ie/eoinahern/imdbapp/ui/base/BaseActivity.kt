package ie.eoinahern.imdbapp.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import ie.eoinahern.imdbapp.util.ViewModelFactory
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState, persistentState)
        setContentView(getLayout())
    }

    inline fun <reified T : ViewModel> getViewModel(clazz: Class<T>, block: T.() -> Unit): T {
        val viewModel = ViewModelProviders.of(this, factory)[clazz]
        viewModel.block()
        return viewModel
    }

    abstract fun getLayout(): Int
}