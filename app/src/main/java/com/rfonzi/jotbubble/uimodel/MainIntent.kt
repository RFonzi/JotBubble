package com.rfonzi.jotbubble.uimodel

import com.rfonzi.jotbubble.MainActivity

sealed class MainIntent {
    object ToggleAddBubbleSheet : MainIntent()
}