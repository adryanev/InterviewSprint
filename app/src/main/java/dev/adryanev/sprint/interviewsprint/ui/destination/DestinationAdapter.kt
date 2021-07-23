package dev.adryanev.sprint.interviewsprint.ui.destination

import androidx.recyclerview.widget.DiffUtil
import dev.adryanev.sprint.interviewsprint.R
import dev.adryanev.sprint.interviewsprint.data.entity.Destination
import dev.adryanev.sprint.interviewsprint.databinding.DestinationFragmentBinding
import dev.adryanev.sprint.interviewsprint.databinding.ItemDestinationBinding
import dev.adryanev.sprint.interviewsprint.databinding.ItemHotelBinding
import dev.adryanev.sprint.interviewsprint.ui.base.BaseListAdapter
import dev.adryanev.sprint.interviewsprint.utils.BindingAdapters.setSingleClick

class DestinationAdapter (val itemClickListener: (Destination)-> Unit={}): BaseListAdapter<Destination, ItemDestinationBinding>(object :
    DiffUtil.ItemCallback<Destination>(){
    override fun areItemsTheSame(oldItem: Destination, newItem: Destination): Boolean {
        return oldItem.areaId == newItem.areaId
    }

    override fun areContentsTheSame(oldItem: Destination, newItem: Destination): Boolean {
        return oldItem == newItem
    }

}) {
    override fun getLayoutRes(viewType: Int): Int {
        return R.layout.item_destination
    }

    override fun bindFirstTime(binding: ItemDestinationBinding) {
        binding.apply {
            root.setSingleClick {
                item?.apply {
                    itemClickListener(this)
                }
            }
        }
    }
}