package dev.adryanev.sprint.interviewsprint.ui.destination

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.adryanev.sprint.interviewsprint.data.entity.Destination
import dev.adryanev.sprint.interviewsprint.data.repository.DestinationRepository
import dev.adryanev.sprint.interviewsprint.ui.base.BaseListViewModel
import javax.inject.Inject

@HiltViewModel
class DestinationViewModel @Inject constructor(val destinationRepository: DestinationRepository) : BaseListViewModel<Destination>() {

    init{
        getDestinationList()
    }

    private fun getDestinationList() = launchPagingAsync(
        execute = {
            destinationRepository.getDestinations()
        },
        onSuccess = {itemList = it}
    )
}