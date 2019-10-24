package com.rfonzi.libraries.persistence

import com.rfonzi.libraries.model.Bubble

interface GetBubble {
    fun getBubbleById(id: Long): Bubble
    fun getAllBubbles(): List<Bubble>
}