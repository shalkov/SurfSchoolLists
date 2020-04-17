package ru.surfstudio.school_lesson_1.easyadapter

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder
import ru.surfstudio.school_lesson_1.DataModel
import ru.surfstudio.school_lesson_1.R

/**
 * Контроллер для отображения данных
 */
class TextItemController : BindableItemController<DataModel, TextItemController.Holder>() {

    var itemClickListener: ((DataModel) -> Unit) = {}

    override fun getItemId(data: DataModel) = data.id.hashCode().toString()

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    inner class Holder(viewGroup: ViewGroup) : BindableViewHolder<DataModel>(
        viewGroup,
        R.layout.item_controller_text
    ) {

        val textView: TextView = itemView.findViewById(R.id.text_view)
        val imageView: ImageView = itemView.findViewById(R.id.image_view)

        override fun bind(data: DataModel) {
            textView.text = data.name

            itemView.setOnClickListener {
                itemClickListener.invoke(data)
            }
        }
    }
}