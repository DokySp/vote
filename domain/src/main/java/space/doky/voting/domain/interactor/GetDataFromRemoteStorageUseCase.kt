package space.doky.voting.domain.interactor

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonPrimitive
import space.doky.voting.domain.output.FirebaseInterface
import javax.inject.Inject

class GetDataFromRemoteStorageUseCase @Inject constructor(
    private val firebaseRepository: FirebaseInterface,
) {
    suspend operator fun invoke(key: String): Flow<String> {
        return firebaseRepository.start().map { jsonString ->
            val map = convertStringToJson(jsonString)
            map[key] ?: ""
        }
    }

    private fun convertStringToJson(jsonString: String): Map<String, String> =
        Json.decodeFromString(JsonObject.serializer(), jsonString.ifBlank { "{}" })
            .mapValues { (_, value) -> value.jsonPrimitive.contentOrNull ?: value.toString() }
}