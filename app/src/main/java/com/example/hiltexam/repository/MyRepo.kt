package com.example.hiltexam.repository

import javax.inject.Inject

//의존성을 주입하겠다
class MyRepo @Inject constructor(): InterRepo {
    override fun myrepo(): String {
        TODO("Not yet implemented")
    }

}