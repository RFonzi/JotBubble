package com.rfonzi.libraries.persistence_inmemory

import com.rfonzi.libraries.model.Bubble
import com.rfonzi.libraries.persistence.StoreBubble

internal class StoreBubbleInMemory(private val store: InMemoryStore) : StoreBubble {
    override fun storeBubble(bubble: Bubble) {
        store.map[bubble.id] = bubble
    }
}