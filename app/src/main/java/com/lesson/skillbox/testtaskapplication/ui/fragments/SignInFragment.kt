package com.lesson.skillbox.testtaskapplication.ui.fragments

import android.os.Bundle
import android.widget.Toast
import com.lesson.skillbox.testtaskapplication.R
import com.lesson.skillbox.testtaskapplication.ui.dialogs.ForgetPasswordDialog
import kotlinx.android.synthetic.main.fragment_sign_in.*


class SignInFragment() : BaseFragment(R.layout.fragment_sign_in) {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        signInButton.setOnClickListener {
            if (emailEditText.text.isNotBlank() && passwordEditText.text.isNotBlank())
                Toast.makeText(requireContext(), getString(R.string.success), Toast.LENGTH_LONG)
                    .show()
            else
                Toast.makeText(requireContext(), getString(R.string.failure), Toast.LENGTH_LONG)
                    .show()
        }
        forgotPasswordTextView.setOnClickListener {
            ForgetPasswordDialog()
                .show(childFragmentManager, "TAG")
        }
    }


}