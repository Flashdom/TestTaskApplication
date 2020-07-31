package com.lesson.skillbox.testtaskapplication.ui.fragments

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.lesson.skillbox.testtaskapplication.R
import kotlinx.android.synthetic.main.fragment_registration.*


class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        registerButton.setOnClickListener {
            if (emailEditText.text.isNotBlank() && passwordEditText.text.isNotBlank())
                Toast.makeText(requireContext(), getString(R.string.success), Toast.LENGTH_LONG)
                    .show()
            else
                Toast.makeText(requireContext(), getString(R.string.failure), Toast.LENGTH_LONG)
                    .show()


        }
    }

}