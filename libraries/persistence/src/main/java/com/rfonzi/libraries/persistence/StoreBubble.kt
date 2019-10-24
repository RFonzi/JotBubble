package com.rfonzi.libraries.persistence

import com.rfonzi.libraries.model.Bubble

interface StoreBubble {
    fun storeBubble(bubble: Bubble)
}