package info.aiavci.violincompanion.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

/**
 * Created by ${$FULLNAME}
 * Version
 */
@Entity(tableName = "note_table")
class Note(name: String? = null) {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    var name: String? = null

    init {
        this.name = name
    }
}