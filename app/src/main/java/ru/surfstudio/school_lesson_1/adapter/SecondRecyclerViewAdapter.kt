package ru.surfstudio.school_lesson_1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.surfstudio.school_lesson_1.DataModel
import ru.surfstudio.school_lesson_1.R

class SecondRecyclerViewAdapter(
    private val dataList: List<DataModel>
) : RecyclerView.Adapter<SecondRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_controller_text,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.textView.text = dataList[position].name
    }

    inner class Holder(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.text_view)
        val imageView: ImageView = view.findViewById(R.id.image_view)
    }
}