package space.doky.voting.util

import android.content.Context
import android.content.Intent
import android.content.Intent.createChooser
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity

object ShareUtil {
    fun byUri(context: Context, uri: Uri) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "image/jpg"
            putExtra(Intent.EXTRA_STREAM, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        startActivity(context, createChooser(intent, "Share your image"), null)
    }
}