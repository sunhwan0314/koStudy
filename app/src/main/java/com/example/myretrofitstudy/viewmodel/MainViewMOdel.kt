package com.example.hiltexam.exam // 이 코틀린 파일이 속한 패키지 경로를 선언합니다.

import androidx.lifecycle.LiveData // LiveData 클래스를 임포트합니다. 데이터 변경을 관찰할 수 있게 합니다.
import androidx.lifecycle.MutableLiveData // MutableLiveData 클래스를 임포트합니다. LiveData의 값을 변경할 수 있게 합니다.
import androidx.lifecycle.ViewModel // Android 아키텍처 컴포넌트인 ViewModel 클래스를 임포트합니다. UI 데이터를 관리하며 생명주기를 고려합니다.
import androidx.lifecycle.viewModelScope // ViewModel의 생명주기와 함께 관리되는 코루틴 스코프를 임포트합니다. 비동기 작업에 사용됩니다.
import com.example.myretrofitstudy.data.remote.ApiService // Retrofit으로 정의한 API 서비스 인터페이스를 임포트합니다. 서버와 통신합니다.
import dagger.hilt.android.lifecycle.HiltViewModel // Hilt에서 ViewModel을 주입 가능하도록 만드는 어노테이션을 임포트합니다.
import kotlinx.coroutines.launch // 코루틴을 시작하기 위한 launch 함수를 임포트합니다.
import javax.inject.Inject // 의존성 주입을 요청하는 @Inject 어노테이션을 임포트합니다.

@HiltViewModel // 이 클래스가 Hilt에 의해 주입 가능한 ViewModel임을 선언합니다. Hilt가 이 ViewModel 인스턴스를 관리합니다.
class ExamViewModel @Inject constructor( // ExamViewModel 클래스를 선언합니다. @Inject constructor()를 통해 Hilt가 이 ViewModel을 생성할 때 의존성을 주입합니다.
    // ... 기존 의존성 ... // 이 부분은 원래 코드에 다른 의존성이 있었을 수 있음을 나타냅니다.
    //hilt로 의존성 주입 // Hilt를 사용하여 아래 apiService 객체를 주입받겠다는 주석입니다.
    private val apiService: ApiService // ApiService 타입의 객체를 주입받아 apiService라는 이름의 private 변수에 할당합니다.
): ViewModel() { // ViewModel 클래스를 상속받아 Androidx ViewModel의 기능을 사용합니다.

    //?? // 이 부분은 아래 _postResult 변수에 대한 질문 표시입니다.
    private val _postResult = MutableLiveData<String>() // API 호출 결과를 저장하고 UI에 알릴 MutableLiveData를 선언합니다. 값은 변경 가능합니다.
    //?? // 이 부분은 아래 postResult 변수에 대한 질문 표시입니다.
    val postResult: LiveData<String> = _postResult // _postResult를 외부에서 읽기 전용으로 노출하는 LiveData를 선언합니다. UI는 이 LiveData를 관찰합니다.

    fun fetchPostById(id: Int) { // 특정 ID를 가진 게시물을 가져오는 함수를 선언합니다.
        // // 이 부분은 아래 viewModelScope.launch 블록에 대한 주석 표시입니다.
        viewModelScope.launch { // ViewModel의 생명주기에 맞춰 코루틴을 시작합니다. 비동기 네트워크 요청을 실행합니다.
            try { // 예외(오류)가 발생할 수 있는 코드를 묶는 블록입니다.
                val response = apiService.getPost(id) // apiService를 통해 서버에 getPost 요청을 보내고 응답을 받습니다. (비동기)
                if (response.isSuccessful) { // HTTP 응답 코드가 200번대(성공)인지 확인합니다.
                    val post = response.body() // 응답 본문(body)을 Post 객체로 파싱합니다.
                    _postResult.value = "Post fetched: ${post?.title}" // 성공 시 LiveData의 값을 업데이트하여 UI에 게시물 제목을 표시합니다.
                } else { // 응답이 성공적이지 않을 경우 (예: 404 Not Found, 500 Internal Server Error)
                    _postResult.value = "Error: ${response.code()}" // LiveData에 오류 코드와 함께 에러 메시지를 표시합니다.
                }
            } catch (e: Exception) { // try 블록에서 발생한 모든 예외(Exception)를 잡는 블록입니다.
                _postResult.value = "Network error: ${e.message}" // 네트워크 오류 발생 시 LiveData에 오류 메시지를 표시합니다.
            }
        }
    }
    // ... 기존 코드 ... // 이 부분은 원래 ViewModel에 다른 함수나 변수가 있었을 수 있음을 나타냅니다.
}