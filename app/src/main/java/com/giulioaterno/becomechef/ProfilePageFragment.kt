package com.giulioaterno.becomechef

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class ProfilePageFragment: Fragment() {

    private var bindingProfilePage: ProfilePageFragment? = null
    private val binding get() = bindingProfilePage!!
    private val viewModel: ProfilePageViewModel by viewModels()
}