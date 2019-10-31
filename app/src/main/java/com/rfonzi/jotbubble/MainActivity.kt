package com.rfonzi.jotbubble

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.TransitionListenerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.rfonzi.jotbubble.databinding.ActivityMainBinding
import com.rfonzi.jotbubble.databinding.LayoutAddBubbleBinding
import com.rfonzi.jotbubble.uimodel.MainIntent
import com.rfonzi.jotbubble.uimodel.MainUiModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.ldralighieri.corbind.view.clicks

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModel()
    val scope = MainScope()
    val bubbleAdapter = BubbleRecyclerViewAdapter()
    lateinit var mainBinding: ActivityMainBinding

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setSupportActionBar(toolbar)


        val bubbleRecycler = mainBinding.bubbleList

        bubbleRecycler.setHasFixedSize(true)
        bubbleRecycler.adapter = bubbleAdapter
        bubbleRecycler.layoutManager = LinearLayoutManager(this)

        viewModel.ui.observe(this) {
            render(it)
        }

        mainBinding.addBubbleLayout.contentsEditText.doOnTextChanged { text, start, count, after ->
            Log.d("asdf", text.toString())
        }
    }

    private fun render(mainUiModel: MainUiModel) {
        bubbleAdapter.addBubbles(mainUiModel.bubbles)

    }

    @ExperimentalCoroutinesApi
    fun MotionLayout.transitionChanges(): Flow<Int> {
        return callbackFlow {
            setTransitionListener(object : TransitionAdapter() {
                override fun onTransitionChange(
                    motionLayout: MotionLayout,
                    startId: Int,
                    endId: Int,
                    progress: Float
                ) {
                    offer(endId)
                }
            })

            awaitClose { setTransitionListener(null) }
        }

    }

}
