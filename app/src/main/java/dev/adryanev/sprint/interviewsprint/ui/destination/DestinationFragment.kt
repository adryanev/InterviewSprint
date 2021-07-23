package dev.adryanev.sprint.interviewsprint.ui.destination

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import dev.adryanev.sprint.interviewsprint.R
import dev.adryanev.sprint.interviewsprint.data.entity.Destination
import dev.adryanev.sprint.interviewsprint.databinding.DestinationFragmentBinding
import dev.adryanev.sprint.interviewsprint.ui.base.BaseListAdapter
import dev.adryanev.sprint.interviewsprint.ui.base.BaseListFragment
@AndroidEntryPoint
class DestinationFragment : BaseListFragment<DestinationFragmentBinding,DestinationViewModel, Destination>() {
    override val listAdapter: BaseListAdapter<Destination, out ViewDataBinding> by lazy {
        DestinationAdapter(itemClickListener = {
            toHotel()
        })
    }

    private fun toHotel() {
        findNavController().navigate(DestinationFragmentDirections.actionDestinationFragmentToHotelFragment())
    }

    override val recyclerView: RecyclerView
        get() = viewBinding.destinationRv
    override val viewModel: DestinationViewModel by viewModels()
    override val layoutId: Int
        get() = R.layout.destination_fragment


}