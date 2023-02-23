package com.giulioaterno.becomechef

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.giulioaterno.becomechef.databinding.HomescreenPageBinding

@Suppress("UNREACHABLE_CODE")
class HomeScreenFragment: Fragment() {

    val searchView = binding.searchBar
    val searchIcon = binding.searchBarLogo

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
        searchIcon.setOnClickListener {
            if (searchView.visibility == View.GONE) {
                searchView.visibility = View.VISIBLE
            } else {
                searchView.visibility = View.GONE
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.personalAccount.setOnClickListener {
            findNavController().navigate(R.id.action_homeScreenFragment_to_profilePageFragment)
        }
    }

    private fun setRoundedIconRecyclerView(list: List<ProfileRoundedIcon>) {
        val adapterProfileRoundedIcon = ProfileRoundedIconAdapter(list)
        binding.bestChefRV.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterProfileRoundedIcon
        }
    }
}

