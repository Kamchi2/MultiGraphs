package com.example.multigraphs.base

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

abstract class BaseFlowFragment(
    @LayoutRes layoutId: Int,
    @IdRes private val idNavHostFragment: Int
) : Fragment(layoutId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment =
            childFragmentManager.findFragmentById(idNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

    }
}