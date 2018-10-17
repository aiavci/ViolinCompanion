package info.aiavci.violincompanion.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

/**
 * Created by ${$FULLNAME}
 * Version
 */
@Dao
interface NoteDao {

    @Query("SELECT * from note_table ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Query("DELETE FROM note_table")
    fun deleteAll()
}