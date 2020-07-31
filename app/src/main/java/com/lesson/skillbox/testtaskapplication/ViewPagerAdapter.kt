package com.lesson.skillbox.testtaskapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = TABS_COUNT

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