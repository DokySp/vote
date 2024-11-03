package space.doky.voting.util

import android.content.Context
import android.media.SoundPool

object SoundUtil {
    private val soundPool = SoundPool.Builder().build()
    private var cameraSoundId = 0
    private val onLoadCompleteListener = SoundPool.OnLoadCompleteListener { soundPool, sampleId, status ->
        soundPool.play(cameraSoundId, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    fun getCameraSound(context: Context, resourceId: Int) {
        cameraSoundId = soundPool.load(context, resourceId, 1)
        soundPool.setOnLoadCompleteListener(onLoadCompleteListener)
    }
}