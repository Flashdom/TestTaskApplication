package com.lesson.skillbox.testtaskapplication.ui.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.lesson.skillbox.testtaskapplication.R
import com.lesson.skillbox.testtaskapplication.viewmodels.StartingFragmentViewModel

class StartingFragment : BaseFragment(R.layout.fragment_starting) {

    private val startingFragmentViewModel: StartingFragmentViewModel by viewModels()
    private lateinit var sharedPreferences: SharedPreferences

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        sharedPreferences = requireActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE)
        when (val tmp = sharedPreferences.getString("url", "").orEmpty()) {
            "" -> observe()
            "noUrl" -> {
                val action =
                    StartingFragmentDirections.actionStartingFragmentToAuthorizationFragment()
                findNavController().navigate(action)
            }
            else -> {
                val action =
                    StartingFragmentDirections.actionStartingFragmentToWebViewFragment(
                        tmp
                    )
                findNavController().navigate(action)

            }

        }


    }

    private fun observe() {


        startingFragmentViewModel.getUrl().observe(viewLifecycleOwner)
        {
            if (it != "noUrl") {
                sharedPreferences.edit().putString("url", it).apply()
                val action =
                    StartingFragmentDirections.actionStartingFragmentToWebViewFragment(
                        it
                    )
                findNavController().navigate(action)
            } else {
                sharedPreferences.edit().putString("url", "noUrl").apply()
                val action =
                    StartingFragmentDirections.actionStartingFragmentToAuthorizationFragment()
                findNavController().navigate(action)

            }
        }
    }


}

