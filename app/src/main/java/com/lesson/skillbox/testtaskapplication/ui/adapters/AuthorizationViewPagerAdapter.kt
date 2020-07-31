package com.lesson.skillbox.testtaskapplication.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lesson.skillbox.testtaskapplication.ui.fragments.RegistrationFragment
import com.lesson.skillbox.testtaskapplication.ui.fragments.SignInFragment

class AuthorizationViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int =
        TABS_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SignInFragment()
            else -> RegistrationFragment()
        }
    }

    companion object {
        private const val TABS_COUNT = 2

    }

}