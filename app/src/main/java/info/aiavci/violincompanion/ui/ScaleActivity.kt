package info.aiavci.violincompanion.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by ${$FULLNAME}
 * Version
 */
class ScaleActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}