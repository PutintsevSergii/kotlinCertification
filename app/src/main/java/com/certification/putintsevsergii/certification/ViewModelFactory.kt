package com.certification.putintsevsergii.certification

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.certification.putintsevsergii.certification.networking.NetworkManager

class ViewModelFactory
    : ViewModelProvider.Factory {

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TopChartsViewModel::class.java)) {
            val networkClient = NetworkManager.instance
            val repo = TopChartsRepository(networkClient)
            return TopChartsViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown View Model class name")
    }
}