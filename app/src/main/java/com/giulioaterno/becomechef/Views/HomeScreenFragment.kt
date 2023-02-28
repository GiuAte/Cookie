package com.giulioaterno.becomechef.Views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.TransitionManager
import com.giulioaterno.becomechef.DataObject
import com.giulioaterno.becomechef.ProfileRoundedIcon
import com.giulioaterno.becomechef.Adapter.ProfileRoundedIconAdapter
import com.giulioaterno.becomechef.R
import com.giulioaterno.becomechef.databinding.HomescreenPageBinding
import com.google.gson.Gson

class HomeScreenFragment : Fragment() {

    private var bindingHomePage: HomescreenPageBinding? = null
    private val binding get() = bindingHomePage!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingHomePage = HomescreenPageBinding.inflate(inflater, container, false)
        setRoundedIconRecyclerView(DataObject.usernameList)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.personalAccount.setOnClickListener {
            findNavController().navigate(R.id.action_homeScreenFragment_to_PersonalProfilePageFragment2)
        }
        binding.notificationLogo.setOnClickListener {
            findNavController().navigate(R.id.action_homeScreenFragment_to_notificationsFragment)
        }
        binding.searchBarLogo.setOnClickListener {
            hideSearchText()
        }
    }

    private fun setRoundedIconRecyclerView(list: List<ProfileRoundedIcon>) {

        val bundle = Bundle()
        val adapterProfileRoundedIcon = ProfileRoundedIconAdapter(list) {
            val profile = Gson().toJson(it)
            bundle.putString("profile", profile)
            Navigation.findNavController(requireView())
                .navigate(R.id.action_homeScreenFragment_to_profilePageFragment2, bundle)
        }
        binding.bestChefRV.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterProfileRoundedIcon
        }
    }

    private fun hideSearchText() {
        if (binding.searchBar.visibility == View.GONE) {
            binding.searchBar.visibility = View.VISIBLE
        } else {
            binding.searchBar.visibility = View.GONE
        }
    }
}