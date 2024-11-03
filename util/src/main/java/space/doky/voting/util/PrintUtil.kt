package space.doky.voting.util

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.core.net.toFile
import androidx.print.PrintHelper

object PrintUtil {
    fun fromUri(context: Context, uri: Uri){
        // can use getActivity()
        val file = uri.toFile()
        val bitmap = BitmapFactory.decodeFile(file.absolutePath)
        val photoPrinter = PrintHelper(context)
        photoPrinter.printBitmap("Print", bitmap)
    }
}