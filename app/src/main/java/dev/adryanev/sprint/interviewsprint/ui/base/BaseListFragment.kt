package dev.adryanev.sprint.interviewsprint.ui.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

abstract class BaseListFragment<ViewBinding : ViewDataBinding, ViewModel : BaseListViewModel<Item>, Item : Any> :
    BaseFragment<ViewBinding, ViewModel>() {

    abstract val listAdapter: BaseListAdapter<Item, out ViewDataBinding>
    abstract val recyclerView: RecyclerView?


    open fun getLayoutManager(): RecyclerView.LayoutManager =
        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    var job: Job? = null
    open fun setup() {
        with(listAdapter) {
            recyclerView?.adapter = listAdapter

            with(viewModel) {
                job = lifecycleScope.launch {
                    itemList?.collectLatest {
                        submitList(it)
                    }
                }

            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        recyclerView?.adapter = null
    }

}