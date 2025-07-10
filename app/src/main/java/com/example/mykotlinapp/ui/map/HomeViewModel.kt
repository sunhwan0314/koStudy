package com.example.mykotlinapp.ui.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mykotlinapp.repository.MyRepository

//의존성 주입됨.
class HomeViewModel(private val repository: MyRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    
    //저장소 주입
    val b: String = repository.getData()
    val text: LiveData<String> = _text
}