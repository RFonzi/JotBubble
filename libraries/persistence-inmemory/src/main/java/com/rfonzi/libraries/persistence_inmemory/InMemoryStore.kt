package com.rfonzi.libraries.persistence_inmemory

import com.rfonzi.libraries.model.Bubble

internal object InMemoryStore {
    val map = mutableMapOf<Long, Bubble>()
}