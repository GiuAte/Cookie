package com.giulioaterno.becomechef.Views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.giulioaterno.becomechef.R

class MyFridgeFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.myfridge_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }
}