package dev.adryanev.sprint.interviewsprint.ui.hotel

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import dev.adryanev.sprint.interviewsprint.R
import dev.adryanev.sprint.interviewsprint.data.entity.Hotel
import dev.adryanev.sprint.interviewsprint.databinding.HotelFragmentBinding
import dev.adryanev.sprint.interviewsprint.ui.base.BaseListAdapter
import dev.adryanev.sprint.interviewsprint.ui.base.BaseListFragment
@AndroidEntryPoint
class HotelFragment : BaseListFragment<HotelFragmentBinding,HotelViewModel,Hotel>() {
    override val listAdapter: BaseListAdapter<Hotel, out ViewDataBinding> by lazy {
        HotelAdapter(itemClickListener = {toNone()})
    }

    private fun toNone() {

    }

    override val recyclerView: RecyclerView
        get() = viewBinding.hotelRv
    override val viewModel: HotelViewModel by viewModels()
    override val layoutId: Int
        get() = R.layout.hotel_fragment


}