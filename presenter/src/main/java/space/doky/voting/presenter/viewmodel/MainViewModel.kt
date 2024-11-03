package space.doky.voting.presenter.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.firstOrNull
import space.doky.voting.domain.interactor.GetDataFromLocalStorageUseCase
import space.doky.voting.domain.interactor.SetDataToLocalStorageUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getDataFromLocalStorageUseCase: GetDataFromLocalStorageUseCase,
    private val setDataToLocalStorageUseCase: SetDataToLocalStorageUseCase,
): ViewModel() {

    suspend fun getSampleData(): String {
        val data = getDataFromLocalStorageUseCase.getString("sample_key").firstOrNull()

        // 아래처럼 다양한 타입을 불러올 수 있습니다.
        // key 값은 여러분이 원하는 대로 수정해서 사용하시면 됩니다!
        // getDataFromLocalStorageUseCase.getInt("sample_key")
        // getDataFromLocalStorageUseCase.getDouble("sample_key")
        // getDataFromLocalStorageUseCase.getBoolean("sample_key")

        // e.g.
        //  "isAppFirstRunning"과 "isUserLoggedIn" 두 개의 값을 Boolean으로, age를 Int로 저장된 값을 불러오고 싶은 경우
        //    val isAppFirstRunning = getDataFromLocalStorageUseCase.getBoolean("isAppFirstRunning")
        //    val isUserLoggedIn = getDataFromLocalStorageUseCase.getBoolean("isUserLoggedIn")
        //    val age = getDataFromLocalStorageUseCase.getInt("age")

        if (data == null) {
            return ""
        } else {
            return data
        }

        // Tip.
        // 코드에 빨간 줄이 뜨는 경우, Alt+Enter 를 눌러 확인해보세요.
        // 빌드 에러가 나면, 에러 메시지 혹은 로그캣을 꼭 확인해보세요.
    }

    suspend fun setSampleData(value: String) {
        setDataToLocalStorageUseCase.setString("sample_key", value)

        // 아래처럼 다양한 타입을 저장할 수 있습니다.
        // key 값은 여러분이 원하는 대로 수정해서 사용하시면 됩니다!
        // setDataToLocalStorageUseCase.setInt("sample_key", 123)
        // setDataToLocalStorageUseCase.setDouble("sample_key", 3.141592)
        // setDataToLocalStorageUseCase.setBoolean("sample_key", false)

        // e.g.
        //  "isAppFirstRunning"과 "isUserLoggedIn" 두 개의 값을 Boolean으로, age를 Int로 저장해서 쓰고 싶은 경우,
        //    setDataToLocalStorageUseCase.setBoolean("isAppFirstRunning", false)
        //    setDataToLocalStorageUseCase.setBoolean("isUserLoggedIn", true)
        //    setDataToLocalStorageUseCase.setInt("age", 17)
    }
}
