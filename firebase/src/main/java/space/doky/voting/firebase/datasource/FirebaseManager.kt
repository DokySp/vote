package space.doky.voting.firebase.datasource

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import space.doky.voting.util.AppLog

object FirebaseManager {
    private val TAG = FirebaseManager::class.java.simpleName

    private val db = Firebase.database
    private var client: DatabaseReference? = null
    private var clientListener: ValueEventListener? = null

    fun init(appId: String) {
        client = db.getReference("appId::$appId")
        AppLog.d(TAG, "init", "app id: appId::$appId")
    }

    fun start(onDataChanged: (String) -> Unit) {
        clientListener = buildListener(onDataChanged)
        clientListener?.let { listener ->
            AppLog.d(TAG, "start", "start to listen")
            client?.addValueEventListener(listener)
        }
    }

    fun stop() {
        clientListener?.let { listener ->
            AppLog.d(TAG, "stop", "stop to listen")
            client?.removeEventListener(listener)
        }
    }

    fun send(value: String) {
        if (client == null) {
            AppLog.w(TAG, "sendMessage", "you should login first")
            return
        }

        client?.setValue(value)
        AppLog.d(TAG, "main", "client info: $client")
    }

    private fun buildListener(dataInterceptor: (String) -> Unit): ValueEventListener =
        object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue<String>()
                AppLog.d(TAG, "onDataChange", "value: $value")
                dataInterceptor(value ?: "")
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                AppLog.w(TAG, "onCancelled", "Failed to read value. ${error.toException()}")
            }
        }
}