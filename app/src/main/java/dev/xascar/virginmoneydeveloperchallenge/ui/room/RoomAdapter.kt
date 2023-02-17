package dev.xascar.virginmoneydeveloperchallenge.ui.room

import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.res.integerResource
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import dev.xascar.virginmoneydeveloperchallenge.R
import dev.xascar.virginmoneydeveloperchallenge.data.model.room.RoomModelItemModel
import dev.xascar.virginmoneydeveloperchallenge.databinding.ItemRoomBinding
import dev.xascar.virginmoneydeveloperchallenge.util.DateTimeUtil.toDate

class RoomAdapter(val roomList: ArrayList<RoomModelItemModel>) :
    RecyclerView.Adapter<RoomAdapter.ViewHolder>() {

    inner class ViewHolder(val item: ItemRoomBinding) : RecyclerView.ViewHolder(item.root) {
        fun setup(roomModelItemModel: RoomModelItemModel) {
            item.tvTitle.text = roomModelItemModel.id
            item.tvDate.text = roomModelItemModel.createdAt?.toDate("dd/MM/yyyy")
            if (roomModelItemModel.isOccupied == true){
                item.root.setCardBackgroundColor(ContextCompat.getColor(item.root.context,R.color.light_red))
                item.tvStatus.text =  "Occupied"
            }
            else {
                item.root.setCardBackgroundColor(ContextCompat.getColor(item.root.context,R.color.light_green))
                item.tvStatus.text = "Available"
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemRoomBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount() = roomList.size

    override fun onBindViewHolder(holder: RoomAdapter.ViewHolder, position: Int) {
        holder.setup(roomList[position])
    }

}
