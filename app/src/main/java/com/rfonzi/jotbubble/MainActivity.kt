package com.rfonzi.jotbubble

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.rfonzi.jotbubble.uimodel.MainUiModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModel()
    val bubbleAdapter = BubbleRecyclerViewAdapter()
    lateinit var fab: FloatingActionButton
    lateinit var motionLayout: MotionLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab = addFab
        motionLayout = root
        val bubbleRecycler = bubble_list

        bubbleRecycler.setHasFixedSize(true)
        bubbleRecycler.adapter = bubbleAdapter
        bubbleRecycler.layoutManager = LinearLayoutManager(this)

        viewModel.ui.observe(this) {
            render(it)
        }

        fab.setOnClickListener {

        }
    }

    private fun render(mainUiModel: MainUiModel) {
        bubbleAdapter.addBubbles(mainUiModel.bubbles)
    }

}
