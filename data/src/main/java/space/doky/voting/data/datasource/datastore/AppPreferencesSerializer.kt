package space.doky.voting.data.datasource.datastore

import androidx.datastore.core.Serializer
import space.doky.voting.AppPreferences
import space.doky.voting.util.AppLog
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class AppPreferencesSerializer @Inject constructor(): Serializer<AppPreferences> {
    override val defaultValue: AppPreferences
        get() = AppPreferences.newBuilder().run {
            // Add proto datastore default value here.
            // You need to check default value of each types from link below
            // https://protobuf.dev/programming-guides/proto3/
            // e.g. isDebugMode = true
            build()
        }

    override suspend fun readFrom(input: InputStream): AppPreferences {
        return try {
            AppPreferences.parseFrom(input)
        } catch (exception: Exception) {
            // IOException | InvalidProtocolBufferException
            AppLog.e(TAG, "readFrom", exception.toString())
            defaultValue
        }
    }

    override suspend fun writeTo(t: AppPreferences, output: OutputStream) =
        t.writeTo(output)

    companion object {
        private val TAG = AppPreferencesSerializer::class.java.simpleName
    }
}