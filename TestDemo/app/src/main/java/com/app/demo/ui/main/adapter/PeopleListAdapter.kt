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

class PeopleListAdapter(private val listener: CharacterItemListener): ListAdapter<PeopleModel.PeopleModelItem, PeopleListViewHolder>(
    DiffUtilPeopleModelItem()
) {
    interface CharacterItemListener {
        fun onClickedCharacter(peopleId: PeopleModel.PeopleModelItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_user_repositories, parent, false)
        return PeopleListViewHolder(itemView,listener)
    }

    override fun onBindViewHolder(holder: PeopleListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PeopleListViewHolder(itemView: View,
                       private val listener: PeopleListAdapter.CharacterItemListener) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {
    private lateinit var obj: PeopleModel.PeopleModelItem
    init {
        itemView.setOnClickListener(this)
    }
    fun bind(item: PeopleModel.PeopleModelItem?) {
        this.obj = item!!
        itemView.image_view_owner?.loadImageFromUrl(item?.avatar)
        itemView.text_view_owner_name.text = item?.firstName
        itemView.text_view_repository_name.hideIfEmptyText(item?.lastName)
        itemView.text_view_repository_description.hideIfEmptyText(item?.jobtitle)
    }
    override fun onClick(v: View?) {

        obj?.let { listener.onClickedCharacter(obj) }
    }
}