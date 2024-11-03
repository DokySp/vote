package space.doky.voting.presenter.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import space.doky.voting.domain.interactor.GetDataFromRemoteStorageUseCase
import space.doky.voting.domain.interactor.SetDataToRemoteStorageUseCase
import space.doky.voting.util.AppLog
import space.doky.voting.util.AppPolicy
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(
    private val getDataFromRemoteStorageUseCase: GetDataFromRemoteStorageUseCase,
    private val setDataToRemoteStorageUseCase: SetDataToRemoteStorageUseCase,
): ViewModel() {

    suspend fun getThumbUpFlow() =
        getDataFromRemoteStorageUseCase("thumb_up").map {
            "${AppPolicy.THUMB_UP_EMOJI} $it"
        }

    suspend fun setThumbUp(): String {
        val countString = getDataFromRemoteStorageUseCase("thumb_up").firstOrNull()
        // TODO: 0 초기화 코드 너무 위험함
        var count = 0

        try {
            if (!countString.isNullOrBlank()) {
                count = countString.toInt()
            }

            AppLog.i("===========", "setThumbUp", "count: $count")

            setDataToRemoteStorageUseCase("thumb_up", "${count.toInt() + 1}")
        } catch (_: Exception) { }
        return "${AppPolicy.THUMB_UP_EMOJI} $count"
    }

}
