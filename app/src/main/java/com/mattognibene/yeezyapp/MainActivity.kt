package com.mattognibene.yeezyapp

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mattognibene.yeezyapp.util.exhaustive
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var factory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, factory)[MainViewModel::class.java]
        viewModel.state.observe(this, Observer { state ->
            when (state) {
                MainViewModel.State.Loading -> {}
                is MainViewModel.State.GetQuoteSuccess -> yeezyQuote.text = state.quote
                is MainViewModel.State.GetQuoteFailure -> {
                    throw state.error
                }
            }.exhaustive
        })
        viewModel.loadKanyeQuote()
    }
}