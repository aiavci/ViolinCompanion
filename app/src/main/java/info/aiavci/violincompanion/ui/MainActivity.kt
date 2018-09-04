package info.aiavci.violincompanion.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import info.aiavci.violincompanion.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView.adapter = MainAdapter(this)
    }
}
