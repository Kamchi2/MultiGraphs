package com.example.multigraphs.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding>(@LayoutRes layoutId: Int) :
    Fragment(layoutId) {

    protected abstract val binding: VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        setupRequest()
        setupSubscribe()
    }

    protected open fun initialize() {}

    protected open fun setupListener() {}

    protected open fun setupRequest() {}

    protected open fun setupSubscribe() {}

}