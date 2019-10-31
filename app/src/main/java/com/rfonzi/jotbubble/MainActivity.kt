package com.rfonzi.jotbubble

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.rfonzi.jotbubble.databinding.ActivityMainBinding
import com.rfonzi.jotbubble.uimodel.MainUiModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.MainScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModel()
    val scope = MainScope()
    val bubbleAdapter = BubbleRecyclerViewAdapter()
    lateinit var mainBinding: ActivityMainBinding

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

}
