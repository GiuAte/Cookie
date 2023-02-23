package com.giulioaterno.becomechef

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.giulioaterno.becomechef.databinding.ProfilePageBinding

class ProfilePageFragment: Fragment() {

    private var bindingProfilePage: ProfilePageBinding? = null
    private val binding get() = bindingProfilePage!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingProfilePage = ProfilePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Sistemare bug che non mi permette di tornare indietro al profilo
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.settings.setOnClickListener{
            findNavController().navigate(R.id.action_profilePageFragment_to_profilePageSettingsFragment)
        }
        binding.appLogo.setOnClickListener{
            findNavController().navigate(R.id.action_profilePageFragment_to_homeScreenFragment)
        }
    }


}