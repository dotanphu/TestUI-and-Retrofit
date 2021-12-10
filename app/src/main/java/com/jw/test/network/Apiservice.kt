package com.jw.test.network

import com.jw.test.model.AndroidVersion
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET


interface Apiservice {
    @GET("android/jsonarray/")
    fun getAndroidVersion(): Observable<List<AndroidVersion>>
}