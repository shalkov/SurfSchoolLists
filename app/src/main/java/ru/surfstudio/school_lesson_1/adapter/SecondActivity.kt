package ru.surfstudio.school_lesson_1.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import ru.surfstudio.school_lesson_1.R
import ru.surfstudio.school_lesson_1.getTestDate

class SecondActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.recycler_view_second)
    }

    private var secondAdapter = SecondRecyclerViewAdapter(getTestDate())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView.adapter = secondAdapter
    }
}
