package com.giulioaterno.becomechef

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.giulioaterno.becomechef.databinding.ProfilePageBinding
import com.google.gson.Gson

class ProfilePageFragment: Fragment() {

    private var bindingProfilePage: ProfilePageBinding? = null
    private val binding get() = bindingProfilePage!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingProfilePage = ProfilePageBinding.inflate(inflater, container, false)
        val bundle = arguments
        val myString = bundle?.getString("profile")
        val profile = Gson().fromJson(myString, ProfileRoundedIcon::class.java)
        setProfile(profile)
        return binding.root
    }

    //TODO Sistemare bug che non mi permette di tornare indietro al profilo..
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.settings.setOnClickListener {
            findNavController().navigate(R.id.action_profilePageFragment_to_profilePageSettingsFragment)
        }
        binding.appLogo.setOnClickListener {
            findNavController().navigate(R.id.action_profilePageFragment_to_homeScreenFragment)
        }
    }

    fun setProfile(profile: ProfileRoundedIcon) {
        binding.apply {
            profileImage.setImageResource(profile.image)
            profileName.text = profile.name
            postNumber.text = getString(R.string.post_count, profile.post)
            followersNumber.text = getString(R.string.followers_count, profile.followers)
            chefNumber.text = getString(R.string.chef_count, profile.chefs)
            bioTextview.text = profile.bio
        }
    }

}