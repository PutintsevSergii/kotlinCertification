package com.certification.putintsevsergii.certification.extensions

import android.arch.lifecycle.*
import android.support.v4.app.FragmentActivity
import com.certification.putintsevsergii.certification.ViewModelFactory

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(): T {
    val viewModelFactory = ViewModelFactory()
    return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
}


inline fun <reified T : ViewModel> FragmentActivity.withViewModel(body: T.() -> Unit): T {
    val vm = getViewModel<T>()
    vm.body()
    return vm
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(crossinline factory: () -> T): T {
    val vmFactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T = factory() as T
    }
    return ViewModelProviders.of(this, vmFactory)[T::class.java]
}

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(this, Observer(body))
}