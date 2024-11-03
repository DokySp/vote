package space.doky.voting.domain.interactor

import kotlinx.coroutines.flow.Flow
import space.doky.voting.domain.output.AppPreferenceInterface
import javax.inject.Inject

class GetDataFromLocalStorageUseCase @Inject constructor(
    private val appPreference: AppPreferenceInterface,
) {
    fun getString(key: String): Flow<String> =
        appPreference.getStringData(key)

    fun getInt(key: String): Flow<Int> =
        appPreference.getIntData(key)

    fun getDouble(key: String): Flow<Double> =
        appPreference.getDoubleData(key)

    fun getBoolean(key: String): Flow<Boolean> =
        appPreference.getBooleanData(key)
}