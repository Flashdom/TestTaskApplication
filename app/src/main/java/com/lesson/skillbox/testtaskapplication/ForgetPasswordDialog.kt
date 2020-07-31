package com.lesson.skillbox.testtaskapplication

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ForgetPasswordDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return AlertDialog.Builder(requireActivity())
            .setTitle(getString(R.string.recovering_password))
            .setMessage("Please enter your email address here. If it exists in database we'll send you your password on this email")
            .setPositiveButton(getString(R.string.Ok)) { _, _ ->
                Toast.makeText(
                    requireContext(),
                    "Password successfully been sent",
                    Toast.LENGTH_LONG
                ).show()
                dismiss()
            }
            .setView(R.layout.dialog_layout)
            .create()

    }
}