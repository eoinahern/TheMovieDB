package ie.eoinahern.imdbapp.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import ie.eoinahern.imdbapp.IMDBApp
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, BuilderModule::class,
                ViewModelModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: IMDBApp): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: IMDBApp)
}