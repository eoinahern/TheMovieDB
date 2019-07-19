package ie.eoinahern.imdbapp.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import ie.eoinahern.imdbapp.data.api.TMDBApi
import ie.eoinahern.imdbapp.util.API_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun getSearchApi(): TMDBApi {

        return Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder()
                        .add(KotlinJsonAdapterFactory()).build()
                )
            ).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(TMDBApi::class.java)

    }


}