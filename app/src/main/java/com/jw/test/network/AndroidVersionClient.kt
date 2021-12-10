package com.jw.test.network

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AndroidVersionClient {
    private val headerInterceptor = Interceptor {
        val originRequest = it.request()
        val newRequest = originRequest.newBuilder()
            .header("Authorization", "this is jwt key")
            .build()
        it.proceed(newRequest)
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }


    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .addInterceptor(getLoggingInterceptor())
        .build()


    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://api.learn2crack.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    operator fun invoke(): Apiservice =
        retrofit.create(Apiservice::class.java)
}