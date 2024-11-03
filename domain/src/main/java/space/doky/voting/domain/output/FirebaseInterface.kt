package space.doky.voting.domain.output

import kotlinx.coroutines.flow.Flow

interface FirebaseInterface {
    suspend fun start(): Flow<String>
    fun stop()
    fun sendData(value: String)
}