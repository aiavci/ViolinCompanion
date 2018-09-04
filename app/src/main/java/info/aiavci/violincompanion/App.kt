package info.aiavci.violincompanion

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

import timber.log.Timber

/**
 * Created by ${$FULLNAME}
 * Version
 */
open class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        AndroidThreeTen.init(this)
        Timber.d("App initialized")
    }

    private fun initTimber() = Timber.plant(Timber.DebugTree())
}