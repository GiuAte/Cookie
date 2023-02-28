package com.giulioaterno.becomechef.Views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.giulioaterno.becomechef.R
import com.giulioaterno.becomechef.databinding.FragmentNotificationsBinding
import com.giulioaterno.becomechef.databinding.HomescreenPageBinding

class NotificationsFragment : Fragment() {

    private var bindingNotificationsFragment: FragmentNotificationsBinding? = null
    private val binding get() = bindingNotificationsFragment!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        bindingNotificationsFragment =
            FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_notificationsFragment_to_homeScreenFragment)
        }
    }
}