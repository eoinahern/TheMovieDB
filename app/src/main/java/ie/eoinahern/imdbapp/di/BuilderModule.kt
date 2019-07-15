package ie.eoinahern.imdbapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ie.eoinahern.imdbapp.ui.MainActivity

@Module
abstract class BuilderModule {

    @ContributesAndroidInjector
    abstract fun mainActivityBinder(): MainActivity
}