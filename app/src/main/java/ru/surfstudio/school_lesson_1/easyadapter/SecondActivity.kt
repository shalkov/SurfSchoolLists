package ru.surfstudio.school_lesson_1.easyadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList
import ru.surfstudio.school_lesson_1.R
import ru.surfstudio.school_lesson_1.getTestData

/**
 * Активити со списком на EasyAdapter
 */
class SecondActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private val easyAdapter = EasyAdapter()
    private val controller = ItemListController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initRecyclerView()
        initListeners()

        val itemList = ItemList()
        itemList.addAll(getTestData(), controller)
        easyAdapter.setItems(itemList)
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.second_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = easyAdapter
    }

    private fun initListeners() {
        controller.onClickListener = {
            Toast.makeText(this, it.id.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
