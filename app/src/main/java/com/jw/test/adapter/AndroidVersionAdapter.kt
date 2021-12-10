package com.jw.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jw.test.databinding.ItemAndroidVersionBinding
import com.jw.test.model.AndroidVersion

class AndroidVersionAdapter(private val androiVerList: List<AndroidVersion>) :
    RecyclerView.Adapter<AndroidVersionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAndroidVersionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(androiVerList[position])
    }

    override fun getItemCount() = androiVerList.size

    class ViewHolder(private val binding: ItemAndroidVersionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(android: AndroidVersion) {
            binding.tvName.text = android.name
            binding.tvVersion.text = android.version
            binding.tvApiLevel.text = android.api
        }
    }
}