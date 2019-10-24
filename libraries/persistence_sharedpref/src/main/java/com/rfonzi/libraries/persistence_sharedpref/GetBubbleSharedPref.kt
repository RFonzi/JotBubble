package com.rfonzi.libraries.persistence_sharedpref

import android.content.Context
import android.content.SharedPreferences
import com.rfonzi.libraries.model.Bubble
import com.rfonzi.libraries.model.Tag
import com.rfonzi.libraries.persistence.GetBubble

class GetBubbleSharedPref(context: Context) : GetBubble {

    private val sharedPrefs = context.getSharedPreferences("jotbubble", Context.MODE_PRIVATE)

    override fun getBubble(id: Long): Bubble {
        val contents = sharedPrefs.getString("$id-content", null) ?: throw IllegalArgumentException("Invalid id: $id")
        val tags = listOf<Tag>()

        return Bubble(id, contents, tags)
    }
}