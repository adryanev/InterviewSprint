package dev.adryanev.sprint.interviewsprint.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

abstract class BaseListViewModel<Item : Any> : BaseViewModel() {

    var itemList: Flow<List<Item>?>? = null

}