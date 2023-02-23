package com.giulioaterno.becomechef

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.giulioaterno.becomechef.databinding.HomescreenPageBinding

class HomeScreenFragment: Fragment() {

    private var bindingHomePage: HomescreenPageBinding? = null
    private val binding get() = bindingHomePage!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingHomePage = HomescreenPageBinding.inflate(inflater, container, false)
        return binding.root
    }
}

