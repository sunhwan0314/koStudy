package com.example.myretrofitstudy.data.remote

import com.example.myretrofitstudy.data.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

//인터페이스
interface ApiService{
    //GET메서드(uri)
    //비동기처리를 위한 suspend fun 함수명(id를 Int로 받곗다 근데 @Path니까 retrofit에게 이 매개변수 알림 )
    // Response<Post>는 Post를 반환하겠다
    @GET("posts/{id}")
    suspend fun getPost(@Path("id") id: Int): Response<Post>

}