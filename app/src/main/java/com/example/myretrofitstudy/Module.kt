// NetworkModule.kt (예: di/NetworkModule.kt)
package com.example.hiltexam.di

import com.example.myretrofitstudy.data.remote.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // 이 모듈의 객체들은 앱 생명주기 동안 싱글톤으로 유지됨
object NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().setLenient().create() // GSON 인스턴스 제공
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply { // HTTP 요청/응답 로깅 인터셉터
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging) // 로깅 인터셉터 추가
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/") // 베이스 URL
            .client(okHttpClient) // OkHttpClient 연결
            .addConverterFactory(GsonConverterFactory.create(gson)) // GSON 컨버터 팩토리 연결
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java) // Retrofit을 통해 ApiService 구현체 생성
    }
}