package com.giulioaterno.becomechef

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giulioaterno.becomechef.databinding.BestChefRecyclerViewItemBinding

class ProfileRoundedIconAdapter(
    val usernames: List<ProfileRoundedIcon>,
    private val onItemClicked: (ProfileRoundedIcon) -> Unit
) :
    RecyclerView.Adapter<ProfileRoundedIconAdapter.ProfileViewHolder>() {
    class ProfileViewHolder(var binding: BestChefRecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = BestChefRecyclerViewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProfileViewHolder(view)
    }

    override fun getItemCount(): Int {
        return usernames.size
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        with(holder) {
            with(usernames[position]) {
                holder.binding.myTextView.text = this.name
                holder.binding.profileImage.setImageResource(this.image)
                holder.binding.profileImage.setOnClickListener {
                    onItemClicked(this)
                }
            }
        }
    }

}