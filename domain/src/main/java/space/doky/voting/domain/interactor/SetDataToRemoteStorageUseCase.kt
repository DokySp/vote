package space.doky.voting.domain.interactor

import kotlinx.coroutines.flow.firstOrNull
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonPrimitive
import space.doky.voting.domain.output.FirebaseInterface
import javax.inject.Inject

class SetDataToRemoteStorageUseCase @Inject constructor(
    private val firebaseRepository: FirebaseInterface,
) {
    suspend operator fun invoke(key: String, value: String) {
        val rawJsonString = firebaseRepository.start().firstOrNull()
        val map = convertStringToMap(rawJsonString)

        map[key] = value

        val jsonString = convertMapToJsonString(map)
        firebaseRepository.sendData(jsonString)
    }

    private fun convertStringToMap(jsonString: String?) =
        Json.decodeFromString(JsonObject.serializer(), jsonValidator(jsonString))
            .mapValues { (_, value) -> value.jsonPrimitive.contentOrNull ?: value.toString() }.toMutableMap()

    private fun convertMapToJsonString(map: Map<String, String>) =
        Json.encodeToString(MapSerializer(String.serializer(), String.serializer()), map)

    private fun jsonValidator(jsonString: String?) =
        jsonString.run {
            if (isNullOrBlank()) {
                "{}"
            } else {
                this
            }
        }
}