package com.example.rickandmorty.koin

import com.example.rickandmorty.BuildConfig
import com.example.rickandmorty.network.Api
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val TIMEOUT = 15L
const val BASE_URL = "https://rickandmortyapi.com/"
val NetModule = module {

    single {

        val builder = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)

        try {
            if (BuildConfig.DEBUG) {
                val loggingInterceptor = okhttp3.logging.HttpLoggingInterceptor()
                loggingInterceptor.level = okhttp3.logging.HttpLoggingInterceptor.Level.BODY
                builder.addInterceptor(loggingInterceptor)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        builder.build()

    }

    single<Api>{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()
        retrofit.create(Api::class.java)
    }

}
