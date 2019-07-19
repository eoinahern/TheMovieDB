package ie.eoinahern.imdbapp.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ie.eoinahern.imdbapp.ui.details.DetailsViewModel
import ie.eoinahern.imdbapp.ui.main.MainViewModel


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @MyViewModelKey(MainViewModel::class)
    abstract fun getMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @MyViewModelKey(DetailsViewModel::class)
    abstract fun getDetailViewModel(detailsViewModel: DetailsViewModel): ViewModel
}