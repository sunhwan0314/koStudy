package com.example.hiltexam.exam

import androidx.fragment.app.Fragment
import com.example.hiltexam.repository.InterRepo
import com.example.hiltexam.repository.MyRepo
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//주입받겠다
@AndroidEntryPoint
class ExamFragment: Fragment() {
    //필드에 inject 붙었으니 hilt가 알아서 찾아서 주입해줌
    //이때 lateinit을 붙여서 hilt가 나중에 주입하도록
    @Inject
    lateinit var myRepo: MyRepo
    @Inject
    lateinit var bindInterRepo: InterRepo

}