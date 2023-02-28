package com.giulioaterno.becomechef.Views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.giulioaterno.becomechef.DataObject
import com.giulioaterno.becomechef.ProfileRoundedIcon
import com.giulioaterno.becomechef.R
import com.giulioaterno.becomechef.databinding.PersonalProfilePageBinding

class PersonalProfilePageFragment : Fragment() {

    private var bindingProfilePage: PersonalProfilePageBinding? = null
    private val binding get() = bindingProfilePage!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingProfilePage = PersonalProfilePageBinding.inflate(inflater, container, false)
        setProfile(DataObject.usernameList.get(0))
        return binding.root
    }

    //TODO Sistemare bug che non mi permette di tornare indietro al profilo..
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.settings.setOnClickListener {
            findNavController().navigate(R.id.action_profilePageFragment_to_settingsFragment)
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