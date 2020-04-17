package ru.surfstudio.school_lesson_1.easyadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList
import ru.surfstudio.school_lesson_1.R
import ru.surfstudio.school_lesson_1.adapter.SecondActivity
import ru.surfstudio.school_lesson_1.getTestDate

/**
 * Главная активити
 */
class MainActivity : AppCompatActivity() {

    private val easyAdapter = EasyAdapter()

    private val recyclerView: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.recycler_view)
    }

    private val textController =
        TextItemController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        val itemList = ItemList.create().apply {
            addAll(getTestDate(), textController)
        }
        easyAdapter.setItems(itemList)

        textController.itemClickListener = {
            startActivity(Intent(this, SecondActivity::class.java))
            Toast.makeText(this, it.id.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun initRecyclerView() {
        recyclerView.adapter = easyAdapter
    }
}
