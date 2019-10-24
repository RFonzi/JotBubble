package com.rfonzi.libraries.persistence_inmemory

import com.rfonzi.libraries.persistence.GetBubble
import com.rfonzi.libraries.persistence.StoreBubble
import org.koin.dsl.module

val inMemoryModule = module {
    single { InMemoryStore }
    factory<GetBubble> { GetBubbleInMemory(get()) }
    factory<StoreBubble> { StoreBubbleInMemory(get()) }
}