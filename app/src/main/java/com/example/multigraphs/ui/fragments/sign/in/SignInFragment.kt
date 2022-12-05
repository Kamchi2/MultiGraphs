package com.example.multigraphs.ui.fragments.sign.`in`

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.multigraphs.R
import com.example.multigraphs.base.BaseFragment
import com.example.multigraphs.data.locale.preferences.userdata.UserPreferencesData
import com.example.multigraphs.databinding.FragmentSignInBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment : BaseFragment<FragmentSignInBinding>(R.layout.fragment_sign_in) {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData
    override val binding by viewBinding(FragmentSignInBinding::bind)
    var email = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    override fun setupListener() {
        clickSignInConfirm()
        clickSignUp()
    }

    private fun clickSignInConfirm() = with(binding) {
        signInConfirmBtn.setOnClickListener {
            if (passwordEt.length()<8) {
                passwordEt.error = "Пароль не должен быть меньше 8 символов"
            } else {
                userPreferencesData.isAuthorized = true
                requireActivity()
                    .findNavController(R.id.nav_host_fragment)
                    .navigate(R.id.action_global_mainFlowFragment)
            }
        }
    }

    private fun clickSignUp() = with(binding) {
        signUpBtn.setOnClickListener {
            findNavController().navigate(
                SignInFragmentDirections.actionSignInFragmentToSignUpFragment()
            )
        }
    }
}