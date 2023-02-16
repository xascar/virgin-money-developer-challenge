package dev.xascar.virginmoneydeveloperchallenge.ui.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.xascar.virginmoneydeveloperchallenge.data.model.room.RoomModelItemModel
import dev.xascar.virginmoneydeveloperchallenge.databinding.ItemRoomBinding
import dev.xascar.virginmoneydeveloperchallenge.util.DateTimeUtil.toDate

class RoomAdapter(val roomList: ArrayList<RoomModelItemModel>) :
    RecyclerView.Adapter<RoomAdapter.ViewHolder>() {

    inner class ViewHolder(val item: ItemRoomBinding) : RecyclerView.ViewHolder(item.root) {
        fun setup(roomModelItemModel: RoomModelItemModel) {
            item.tvTitle.text = roomModelItemModel.id
            item.tvDate.text = roomModelItemModel.createdAt?.toDate("dd/MM/yyyy")
            item.tvStatus.text =
                if (roomModelItemModel.isOccupied == true) "Occupied" else "Available"
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
