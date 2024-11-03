package space.doky.voting.domain.output

import kotlinx.coroutines.flow.Flow

interface AppPreferenceInterface {
    fun getStringData(key: String): Flow<String>
    suspend fun setStringData(key: String, value: String)

    fun getDoubleData(key: String): Flow<Double>
    suspend fun setDoubleData(key: String, value: Double)

    fun getBooleanData(key: String): Flow<Boolean>
    suspend fun setBooleanData(key: String, value: Boolean)

    fun getIntData(key: String): Flow<Int>
    suspend fun setIntData(key: String, value: Int)

    suspend fun clearAll()
}