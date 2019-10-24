package com.rfonzi.libraries.persistence_inmemory

import com.rfonzi.libraries.model.Bubble
import com.rfonzi.libraries.persistence.GetBubble

internal class GetBubbleInMemory(private val store: InMemoryStore) : GetBubble {
    override fun getAllBubbles(): List<Bubble> {
        return store.map.values.toList()
    }

    override fun getBubbleById(id: Long): Bubble {
        return store.map[id] ?: throw IllegalArgumentException("Id not found: $id")
    }
}