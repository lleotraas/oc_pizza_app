package fr.lleotraas.oc_pizza_app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import fr.lleotraas.oc_pizza_app.R
import fr.lleotraas.oc_pizza_app.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        configureListener()
        return binding.root
    }

    private fun configureListener() {
        binding.apply {

            fragmentLoginCreateAccountBtn.setOnClickListener {
                val fragmentManager = requireActivity().supportFragmentManager
                fragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.activity_main_container, CreateAccountFragment())
                }
            }

            fragmentLoginForgetPasswordBtn.setOnClickListener {

            }

        }
    }
}