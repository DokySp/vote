package space.doky.voting.domain.interactor

import space.doky.voting.domain.output.AppPreferenceInterface
import javax.inject.Inject

class SetDataToLocalStorageUseCase @Inject constructor(
    private val appPreference: AppPreferenceInterface,
) {
    suspend fun setString(key: String, value: String) {
        appPreference.setStringData(key, value)
    }

    suspend fun setInt(key: String, value: Int) {
        appPreference.setIntData(key, value)
    }

    suspend fun setDouble(key: String, value: Double) {
        appPreference.setDoubleData(key, value)
    }

    suspend fun setBoolean(key: String, value: Boolean) {
        appPreference.setBooleanData(key, value)
    }
}