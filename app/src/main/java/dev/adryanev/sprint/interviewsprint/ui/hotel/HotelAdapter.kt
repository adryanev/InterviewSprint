package dev.adryanev.sprint.interviewsprint.ui.hotel

import androidx.recyclerview.widget.DiffUtil
import dev.adryanev.sprint.interviewsprint.R
import dev.adryanev.sprint.interviewsprint.data.entity.Hotel
import dev.adryanev.sprint.interviewsprint.databinding.ItemHotelBinding
import dev.adryanev.sprint.interviewsprint.ui.base.BaseListAdapter
import dev.adryanev.sprint.interviewsprint.utils.BindingAdapters.setSingleClick

class HotelAdapter(val itemClickListener: (Hotel)-> Unit={}): BaseListAdapter<Hotel,ItemHotelBinding>(object :DiffUtil.ItemCallback<Hotel>(){
    override fun areItemsTheSame(oldItem: Hotel, newItem: Hotel): Boolean {
        return oldItem.ticketId == newItem.ticketId
    }

    override fun areContentsTheSame(oldItem: Hotel, newItem: Hotel): Boolean {
       return oldItem == newItem
    }

}) {
    override fun getLayoutRes(viewType: Int): Int {
        return R.layout.item_hotel
    }

    override fun bindFirstTime(binding: ItemHotelBinding) {
        binding.apply {
            root.setSingleClick {
                item?.apply {
                    itemClickListener(this)
                }
            }
        }
    }
}