package com.app.hiltretrofit.main.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.hiltretrofit.databinding.CountryItemBinding
import com.app.hiltretrofit.main.Country
import javax.inject.Inject

class CountryAdapter @Inject constructor() : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    var countries: List<Country> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            CountryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(countries[position])

    override fun getItemCount(): Int = countries.size

    inner class ViewHolder(private val binding: CountryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.apply {
                country.also { (name, capital) ->
                    nameTextview.text = name
                    capitalTextview.text = capital
                }
            }
        }
    }
}