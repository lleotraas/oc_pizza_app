package fr.lleotraas.oc_pizza_app.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import fr.lleotraas.oc_pizza_app.R
import fr.lleotraas.oc_pizza_app.databinding.FragmentLoginBinding
import fr.lleotraas.oc_pizza_app.retrofit.RetrofitInstance
import fr.lleotraas.oc_pizza_app.ui.activity.MainMenuActivity
import fr.lleotraas.oc_pizza_app.ui.viewmodel.MainViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private var isPasswordVisible = false
    private var isAccountNameAvailable = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        configureListener()
        enableValidateBtn()
        return binding.root
    }

    private fun configureListener() {
        binding.apply {
            val viewModel = MainViewModel(RetrofitInstance.userApi)
            fragmentLoginCreateAccountBtn.setOnClickListener {
                val fragmentManager = requireActivity().supportFragmentManager
                fragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.activity_main_container, CreateAccountFragment())
                }
            }

            fragmentLoginForgetPasswordBtn.setOnClickListener {

            }

            fragmentLoginValidateBtn.setOnClickListener {
                if (isAccountNameAvailable) {
                    viewModel.getUser(binding.fragmentLoginUsernameInput.text.toString()).observe(viewLifecycleOwner) { user ->
                        if (user.accountPassword == binding.fragmentLoginPasswordInput.text.toString()) {
                            startActivity(Intent(requireContext(), MainMenuActivity::class.java))
                        } else {
                            Toast.makeText(requireContext(), requireContext().resources.getString(R.string.fragment_login_password_dont_match), Toast.LENGTH_SHORT).show()
                        }

                    }
                } else {
                    Toast.makeText(requireContext(), requireContext().resources.getString(R.string.fragment_login_username_dont_exist), Toast.LENGTH_SHORT).show()
                }

            }

            fragmentLoginPasswordVisibilityBtn.setOnClickListener {
                isPasswordVisible = !isPasswordVisible
                if (isPasswordVisible) {
                    fragmentLoginPasswordInput.transformationMethod = HideReturnsTransformationMethod.getInstance()
                } else {
                    fragmentLoginPasswordInput.transformationMethod = PasswordTransformationMethod.getInstance()
                }
            }

            fragmentLoginUsernameInput.addTextChangedListener {
                if (it!!.isNotEmpty()) {
                    viewModel.accountNameExist(fragmentLoginUsernameInput.text.toString()).observe(viewLifecycleOwner) { isAccountNameExist ->
                        isAccountNameAvailable = isAccountNameExist
                        enableValidateBtn()

                    }
                }
            }

            fragmentLoginPasswordInput.addTextChangedListener {
                if (it!!.isNotEmpty()) {
                    enableValidateBtn()
                }
            }
        }
    }

    private fun enableValidateBtn() {
        binding.apply {
            fragmentLoginValidateBtn.isEnabled = fragmentLoginUsernameInput.text!!.isNotEmpty() &&
                    fragmentLoginPasswordInput.text!!.isNotEmpty()
        }
    }
}