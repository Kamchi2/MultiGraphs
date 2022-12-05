package com.example.multigraphs.ui.fragments.sign.up

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.multigraphs.R
import com.example.multigraphs.base.BaseFragment
import com.example.multigraphs.data.locale.preferences.userdata.UserPreferencesData
import com.example.multigraphs.databinding.FragmentSignInBinding
import com.example.multigraphs.databinding.FragmentSignUpBinding
import javax.inject.Inject

class SignUpFragment  : BaseFragment<FragmentSignUpBinding>(R.layout.fragment_sign_up) {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData
    override val binding by viewBinding(FragmentSignUpBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    override fun setupListener() {
        clickSignUpConfirm()
        clickSignIn()
    }

    private fun clickSignUpConfirm() = with(binding) {
        signUpConfirmBtn.setOnClickListener {
            if (passwordEt.length()<8) {
                passwordEt.error = "Пароль не должен быть меньше 8 символов"
            } else if (!passwordEt.text.toString().equals(passwordRepeatEt.text.toString())) {
                passwordEt.error = "Пароли не совпадают"
                passwordRepeatEt.error = "Пароли не совпадают"
            } else {
                userPreferencesData.isAuthorized = true
                requireActivity()
                    .findNavController(R.id.nav_host_fragment)
                    .navigate(R.id.action_global_mainFlowFragment)
            }
        }
    }

    private fun clickSignIn() = with(binding) {
        signInBtn.setOnClickListener {
            findNavController().navigate(
                SignUpFragmentDirections.actionSignUpFragmentToSignInFragment()
            )
        }
    }
}