package com.iconicdev.simplecalculator

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel


/**
 * Created by Manuel Chris-Ogar on 6/13/2019.
 */
public class MainActivityViewModel : ViewModel() {

    var currentAnswer: MutableLiveData<String>? = MutableLiveData()

    fun setCurrentAnswer(newAnswer: String) {
        currentAnswer!!.postValue(newAnswer)
    }
}
