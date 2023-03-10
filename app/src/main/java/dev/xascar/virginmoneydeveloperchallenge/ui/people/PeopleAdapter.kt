package dev.xascar.virginmoneydeveloperchallenge.ui.people

import android.content.res.ColorStateList
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.xascar.virginmoneydeveloperchallenge.R
import dev.xascar.virginmoneydeveloperchallenge.data.model.people.PeopleModelItemModel
import dev.xascar.virginmoneydeveloperchallenge.databinding.ItemPeopleBinding

class PeopleAdapter(
    val peopleList: ArrayList<PeopleModelItemModel>,
    val clickListener: (PeopleModelItemModel) -> Unit
) : RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {


    inner class ViewHolder(private val view: ItemPeopleBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun setup(peopleModelItemModel: PeopleModelItemModel) {
            with(itemView) {
                Glide.with(context)
                    .load(peopleModelItemModel.avatar)
                    .placeholder(R.drawable.animate_loading)
                    .centerCrop()
                    .override(256,256)
                    .into(view.ivUserPic)
            }
            view.tvTitle.text = peopleModelItemModel.firstName
            view.tvDesc.text = peopleModelItemModel.jobtitle
            view.root.setOnClickListener {
                clickListener(peopleModelItemModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemPeopleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = peopleList.size

    override fun onBindViewHolder(holder: PeopleAdapter.ViewHolder, position: Int) {
        holder.setup(peopleList[position])
    }
}