package com.lesson.skillbox.testtaskapplication

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onBackPressed() {
        AlertDialog.Builder(this@MainActivity)
            .setTitle(getString(R.string.warning))
            .setMessage(getString(R.string.check_exit))
            .setPositiveButton(getString(R.string.yes)) { _, _ -> finish() }
            .setNegativeButton(getString(R.string.no)) { it, _ -> it.dismiss() }
            .show()

    }

}