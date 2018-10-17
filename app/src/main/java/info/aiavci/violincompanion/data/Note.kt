package info.aiavci.violincompanion.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

/**
 * Created by ${$FULLNAME}
 * Version
 */
@Entity(tableName = "note_table")
class Note(
        @NonNull var noteTitle: String? = null,
        @NonNull var noteContent: String? = null,
        edittedId: Int? = null
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    init {
        if (edittedId != null) {
            id = edittedId
        }
    }
}