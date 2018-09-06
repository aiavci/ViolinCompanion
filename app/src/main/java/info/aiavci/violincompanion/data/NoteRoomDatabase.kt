package info.aiavci.violincompanion.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by ${$FULLNAME}
 * Version
 */
@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteRoomDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {

        var INSTANCE: NoteRoomDatabase? = null

        internal fun getDatabase(context: Context): NoteRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(NoteRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                NoteRoomDatabase::class.java, "note_database")
                                .build()
                    }
                }
            }
            return INSTANCE!!
        }

        fun init(context: Context): NoteRoomDatabase =
                Room.databaseBuilder(context, NoteRoomDatabase::class.java, "note_database").build()
    }

}