package ru.surfstudio.school_lesson_1.easyadapter

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder
import ru.surfstudio.school_lesson_1.DataModel
import ru.surfstudio.school_lesson_1.R

/**
 * Контроллер с тестовыми данными
 */
class ItemListController : BindableItemController<DataModel, ItemListController.Holder>() {

    override fun getItemId(data: DataModel): String = data.name

    override fun createViewHolder(viewGroup: ViewGroup): Holder {
        return Holder(viewGroup)
    }

    inner class Holder(viewGroup: ViewGroup): BindableViewHolder<DataModel>(
        viewGroup,
        R.layout.item_list
    ) {

        private val textView: TextView = viewGroup.findViewById(R.id.text_view)
        private val imageView: ImageView = viewGroup.findViewById(R.id.image_view)

        override fun bind(data: DataModel) {
            textView.text = data.name
        }
    }
}