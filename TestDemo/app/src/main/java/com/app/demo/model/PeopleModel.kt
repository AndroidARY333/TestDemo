package com.app.demo.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

class PeopleModel : ArrayList<PeopleModel.PeopleModelItem>(){

   /* @SuppressLint("ParcelCreator")*/
    @Parcelize
    data class PeopleModelItem(
   //     @SerializedName("avatar")
        val avatar: String?,
    //    @SerializedName("createdAt")
        val createdAt: String?,
       /* @SerializedName("data")
        val `data`: Data?,*/
     //   @SerializedName("email")
        val email: String?,
     //   @SerializedName("favouriteColor")
        val favouriteColor: String?,
     //   @SerializedName("firstName")
        val firstName: String?,
     //   @SerializedName("fromName")
        val fromName: String?,
      //  @SerializedName("id")
        val id: String?,
     //   @SerializedName("jobtitle")
        val jobtitle: String?,
    //    @SerializedName("lastName")
        val lastName: String?,
     //   @SerializedName("to")
        val to: String?
    ):Parcelable
       /* : Parcelable {
        @SuppressLint("ParcelCreator")
        @Parcelize
        data class Data(
            @SerializedName("to")
            val body: String?,
            @SerializedName("to")
            val fromId: String?,
            @SerializedName("to")
            val id: String?,
            @SerializedName("to")
            val meetingid: String?,
            @SerializedName("to")
            val title: String?,
            @SerializedName("to")
            val toId: String?
        ) : Parcelable
    }*/
}

class DiffUtilPeopleModelItem: DiffUtil.ItemCallback<PeopleModel.PeopleModelItem>() {
    override fun areItemsTheSame(
        oldItem: PeopleModel.PeopleModelItem,
        newItem: PeopleModel.PeopleModelItem
    ): Boolean {
        return newItem.id == oldItem.id
    }

    override fun areContentsTheSame(
        oldItem: PeopleModel.PeopleModelItem,
        newItem: PeopleModel.PeopleModelItem
    ): Boolean {
        return newItem == oldItem
    }
}