package ie.eoinahern.imdbapp.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import ie.eoinahern.imdbapp.IMDBApp
import javax.inject.Singleton


@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun getContext(app: IMDBApp): Context = app.applicationContext

    @Provides
    @Singleton
    fun sharedPrefs(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Provides
    @Singleton
    fun getPrefsEdit(sharedPrefs: SharedPreferences): SharedPreferences.Editor {
        return sharedPrefs.edit()
    }


}