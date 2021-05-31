package com.app.hiltretrofit.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.hiltretrofit.databinding.ActivityMainBinding
import com.app.hiltretrofit.main.view.adapter.CountryAdapter
import com.app.hiltretrofit.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpUI()
        setUpObservers()
    }

    private fun setUpUI() {
        binding.countryRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = CountryAdapter()
            addItemDecoration(DividerItemDecoration(this@MainActivity, LinearLayout.VERTICAL))
        }
    }

    private fun setUpObservers() {
        mainViewModel.getCountry().observe(this, { countryList ->
            countryList?.let {
                binding.countryRecyclerview.apply {
                    with(adapter as CountryAdapter) {
                        countries = it
                        notifyDataSetChanged()
                    }
                }
            }
        })
    }
}
