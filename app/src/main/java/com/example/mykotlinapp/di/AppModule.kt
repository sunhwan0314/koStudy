package com.example.mykotlinapp.di

import com.example.mykotlinapp.ui.map.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

//앱에서 사용할 모듈 정의
var appModule = module{
    //repository 정의법
    //single {MyRepository(get())}
    viewModel{ HomeViewModel(get()/*get()함수가 들어가면 다른 의존성을 자동으로 찾아서 주입*/) }
}