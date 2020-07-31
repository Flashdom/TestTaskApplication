package com.lesson.skillbox.testtaskapplication

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

open class BaseFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    private lateinit var dialog: AlertDialog

    fun checkInternetAvailability() {
        dialog = AlertDialog.Builder(requireContext())
            .setPositiveButton(requireContext().getString(R.string.Ok)) { _, _ -> requireActivity().finish() }
            .setTitle(requireContext().getString(R.string.error))
            .setMessage(requireContext().getString(R.string.error_message))
            .setIcon(R.drawable.icon)
            .setCancelable(false).create()
        val connectivityManager =
            requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capability: NetworkCapabilities? =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capability == null || !capability.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)) {
            dialog.show()
        }
        try {
            connectivityManager
                .registerDefaultNetworkCallback(object :
                    ConnectivityManager.NetworkCallback() {
                    override fun onAvailable(network: Network) {
                        requireActivity().runOnUiThread { dialog.dismiss() }
                    }

                    override fun onLost(network: Network) {
                        requireActivity().runOnUiThread {
                            dialog.show()
                        }
                    }
                }
                )

        } catch (e: Exception) {
            e.printStackTrace()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (this::dialog.isInitialized && dialog.isShowing)
            dialog.dismiss()
    }


}