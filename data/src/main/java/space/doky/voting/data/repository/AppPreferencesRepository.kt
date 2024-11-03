package space.doky.voting.data.repository

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import space.doky.voting.AppPreferences
import space.doky.voting.domain.output.AppPreferenceInterface
import javax.inject.Inject

class AppPreferencesRepository @Inject constructor(
    private val appPreferences: DataStore<AppPreferences>
): AppPreferenceInterface {
    private val appPreferencesFlow: Flow<AppPreferences> = appPreferences.data
    override fun getStringData(key: String): Flow<String> =
        appPreferencesFlow.map {
            it.unifiedStringMap[key] ?: ""
        }

    override suspend fun setStringData(key: String, value: String) {
        appPreferences.updateData {
            it.toBuilder()
                .putUnifiedString(key, value)
                .build()
        }
    }

    override fun getDoubleData(key: String): Flow<Double> =
        appPreferencesFlow.map {
            it.unifiedDoubleMap[key] ?: 0.0
        }

    override suspend fun setDoubleData(key: String, value: Double) {
        appPreferences.updateData {
            it.toBuilder()
                .putUnifiedDouble(key, value)
                .build()
        }
    }

    override fun getBooleanData(key: String): Flow<Boolean> =
        appPreferencesFlow.map {
            it.unifiedBoolMap[key] ?: false
        }

    override suspend fun setBooleanData(key: String, value: Boolean) {
        appPreferences.updateData {
            it.toBuilder()
                .putUnifiedBool(key, value)
                .build()
        }
    }

    override fun getIntData(key: String): Flow<Int> =
        appPreferencesFlow.map {
            it.unifiedIntMap[key] ?: -1
        }

    override suspend fun setIntData(key: String, value: Int) {
        appPreferences.updateData {
            it.toBuilder()
                .putUnifiedInt(key, value)
                .build()
        }
    }

    override suspend fun clearAll() {
        appPreferences.updateData {
            it.toBuilder().clear().build()
        }
    }
}