package ru.surfstudio.school_lesson_1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.surfstudio.school_lesson_1.DataModel
import ru.surfstudio.school_lesson_1.R

class MainAdapter : RecyclerView.Adapter<MainAdapter.Holder>() {

    var onClickListener: ((DataModel) -> Unit) = {}

    private var data: List<DataModel> = listOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.item_list,
            viewGroup,
            false
        )
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.textView.text = data[position].name

        holder.imageView.setOnClickListener {
            onClickListener.invoke(data[position])
        }
    }

    fun setData(data: List<DataModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class Holder(view: View): RecyclerView.ViewHolder(view) {

        val textView: TextView = view.findViewById(R.id.text_view)
        val imageView: ImageView = view.findViewById(R.id.image_view)
    }
}