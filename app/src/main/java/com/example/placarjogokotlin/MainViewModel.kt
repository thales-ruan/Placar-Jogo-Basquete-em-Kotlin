package com.example.placarjogokotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application){

  //  private val mvalorLocal = MutableLiveData<Int>()
    private val mValorLocal = MutableLiveData<Int>()
    val valorLocal : LiveData<Int> = mValorLocal

  private val mValorVisitante = MutableLiveData<Int>()
  val valorVisitante : LiveData<Int> = mValorVisitante

    init {
        mValorLocal.value = 0
        mValorVisitante.value = 0
    }


    fun incremetaUmLocal(){
        mValorLocal.value = mValorLocal.value?.plus(1)
    }

    fun incremetaDoisLocal(){
      mValorLocal.value = mValorLocal.value?.plus(2)
    }

    fun decrementaLocal(){

      if(mValorLocal.value!! > 0){
        mValorLocal.value = mValorLocal.value?.minus(1)
      }
    }

  fun incremetaUmVisitante(){
    mValorVisitante.value = mValorVisitante.value?.plus(1)
  }

  fun incremetaDoisVisitante(){
    mValorVisitante.value = mValorVisitante.value?.plus(2)
  }

  fun decrementaVisitante(){

    if(mValorVisitante.value!! > 0){
      mValorVisitante.value = mValorVisitante.value?.minus(1)
    }
  }
}