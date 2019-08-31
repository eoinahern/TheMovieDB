package ie.eoinahern.imdbapp.data.api

import ie.eoinahern.imdbapp.util.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class APIInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newURL = request.url().newBuilder()
            .addQueryParameter("api_key", API_KEY).build()

        val newReq = request.newBuilder().url(newURL).build()
        return chain.proceed(newReq)
    }
}