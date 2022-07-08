package fr.lleotraas.oc_pizza_app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import fr.lleotraas.oc_pizza_app.R
import fr.lleotraas.oc_pizza_app.databinding.FragmentCreateAccountBinding
import fr.lleotraas.oc_pizza_app.retrofit.RetrofitInstance
import fr.lleotraas.oc_pizza_app.ui.viewmodel.MainViewModel

class CreateAccountFragment : Fragment() {

    private lateinit var binding : FragmentCreateAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateAccountBinding.inflate(inflater, container, false)
        enableValidateBtn()
        configureListener()
        return binding.root

    }

    private fun enableValidateBtn() {
        binding.apply {
            fragmentCreateAccountValidateBtn.isEnabled = fragmentCreateAccountAccountNameInput.text!!.isNotEmpty() &&
                    fragmentCreateAccountAccountPasswordInput.text!!.isNotEmpty() &&
                    fragmentCreateAccountFirstnameInput.text!!.isNotEmpty() &&
                    fragmentCreateAccountLastnameInput.text!!.isNotEmpty() &&
                    fragmentCreateAccountPhoneNumberInput.text!!.length == 12 &&
                    fragmentCreateAccountAddressInput.text!!.isNotEmpty()
        }

    }

    private fun configureListener() {
        binding.apply {
            fragmentCreateAccountValidateBtn.setOnClickListener {

                val viewModel = MainViewModel(RetrofitInstance.userApi)

                viewModel.accountNameExist(fragmentCreateAccountAccountNameInput.text.toString()).observe(viewLifecycleOwner) { isAccountNameExist ->
                    if (isAccountNameExist) {
                        fragmentCreateAccountAccountNameInput.setTextColor(ContextCompat.getColor(requireContext(), R.color.purple_500))
                    } else {
                        viewModel.addUser(
                            fragmentCreateAccountAccountNameInput.text.toString(),
                            fragmentCreateAccountAccountPasswordInput.text.toString(),
                            fragmentCreateAccountFirstnameInput.text.toString(),
                            fragmentCreateAccountLastnameInput.text.toString(),
                            fragmentCreateAccountPhoneNumberInput.text.toString(),
                            fragmentCreateAccountAddressInput.text.toString()
                        )
                        goToMainActivity()
                    }
                }
            }

            fragmentCreateAccountAccountNameInput.addTextChangedListener {
                if (it!!.isNotEmpty()) {
                    enableValidateBtn()
                }
            }

            fragmentCreateAccountAccountPasswordInput.addTextChangedListener {
                if (it!!.isNotEmpty()) {
                    enableValidateBtn()
                }
            }

            fragmentCreateAccountFirstnameInput.addTextChangedListener {
                if (it!!.isNotEmpty()) {
                    enableValidateBtn()
                }
            }

            fragmentCreateAccountLastnameInput.addTextChangedListener {
                if (it!!.isNotEmpty()) {
                    enableValidateBtn()
                }
            }

            fragmentCreateAccountPhoneNumberInput.addTextChangedListener {
                if (it!!.isNotEmpty()) {
                    enableValidateBtn()
                }
            }

            fragmentCreateAccountAddressInput.addTextChangedListener {
                if (it!!.isNotEmpty()) {
                    enableValidateBtn()
                }
            }
        }
    }

    private fun goToMainActivity() {
        val fragmentManager = requireActivity().supportFragmentManager
        fragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.activity_main_container, LoginFragment())
        }

        Toast.makeText(requireContext(), requireContext().resources.getString(R.string.fragment_create_account_successfully_created), Toast.LENGTH_SHORT).show()
    }
}