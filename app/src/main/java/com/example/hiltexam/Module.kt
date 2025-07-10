// Module.kt 파일
package com.example.hiltexam

import com.example.hiltexam.repository.InterRepo // 인터페이스 임포트 필요
import com.example.hiltexam.repository.MyRepo
import dagger.Binds // @Binds 임포트 필요
import dagger.Module
import dagger.Provides // @Provides도 계속 사용한다면 필요
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
// object Module 대신 abstract class Module로 변경
abstract class AppBindingModule { // 다른 모듈 이름으로 변경하는 것이 좋음, 예를 들어 AppBindingModule

    // MyRepo를 InterRepo에 바인딩하는 @Binds 메서드
    @Binds
    @Singleton // InterRepo를 싱글톤으로 제공하려면 필요
    abstract fun bindInterRepo(myRepoImpl: MyRepo): InterRepo // 이제 추상 함수가 추상 클래스 안에!

    // 기존의 @Provides 메서드가 있다면 계속 여기에 둘 수 있음
    // (만약 MyRepository가 아닌 MyRepo를 제공하고 싶다면 아래 주석처럼 수정)
    // @Provides
    // @Singleton
    // fun provideMyRepoConcrete(): MyRepo {
    //     return MyRepo() // MyRepo의 구체적인 인스턴스 제공
    // }

    // 만약 여전히 MyRepository라는 다른 클래스를 제공해야 한다면 그대로 유지
    @Provides
    @Singleton
    fun myrepo(): MyRepo{
        return MyRepo()

    }
}