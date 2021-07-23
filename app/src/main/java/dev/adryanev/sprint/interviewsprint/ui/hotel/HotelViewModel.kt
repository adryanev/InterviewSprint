package dev.adryanev.sprint.interviewsprint.ui.hotel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import dev.adryanev.sprint.interviewsprint.data.entity.Hotel
import dev.adryanev.sprint.interviewsprint.data.repository.HotelRepository
import dev.adryanev.sprint.interviewsprint.ui.base.BaseListViewModel
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor(val hotelRepository: HotelRepository) : BaseListViewModel<Hotel>() {


    init{
        getHotelList()
    }

    private fun getHotelList() = launchPagingAsync(
        execute = {
            hotelRepository.getHotels()
        },
        onSuccess = {itemList = it}
    )
}