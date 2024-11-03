package space.doky.voting

import android.app.Application
import space.doky.voting.util.AppLog
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        AppLog.i(TAG, "onCreate", "app start")
    }

    companion object {
        private val TAG: String = MainApplication::class.java.simpleName
    }
}