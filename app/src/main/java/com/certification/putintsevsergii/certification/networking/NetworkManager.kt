package com.certification.putintsevsergii.certification.networking

import com.certification.putintsevsergii.certification.networking.data.ChartsResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

const val NETWORK_TIMEOUT_VALUE = 20L
const val BASE_URL = "https://rss.itunes.apple.com/api/v1/"


interface NetworkManager {

    @GET("us/apple-music/top-songs/all/{count}/explicit.json")
    fun getTopSongCharts(@Path("count") count: Int): Call<ChartsResponse>

    companion object {
        val instance: NetworkManager by lazy {
            // val interceptor = HeaderInterceptor()
            val client = OkHttpClient.Builder().apply {
                readTimeout(NETWORK_TIMEOUT_VALUE, TimeUnit.SECONDS)
                writeTimeout(NETWORK_TIMEOUT_VALUE, TimeUnit.SECONDS)
                connectTimeout(NETWORK_TIMEOUT_VALUE, TimeUnit.SECONDS)
                retryOnConnectionFailure(true)
                // addInterceptor(interceptor)
            }
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client.build())
                    .build()
            retrofit.create(NetworkManager::class.java)
        }
    }
}