package info.aiavci.violincompanion

import android.app.Application
import com.facebook.stetho.Stetho
import com.jakewharton.threetenabp.AndroidThreeTen
import info.aiavci.violincompanion.data.NoteRoomDatabase
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
        initDb()
        Stetho.initializeWithDefaults(this)
    }

    private fun initTimber() = Timber.plant(Timber.DebugTree())

    private fun initDb() {
        NoteRoomDatabase.init(this)
    }
}