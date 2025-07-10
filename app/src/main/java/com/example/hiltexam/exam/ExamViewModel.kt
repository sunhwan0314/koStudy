package com.example.hiltexam.exam

import androidx.lifecycle.ViewModel
import com.example.hiltexam.repository.InterRepo
import com.example.hiltexam.repository.MyRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel//hilt로 뷰모델 관리
//생성자에 @Inject가 붙었으니 hilt에게 이 뷰모델 클래스 만들때
//필요한 다른 객체 알아서 찾아 넣어라
class ExamViewModel @Inject constructor(
    //의존성 주입
    private val bindInterRepo: InterRepo,
    private val aRepo: MyRepo
): ViewModel() {
    //추상함수 구현
    fun myrepo(): String {
        return bindInterRepo.myrepo()

    }

}