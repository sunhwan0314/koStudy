package com.example.mykotlinapp

import android.app.Application
import com.example.mykotlinapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            //android context제공
            androidContext(this@MyApplication)
            //위에서 만든 모듈들을 로드
            modules(appModule)
        }
    }
}
