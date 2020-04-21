package ru.surfstudio.school_lesson_1.adapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import ru.surfstudio.school_lesson_1.R
import ru.surfstudio.school_lesson_1.easyadapter.SecondActivity
import ru.surfstudio.school_lesson_1.getTestData

/**
 * Активити со списком на RecyclerView
 */
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()

        adapter.setData(getTestData())

        adapter.onClickListener = {
           startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.main_recycler_view)
        recyclerView.adapter = adapter
    }
}
