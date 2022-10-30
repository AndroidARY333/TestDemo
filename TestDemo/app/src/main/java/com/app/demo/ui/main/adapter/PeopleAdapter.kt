package com.app.demo.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.demo.R
import com.app.demo.model.DiffUtilPeopleModelItem
import com.app.demo.model.PeopleModel
import com.app.demo.utility.hideIfEmptyText
import com.app.demo.utility.loadImageFromUrl
import kotlinx.android.synthetic.main.list_item_user_repositories.view.*

class PeopleAdapter: ListAdapter<PeopleModel.PeopleModelItem, PeopleViewHolder>(
    DiffUtilPeopleModelItem()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_user_repositories, parent, false)
        return PeopleViewHolder(itemView = itemView)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: PeopleModel.PeopleModelItem?) {
     //   val owner = item?.owner
        itemView.image_view_owner?.loadImageFromUrl(item?.avatar)
        itemView.text_view_owner_name.text = item?.firstName//?.substringBefore(delimiter = "/")
        itemView.text_view_repository_name.hideIfEmptyText(item?.lastName)
        itemView.text_view_repository_description.hideIfEmptyText(item?.jobtitle)
    }
}