package com.lesson.skillbox.testtaskapplication

import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_authorization.*


class AuthorizationFragment() : BaseFragment(R.layout.fragment_authorization) {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewPager.adapter = ViewPagerAdapter(requireActivity())
        checkInternetAvailability()
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = getString(R.string.authorization)
                }
                1 -> {
                    tab.text = getString(R.string.registration)
                }
            }
        }.attach()

    }


}
