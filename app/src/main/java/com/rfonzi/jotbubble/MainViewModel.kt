package com.rfonzi.jotbubble

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rfonzi.jotbubble.uimodel.MainUiModel
import com.rfonzi.libraries.model.Bubble
import com.rfonzi.libraries.persistence.GetBubble

class MainViewModel(private val getBubble: GetBubble) : ViewModel() {

    val ui: MutableLiveData<MainUiModel> by lazy {
        MutableLiveData(MainUiModel(getBubble.getAllBubbles()))
    }

    init {
        ui.value = MainUiModel(listOf(
            Bubble(0, "asdf", listOf()),
            Bubble(1, "jkl;", listOf()),
            Bubble(2, "qwer", listOf()),
            Bubble(3, "tyui", listOf()),
            Bubble(4, "op[]", listOf()),
            Bubble(5, "zxcv", listOf()),
            Bubble(6, "bnm,", listOf()),
            Bubble(7, "1234", listOf()),
            Bubble(8, "5678", listOf()),
            Bubble(9, "90-=", listOf()),
            Bubble(10, "\\'/.", listOf()),
            Bubble(11, "asdf", listOf())
        ))
    }

}